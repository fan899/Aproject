package com.example.mapper;

import com.example.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    /*根据adminId查询数据*/
    public Admin selectById(@Param("adminId") int adminId);

    /*查询所有数据*/
    public List<Admin> selectAll();

    /*添加数据*/
    public int insertAdmin(@Param("adminId") int adminId,@Param("adminPwd") String adminPwd);

    /*根据adminId删除数据*/
    public int deleteById(@Param("adminId") int adminId);

    /*根据adminId修改密码*/
    public int updateById(@Param("adminId") int adminId,@Param("adminPwd") String adminPwd);

    /*登录验证adminId和密码*/
    public int login(@Param("adminId") int adminId,@Param("adminPwd") String adminPwd);

}
