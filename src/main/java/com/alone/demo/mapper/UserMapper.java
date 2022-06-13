package com.alone.demo.mapper;

import com.alone.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 实现从UserMapper注入到springBoot中
@Mapper
public interface UserMapper {

    // mybatis 提供的注解
    @Select("SELECT * FROM sys_user")
    List<User> findAll();


    @Insert("INSERT INTO sys_user(username, password, nickname, email) VALUES " +
            "(#{username}, #{password}, #{nickname}, #{email})")
    int insert(User user);

    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * from sys_user LIMIT #{pageNum}, #{pageSize};")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from sys_user")
    Integer selectTotal();
}
