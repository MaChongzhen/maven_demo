package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
    1. create mapper class
    2. design methods
    3. create corresponding configuration file
        set namespace
    4. sql
    5. we have already set the mybatis configuration as package scanning,
        do not touch mybatis
 */

public interface BrandMapper {
    /*
    select all
     */
    public List<Brand> selectAll();

    /*
    look up the details
     */
    Brand selectById(int id);

/*
           条件查询

           1.散装参数：方法中多个参数，@param后加sql占位符中的名称
           2.对象参数
           3.map集合参数
 */
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName,
//    @Param("brandName") String brandName);

//       List<Brand> selectByCondition(Brand brand);



    List<Brand> selectByCondition(Map map);


    /*
    添加
     */
    void add(Brand brand);

    /*
    modify
     */
    int update(Brand brand);


    void deleteById(int id);

    /*
    批量删除
     */



    /*
    如果不想用array，
    void deleteByIds(@Param("ids") int[] ids)
     */

    /*
    在传递多个参数时，例如带Param的，mybatis会自动进行把参数封装成map

    map.put(arg0, value1);
    map.put(param1, value1);
    map.put(arg1, value2);
    map.put(param2, value2);
     */
    void deleteByIds(int[] ids);

}


