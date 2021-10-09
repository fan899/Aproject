package com.example.service;

import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    /*查询所有数据*/
    public Admin selectById(int adminId){
        return adminMapper.selectById(adminId);
    }

    /*public int selectByIdPwd(String username,String password){
        return adminMapper.selectByIdPwd(username,password);
    }*/

    /*添加数据*/
    public List<Admin> selectAll(){
        return adminMapper.selectAll();
    }

    /*public int insertUser(){
        return adminMapper.insertUser();
    }*/

    /*添加数据*/
    public int insertAdmin(int adminId,String adminPwd){
        return  adminMapper.insertAdmin(adminId,adminPwd);
    }

    /*根据adminId删除数据*/
    public int deleteById(int adminId){
        return adminMapper.deleteById(adminId);
    }

    /*根据adminId修改密码*/
    public int updateById(int adminId,String adminPwd){
        return adminMapper.updateById(adminId,adminPwd);
    }
}
