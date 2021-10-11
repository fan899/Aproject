package com.example.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    /*登录*/
    public Admin login(Admin admin){
        Admin res=adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getAdminId,admin.getAdminId()).eq(Admin::getAdminPwd,admin.getAdminPwd()));
        return res;
    }

}
