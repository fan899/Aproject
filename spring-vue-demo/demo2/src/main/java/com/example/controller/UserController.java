package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    UserService userService;

    /*根据userId查询数据*/
    @RequestMapping("/selectById/{userId}")
    public @ResponseBody
    User selectById(@PathVariable int userId){
        User user = userService.selectById(userId);
        return user;
    }

    /*查询所有User数据*/
    @RequestMapping("/selectAll")
    public @ResponseBody
    List<User> selectAll(){
        List<User> users = userService.selectAll();
        return users;
    }

    /*添加数据*/
    @RequestMapping("/insertUser/{userId}&{userPwd}&{userName}")
    public @ResponseBody int insertUser(@PathVariable int userId,@PathVariable String userPwd,@PathVariable String userName){
        int i = userService.insertUser(userId,userPwd,userName);
        System.out.println("成功添加"+i+"条编号为"+userId+"的数据");
        return userId;
    }

    /*根据userId删除数据*/
    @RequestMapping("/deleteById/{userId}")
    public @ResponseBody int deleteById(@PathVariable int userId){
        int i = userService.deleteById(userId);
        System.out.println("成功删除"+i+"条编号为"+userId+"的数据");
        return userId;
    }

    /*根据userId修改密码*/
    @RequestMapping("/updateById/{userId}&{userPwd}")
    public @ResponseBody int updateById(@PathVariable int userId,@PathVariable String userPwd){
        int i = userService.updateById(userId,userPwd);
        System.out.println("成功修改编号为"+userId+"的数据");
        return userId;
    }

}
