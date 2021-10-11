package com.example.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Admin;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /*添加数据*/
    public int insertUser(User user){
        return  userMapper.insert(user);
    }

    /*分页查询*/
    public Page<User> findPage(Integer pageNum, Integer pageSize, LambdaQueryWrapper<User> wrapper){
        return userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    /*删除数据*/
    public int deleteUser(int userId){
        return userMapper.deleteById(userId);

    }

    /*修改数据*/
    public int updateUser(User user){
        return userMapper.updateById(user);
    }

    /*登录*/
    public User login( User user){
        User res=userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserId,user.getUserId()).eq(User::getUserPwd,user.getUserPwd()));
        return res;
    }

}
