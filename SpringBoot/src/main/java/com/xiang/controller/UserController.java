package com.xiang.controller;

import com.xiang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.math.BigInteger;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/ForgetPassword")
    public Object ForgetPassword(@RequestParam("qq") BigInteger qq, @RequestParam("userPwd") String userPwd, Model model){
        int i = userMapper.updatePwd(qq, userPwd);
        if (i!=0){
            model.addAttribute("msg","修改成功");
            return new ModelAndView("redirect:/SendVerification?qq="+qq+"&pwd="+userPwd);
        }else {
            model.addAttribute("msg","修改失败");
            return "/forget";
        }
    }

    @PostMapping("/compare")
    @ResponseBody
    public Object compare(@RequestParam("compare") Object compare,HttpSession session){
        Object usercodeNum = session.getAttribute("UsercodeNum");

        if (usercodeNum.equals(compare)){
            return "true";
        }else {
            return "false";
        }
    }
}
