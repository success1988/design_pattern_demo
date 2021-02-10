package com.example.plugin;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * @Title：鹰眼中的MyBatis插件 （简化版）
 * @Author：wangchenggong
 * @Date 2021/2/10 9:45
 * @Description
 * @Version
 */
@Intercepts({@Signature(
        type = Executor.class,  //拦截哪个类
        method = "update",      //拦截哪个方法
        args = {MappedStatement.class, Object.class}  //拦截具体哪个方法(由于方法有重载，需要参数列表来区分)
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
/*@Intercepts({@Signature(
                type = StatementHandler.class,
                method = "query",
                args = {Statement.class, ResultHandler.class}
        ),@Signature(
                type = StatementHandler.class,
                method = "update",
                args = {Statement.class}
        ),@Signature(
                type = StatementHandler.class,
                method = "batch",
                args = {Statement.class}
                )
})*/
public class MybatisSqlPrintPlugin implements Interceptor {

    public static final Logger logger = LoggerFactory.getLogger(MybatisSqlPrintPlugin.class);
    private Properties properties;

    private static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT_WITH_MILLIS = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
    public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public MybatisSqlPrintPlugin() {
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        //如果不是CachingExecutor本尊（而是由org.apache.ibatis.plugin.Plugin#wrap方法返回的代理对象），则直接放行，避免两次打印sql
        if(!(target instanceof CachingExecutor)){
            return invocation.proceed();
        }
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement)args[0];
        Object parameter = args[1];
        String sqlId = mappedStatement.getId();
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        if (args.length == 6) {
            boundSql = (BoundSql)args[5];
        }

        Configuration configuration = mappedStatement.getConfiguration();
        Object returnValue = null;
        long startTime = System.currentTimeMillis();
        returnValue = invocation.proceed();
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;

        String sqlInfo = getSql(configuration, boundSql, sqlId, runTime);
        //打印sql语句以及执行耗时
        logger.info(sqlInfo);

        return returnValue;
    }

    public static String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder(100);
        str.append(sqlId);
        str.append(":");
        str.append(sql);
        str.append(":");
        str.append(time);
        str.append("ms");
        return str.toString();
    }

    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            value = "'" + ISO_DATETIME_FORMAT.format(obj) + "'";
        } else if (obj != null) {
            value = obj.toString();
        } else {
            value = "";
        }

        return value;
    }

    public static String showSql(Configuration configuration, BoundSql boundSql) {

        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql();
        sql = boundSql.getSql().replaceAll("[\\s]+", " ");

        try {
            if (parameterMappings.size() > 0 && parameterObject != null) {
                TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                    sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));
                } else {
                    MetaObject metaObject = configuration.newMetaObject(parameterObject);
                    Iterator iterator = parameterMappings.iterator();

                    while(iterator.hasNext()) {
                        ParameterMapping parameterMapping = (ParameterMapping)iterator.next();
                        String propertyName = parameterMapping.getProperty();
                        Object obj;
                        if (metaObject.hasGetter(propertyName)) {
                            obj = metaObject.getValue(propertyName);
                            sql = sql.replaceFirst("\\?", getParameterValue(obj));
                        } else if (boundSql.hasAdditionalParameter(propertyName)) {
                            obj = boundSql.getAdditionalParameter(propertyName);
                            sql = sql.replaceFirst("\\?", getParameterValue(obj));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sql;
    }

    @Override
    public void setProperties(Properties prop) {
        this.properties = prop;
    }
}
