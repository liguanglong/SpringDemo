package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "error";
        }
        int flag = userService.judgeByUserNameAndPassWord(username, password);
        if (flag != 0) {
            User user = userService.getUserByName(username);
            model.addAttribute(user);
            return "user";
        } else {
            return "fail";
        }
    }


    @RequestMapping(value = "/abc", method = RequestMethod.GET)
    @ResponseBody
    public Object login(String username, String password) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            resultMap.put("retCode", 500);
            return resultMap;
        }
        int flag = userService.judgeByUserNameAndPassWord(username, password);
        if (flag != 0) {
            resultMap.put("retCode", 200);
            return resultMap;
        } else {
            resultMap.put("retCode", 500);
            return resultMap;
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

    //    @RequestMapping("/getList.do")
    @RequestMapping(value = "/getList.do")
    @ResponseBody
    public Object getUserList() {
        Map<String, Object> resultMap = new HashMap<>();

        List<User> userList = userService.getUserList();
        resultMap.put("resCode", "200");
        resultMap.put("res", userList);

        return resultMap;
    }


    @PostMapping("/json.do")
    @ResponseBody
    public Object json(@RequestBody User[] users) {

        Map<String, Object> resultMap = new HashMap<>();

//        List<User> userList = userService.getUserList();

        List<User> userList = new ArrayList<>();
        for (User u : users) {

            userList.add(u);
        }
        resultMap.put("resCode", "200");
        resultMap.put("res", userList);

        return resultMap;
    }


    @RequestMapping(value = "/json1.do", method = RequestMethod.POST)
    @ResponseBody
    public Object json(@RequestBody Map<String,Object> parm){

        Map<String, Object> resultMap = new HashMap<>();

        List<String> urls = (List<String>) parm.get("urls");

        List<Map<String,String>> data = (List<Map<String,String>>) parm.get("data");

//        List<User> userList = userService.getUserList();

//        List<String> strings = new ArrayList<>();
//        for (String url : urls) {
//
//            strings.add(url);
//        }
        resultMap.put("resCode", "200");
        resultMap.put("urls", urls);
        resultMap.put("data", data);

        return resultMap;


    }
}

