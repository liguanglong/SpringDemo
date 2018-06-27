package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getUserById(int id) {
        if(id==0){
            return null;
        }else{
            return userDao.findUserById(id);
        }
    }

    public int judgeByUserNameAndPassWord( String userName, String passWord) {
        return userDao.judgeByUserNameAndPassWord(userName,passWord);
    }
    
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

//    public int judgeByUserNameAndPassWord( String userName, String passWord) {
//        User user = userDao.getUserByName(userName);
//        if(user == null) {
//            return 0;
//        }
//        if(user.getPassword().equals(passWord)) {
//            return 1;
//        }
//        return 0;
//    }


//    public int judgeByUserNameAndPassWord(@Param("username") String userName, @Param("password") String passWord) {
//        return userDao.judgeByUserNameAndPassWord(userName,passWord);
//    }



    @Override
    public int addUserList(List<User> userList) {
        return userDao.addUserList(userList);
    }

}


