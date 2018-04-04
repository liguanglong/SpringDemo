package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    int getAllUsersCount();

    int judgeByUserNameAndPassWord(@Param("username") String userName, @Param("password") String passWord);

//    int judgeByUserNameAndPassWord(String userName,String passWord);

    User findUserById(int id);

    User getUserByName(String username);
}
