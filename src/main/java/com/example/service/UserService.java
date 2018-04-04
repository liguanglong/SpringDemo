package com.example.service;

import com.example.pojo.User;


public interface UserService {
    User getUserById(int id);
    int judgeByUserNameAndPassWord(String userName,String passWord);

    User getUserByName(String username);
}
