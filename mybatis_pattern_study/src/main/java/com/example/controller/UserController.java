package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/page")
    public List<User> queryByPage(){
        User userParam = new User();
        userParam.setRealName("张三");
        return userService.selectList(userParam,new RowBounds(2,2));
    }


    @RequestMapping("/list")
    public List<User> queryUsers(){
        User userParam = new User();
        userParam.setRealName("张三");
        return userService.selectList(userParam);
    }

    @RequestMapping("/ids")
    public List<User> queryUsersByIds(){
        //${}的用例
        String ids = "1,2,3";
        return userService.selectListByIds(ids);
    }

}
