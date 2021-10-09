package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /*根据userId查询数据*/
    public User selectById (@Param("userId") int userId);

    /*查询所有数据*/
    public List<User> selectAll();

    /*添加数据*/
    public int insertUser (@Param("userId") int userId,@Param("userPwd") String userPwd,@Param("userName") String userName);

    /*根据adminId删除数据*/
    public int deleteById(@Param("userId") int userId);

    /*根据userId修改密码*/
    public int updateById(@Param("userId") int userId,@Param("userPwd") String userPwd);


}
