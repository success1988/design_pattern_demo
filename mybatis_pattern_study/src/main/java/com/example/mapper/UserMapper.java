package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectList(User user);

    List<User> selectListByIds(@Param("userIds") String ids);

    List<User> selectList(User user, RowBounds rowBounds);

}
