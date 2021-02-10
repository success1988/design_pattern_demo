package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public List<User> selectList(User user){
        return userMapper.selectList(user);
    }

    public List<User> selectList(User user,RowBounds rowBounds){
        return userMapper.selectList(user,rowBounds);
    }

    public List<User> selectListByIds(String ids){
        return userMapper.selectListByIds(ids);
    }


    public List<User> selectListByPage(User user, RowBounds rowBounds){
        return userMapper.selectList(user, rowBounds);
    }
}
