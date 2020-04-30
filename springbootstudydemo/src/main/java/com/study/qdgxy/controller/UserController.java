package com.study.qdgxy.controller;

import com.study.qdgxy.pojo.User;
import com.study.qdgxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/sayhi")
    public String sayhi(){
        return "hi";
    }

    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session){

        if(userService.login(user)){
            session.setAttribute("login",user);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户名或密码错误，请重试！");
            return "index";
        }

    }
}
