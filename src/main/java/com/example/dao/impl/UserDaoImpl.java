package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.dao.base.BaseCRUDDaoImpl;
import com.example.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiGuanglong
 * @date 2018/6/5
 */
@Repository("userDao")
public class UserDaoImpl extends BaseCRUDDaoImpl<User> implements UserDao{

    public int getAllUsersCount() {
        return 0;
    }

    public int judgeByUserNameAndPassWord(String userName, String passWord) {
        Map<String, Object> cond = new HashMap<String, Object>();
        cond.put("username", userName);
        cond.put("password", passWord);
        return this.getSqlSession().selectOne("User.judgeByUserNameAndPassWord",cond);
    }

    public User findUserById(int id) {
        return this.getSqlSession().selectOne("User.findUserById",id);
    }

    public User getUserByName(String username) {
        return this.getSqlSession().selectOne("User.getUserByName", username);
    }

    @Override
    public int addUserList(List<User> userList) {
        try {
            for (User u : userList) {
                addEntity(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<User> findEntityByCond(Map<String, Object> cond) {
        return this.getSqlSession().selectList("User.findEntityByCond", cond);
    }

    @Override
    public List<User> getUserList() {
        return this.getSqlSession().selectList("getUserList");
    }
}
