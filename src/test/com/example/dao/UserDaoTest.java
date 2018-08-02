package com.example.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LiGuanglong
 * @date 2018/6/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest {

    @BeforeClass
    public static void beforeClass() {

    }

    @Test
    public void findUserById() {
        
    }

    @Test
    public void addUserList() {
    }
}