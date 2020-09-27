package com.success.dataAccess.service;

import java.util.List;

/**
 * @Title：数据操作服务接口
 * @Author：wangchenggong
 * @Date 2020/9/26 22:39
 * @Description
 * @Version
 */
public interface BaseService<K, T>{

    public T selectByPrimaryKey(K k);

    public List<T> selectList(T t);

    public int insert(T t);

    public int deleteByPrimaryKey(K k);

    public int updateByPrimaryKeySelective(T t);
}
