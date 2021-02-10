package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
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

    public List<User> selectListByIds(String ids){
        return userMapper.selectListByIds(ids);
    }
}
