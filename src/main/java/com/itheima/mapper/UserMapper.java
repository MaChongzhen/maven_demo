package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {

    //create a method with the corresponding name in the usermapper xml file
    //mybatis will connect these two things together for us

    List<User> selectAll();

    User UserbyID();
}
