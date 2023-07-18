package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/*
mapper 代理开发
 */
public class MybatisDemo1 {
    public static void main(String[] args) throws IOException {
        //load mybatis core configuration file, get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //get sqlSession object and use it to execute sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //execute sql, passing namespace.id which is defined in the mapper
        //but still exists hard-coded problems

        //List<User> users = sqlSession.selectList("test.selectAll");

        /*
        These two methods are the same, but the mapper will be better as it is extensive
         */

        //获取usermapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);


        //release resources, or it will lower the efficiency and violate ACID
        sqlSession.close();
    }
}
