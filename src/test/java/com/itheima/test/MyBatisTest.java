package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void TestSelectAll() throws IOException {

        // get sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //get sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brands =  brandMapper.selectAll();

        System.out.println(brands);

        sqlSession.close();
    }
        @Test
    public void TestSelectById() throws IOException {


        int id = 1;


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);

        sqlSession.close();
    }




    @Test
    public void TestSelectByCondition() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        int status = 1;
        String brandName = "华为";
        String companyName = "华为";



/*
模糊选择处理
 */
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";



        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);

        /*
        map 制作过程
         */

        Map map = new HashMap();
        map.put("status", status);
//        map.put("companyName", companyName);
//        map.put("brandName", brandName);




        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);





//        List<Brand> brands= brandMapper.selectByCondition(1, "%华为%", "%华为%");




        /*
        sql参数名和实例中的属性名称匹配就可以
         */

//        List<Brand> brands= brandMapper.selectByCondition(brand);



        /*
        map 中键名和参数名一致就可以
         */
        List<Brand> brands= brandMapper.selectByCondition(map);






        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void TestInsert() throws IOException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        int status = 1;
        String brandName = "博导手机";
        String description = "手机中的强者";
        String companyName = "博导";
        int ordered = 101;

        Brand brand = new Brand();
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);


        SqlSession sqlSession = sqlSessionFactory.openSession();


        /*
           we can set autocommit true when we get sqlsession to avoid committing manually
         */
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);



        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        /*
        commit transaction
         */
        sqlSession.commit();

        sqlSession.close();
    }



    @Test
    public void TestInsert1() throws IOException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        int status = 1;
        String brandName = "博e手机";
        String description = "手机中的laji";
        String companyName = "e导";
        int ordered = 101;

        Brand brand = new Brand();
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);


        SqlSession sqlSession = sqlSessionFactory.openSession();


        /*
           we can set autocommit true when we get sqlsession to avoid committing manually
         */
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);



        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);


        Integer integer = brand.getId();
        System.out.println(integer);

        /*
        commit transaction
         */
        sqlSession.commit();


        sqlSession.close();
    }


    @Test
    public void Modify() throws IOException {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int status = 30;
//        String brandName = "ee手机";
//        String description = "纯纯laji";
//        String companyName = "ee";
//        int ordered = 505;

        Brand brand = new Brand();
        brand.setId(7);
        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);



        System.out.println(brandMapper.update(brand));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void TestDelete() throws IOException {

        // get sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //get sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(7);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void TestDeleteIds() throws IOException {

        // get sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //get sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int array[] = new int[2];
        array[0] = 2;
        array[1] = 6;


        brandMapper.deleteByIds(array);

        sqlSession.commit();

        sqlSession.close();
    }
}


