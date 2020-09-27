package com.success.dataAccess.dao;

import java.util.List;

/**
 * @Title：继承Mapper
 * @Author：wangchenggong
 * @Date 2020/9/26 22:34
 * @Description
 * @Version
 */
public interface BaseMapper<K, T> {

    public T selectByPrimaryKey(K k);

    public List<T> selectList(T t);

    public int insert(T t);

    public int deleteByPrimaryKey(K k);

    public int updateByPrimaryKeySelective(T t);
}
