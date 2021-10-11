package com.example.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Resource
    UserMapper userMapper;

    /*添加数据*/
    @PostMapping("/insertUser")
    public Result<?> insertUser(@RequestBody User user){
        userMapper.insert(user);
        return Result.success();
    }

    /*登录*/
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res=userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserId,user.getUserId()).eq(User::getUserPwd,user.getUserPwd()));
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success();
    }

    /*修改数据*/
    @PutMapping("/updateUser")
    public Result<?> updateUser(@RequestBody User user){
        userMapper.updateById(user);
        return Result.success();
    }

    /*删除数据*/
    @DeleteMapping("/deleteUser/{userId}")
    public Result<?> deleteUser(@PathVariable int userId){
        userMapper.deleteById(userId);
        return Result.success();
    }

    /*分页查询*/
    @GetMapping("/findPage")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(User::getUserName, search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

}
