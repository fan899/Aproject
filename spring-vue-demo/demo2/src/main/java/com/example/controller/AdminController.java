package com.example.controller;

import com.example.common.Result;
import com.example.entity.Admin;
import com.example.entity.User;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /*登录*/
    @PostMapping("/login")
    public Result<?> login(@RequestBody Admin admin){
        Admin res=adminService.login(admin);
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success();
    }

}
