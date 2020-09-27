package com.success.dataAccess.service;

import com.success.dataAccess.dao.BaseMapper;

import java.util.List;

/**
 * @Title：数据操作服务基类
 * @Author：wangchenggong
 * @Date 2020/9/26 22:42
 * @Description 增删改查的实现需要两步:1.获取对应的Mapper 2.调用Mapper对应的方法实现增删改查
 * @Version
 */
public abstract class AbstractService<K,T> implements BaseService<K,T>{

    protected abstract BaseMapper<K,T> getBaseMapper();


    @Override
    public T selectByPrimaryKey(K k){
        return (T) getBaseMapper().selectByPrimaryKey(k);
    }

    @Override
    public List<T> selectList(T t){
        return getBaseMapper().selectList(t);
    }


    @Override
    public int deleteByPrimaryKey(K k){
        return getBaseMapper().deleteByPrimaryKey(k);
    }

    @Override
    public int insert(T t){
        return getBaseMapper().insert(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t){
        return getBaseMapper().updateByPrimaryKeySelective(t);
    }

}
