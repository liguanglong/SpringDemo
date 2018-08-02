package com.example.dao;

import com.example.dao.base.CommonCRUDDao;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserDao extends CommonCRUDDao<User> {

    int getAllUsersCount();

    int judgeByUserNameAndPassWord(@Param("username") String userName, @Param("password") String passWord);

//    int judgeByUserNameAndPassWord(String userName,String passWord);

    User findUserById(int id);

    User getUserByName(String username);

    int addUserList(List<User> userList);

    List<User> findEntityByCond(Map<String, Object> cond);

    List<User> getUserList();

}
