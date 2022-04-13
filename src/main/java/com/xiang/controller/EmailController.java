package com.xiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class EmailController{
    @Autowired
    JavaMailSender mailSender;

    @PostMapping("/mail")
    @ResponseBody
    public String Main(String qq, HttpSession session)  throws MessagingException {
        int count=1;//默认发送一次
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        String codeNum = "";
        int [] code = new int[3];
        Random random = new Random();
        //自动生成验证码
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum+=(char)code[random.nextInt(3)];
        }
        while(count--!=0){
            //标题
            helper.setSubject("您的验证码为："+codeNum);
            //内容
            String style="background: #d1ecfd;background-image: linear-gradient(135deg, #ade2f6 25%, transparent 25%, transparent 50%, #ade2f6 50%, #ade2f6 75%,transparent 75%, transparent 100%);background-size: 30px 30px";
            String div_style="background: rgba(173,226,246,0.5);";
            helper.setText("<div style='"+div_style+"'><img src='http://q1.qlogo.cn/g?b=qq&nk="+qq+"&s=100'/><br/>您好！，感谢支持Xiang的小站。您的验证码为："+"<h2 style='"+style+"'>"+codeNum+"</h2>"+"千万不能告诉别人哦！</div>",true);
            //邮件接收者
            helper.setTo(qq+"@qq.com");
            //邮件发送者，必须和配置文件里的一样，不然授权码匹配不上
            helper.setFrom("2089642063@qq.com");
            mailSender.send(mimeMessage);
        }
        session.setAttribute("UsercodeNum",codeNum);

        return "验证码已发送";
    }


    @RequestMapping("/SendVerification")
    public String SendVerification(String qq,String pwd,Model model)  throws MessagingException{
        int count=1;//默认发送一次
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        while(count--!=0){
            //标题
            helper.setSubject("您好,您在 Xiang の Web 的密码已修改！");
            //内容
            String style="background: #d1ecfd;background-image: linear-gradient(135deg, #ade2f6 25%, transparent 25%, transparent 50%, #ade2f6 50%, #ade2f6 75%,transparent 75%, transparent 100%);background-size: 30px 30px";
            String div_style="background: rgba(173,226,246,0.5);";
            helper.setText("<div style='"+div_style+"'><img src='http://q1.qlogo.cn/g?b=qq&nk="+qq+"&s=100'/><br/>您好！感谢支持 Xiang 的小站。您的新密码为："+"<h2 style='"+style+"'>"+pwd+"</h2>"+"请牢记您的密码！</div>",true);
            //邮件接收者
            helper.setTo(qq+"@qq.com");
            //邮件发送者，必须和配置文件里的一样，不然授权码匹配不上
            helper.setFrom("2089642063@qq.com");
            mailSender.send(mimeMessage);
        }
        model.addAttribute("msg","修改成功！");
        System.out.println("用户："+qq+"密码已修改");
        return "forget";
    }
}