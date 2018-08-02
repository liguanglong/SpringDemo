package com.example.service;

import com.example.pojo.User;

import java.util.List;


public interface UserService {
    User getUserById(int id);

    int judgeByUserNameAndPassWord(String userName,String passWord);

    User getUserByName(String username);

    int addUserList(List<User> userList);

    List<User> getUserList();

}
