package com.itheima;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.itheima.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //load mybatis core configuration file, get SqlSessionFactory
        String resource = "com/itheima/mapper/UserMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //get sqlSession object and use it to execute sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //execute sql, passing namespace.id which is defined in the mapper
        //but still exists hard-coded problems
        List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);


        //release resources
        sqlSession.close();
    }
}
