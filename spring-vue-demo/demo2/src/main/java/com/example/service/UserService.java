package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /*根据id数据*/
    public User selectById(int userId){
        return userMapper.selectById(userId);
    }

    /*查询所有User数据*/
    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    /*添加数据*/
    public int insertUser(int userId,String userPwd,String userName){
        return userMapper.insertUser(userId,userPwd,userName);
    }

    /*根据userId删除数据*/
    public int deleteById(int userId){return userMapper.deleteById(userId);}

    /*根据userId修改密码*/
    public int updateById(int userId,String userPwd){return userMapper.updateById(userId,userPwd);}

}
