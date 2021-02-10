package com.example.plugin;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;

/**
 * @Title：MyBatis分页插件（仅支持mysql）
 * @Author：wangchenggong
 * @Date 2021/2/10 14:16
 * @Description
 * @Version
 */
@Intercepts({
        @Signature(
                type = Executor.class, // 目标类
                method = "query", // 目标方法
                args ={MappedStatement.class,
                        Object.class, RowBounds.class, ResultHandler.class}
        )
})
public class MySqlPagingPlugin implements Interceptor {


    private static final Integer MAPPED_STATEMENT_INDEX = 0;
    private static final Integer PARAMETER_INDEX = 1;
    private static final Integer ROW_BOUNDS_INDEX = 2;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        RowBounds rb = (RowBounds) args[ROW_BOUNDS_INDEX];
        // 无需分页
        if (rb == RowBounds.DEFAULT) {
            return invocation.proceed();
        }

        // 将原 RowBounds 参数设为 RowBounds.DEFAULT，关闭 MyBatis 内置的分页机制
        args[ROW_BOUNDS_INDEX] = RowBounds.DEFAULT;
        MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
        BoundSql boundSql = ms.getBoundSql(args[PARAMETER_INDEX]);

        // 【核心原理】获取 SQL 语句，拼接 limit 语句
        String sql = boundSql.getSql();
        if(sql.contains("LIMIT")){
            sql = StringUtils.substringBeforeLast(sql, "LIMIT").trim();
        }
        String limit = String.format(
                "LIMIT %d,%d", rb.getOffset(), rb.getLimit());
        sql = sql + " " + limit;


        // 创建一个 StaticSqlSource，并将拼接好的 sql 传入
        SqlSource sqlSource = new StaticSqlSource(
                ms.getConfiguration(), sql, boundSql.getParameterMappings());

        // MappedStatement没有提供setSqlSource方法
        // 只能通过反射获取并设置 MappedStatement 的 sqlSource 字段
        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        field.set(ms, sqlSource);

        // 执行被拦截方法
        return invocation.proceed();
    }
}
