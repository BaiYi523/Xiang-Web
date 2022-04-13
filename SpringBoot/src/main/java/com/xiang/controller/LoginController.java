package com.xiang.controller;


import com.xiang.entity.User;
import com.xiang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/forget")
    public String forget() {
        return "forget";
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("userpwd") String userpwd, Model model, HttpSession session) {
        //首先查询数据库有没有该用户
        User userName = userMapper.querUserName(username);
        //没有的话走下面这个if
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        //判断是否为 userName为空 并且 username为整数类型
        if (userName == null && pattern.matcher(username).matches()) {
            //如果为整数则查询与QQ有关联的
            User userByQq = userMapper.queryUserByQq(new BigInteger(username));
            //如果 userByQq为空，则说明没有该用户
            if (userByQq == null) {
                model.addAttribute("msg","平台没有该用户");
                return "/login";
            }else {
                User user=userMapper.queryUserById2(new BigInteger(username),userpwd);
                //若果 user == null，说明账号或密码错误,有数据则登录
                if (user == null){
                    model.addAttribute("msg","账号或密码错误");
                    return "/login";
                }else {
                    session.setAttribute("loginUser", user); //拦截器session
                    return "redirect:/index.html";
                }
            }
        }else if(userName == null){
            model.addAttribute("msg","平台没有该用户");
            return "/login";
        } else {
            //因为userName != null
            User user=userMapper.queryUserById(username,userpwd);
            //若果 user == null，说明账号或密码错误,有数据则登录
            if (user == null){
                model.addAttribute("msg","账号或密码错误");
                return "/login";
            }else {
                session.setAttribute("loginUser", user); //拦截器session
                return "redirect:/index.html";
            }
        }
    }

    @PostMapping("/user/register")
    public String register(User user, Model model) {
        //查询该用户是否存在
        User userqq = userMapper.queryUserByQq(user.getQq());
        //判断是否为空，不为空则存在，不可注册
        if (userqq == null) {
            if (userMapper.addUser(user) != 0) {
                model.addAttribute("msg", "用户:" + user.getQq() + ",注册成功!");
            }
        } else {
            model.addAttribute("msg", "用户:" + user.getQq() + ",已存在!");
        }
        return "/login";
    }
}
