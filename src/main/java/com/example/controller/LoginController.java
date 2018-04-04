package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginPage() {
        System.out.println("用户登录");
        return "login";
    }

//    @RequestMapping(value = "/abc",method = RequestMethod.GET)
//    public String test(){
//        System.out.println("test");
//        return "login";
//    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        int flag = userService.judgeByUserNameAndPassWord(username, password);
        if(flag!=0) {
            User user = userService.getUserByName(username);
            model.addAttribute(user);
            return "user";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public String list() {
        return userService.getUserById(1).toString();
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    @ResponseBody
    public String name() {
        return userService.getUserByName("efg").toString();
    }

}

