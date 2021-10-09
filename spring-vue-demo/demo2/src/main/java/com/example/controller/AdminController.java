package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /*根据adminId查询数据*/
    @RequestMapping("/selectById/{adminId}")
    public  @ResponseBody
    Admin selectById(@PathVariable int adminId){
        Admin sel = adminService.selectById(adminId);
        System.out.println(sel);
        return sel;
    }

    /*查询所有数据*/
    @RequestMapping("/selectAll")
    public  @ResponseBody List<Admin> selectAll(){
        List<Admin> sel = adminService.selectAll();
        System.out.println(sel);
        return sel;
    }

    /*添加数据*/
    @RequestMapping("/insertAdmin/{adminId}&{adminPwd}")
    public  @ResponseBody int insertAdmin(@PathVariable int adminId,@PathVariable String adminPwd){
        int i = adminService.insertAdmin(adminId, adminPwd);
        System.out.println("成功添加"+i+"条编号为"+adminId+"的数据");
        return adminId;
    }

    /*根据adminId删除数据*/
    @RequestMapping("/deleteById/{adminId}")
    public  @ResponseBody int deleteById(@PathVariable int adminId){
        int i = adminService.deleteById(adminId);
        System.out.println("成功删除"+i+"条编号为"+adminId+"的数据");
        return adminId;
    }

    /*根据adminId修改密码*/
    @RequestMapping("/updateById/{adminId},{adminPwd}")
    public  @ResponseBody int updateById(@PathVariable int adminId,@PathVariable String adminPwd){
        adminService.updateById(adminId, adminPwd);
        System.out.println("成功修改编号为"+adminId+"的数据");
        return adminId;
    }

    /*登录验证*/
    @RequestMapping("/login/{adminId},{adminPwd}")
    public @ResponseBody int login(@PathVariable int adminId,@PathVariable String adminPwd){
        int login = adminService.login(adminId, adminPwd);
        return login;
    }
}
