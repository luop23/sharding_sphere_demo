package com.luop.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    void insertUser() {
        for (int i = 1; i <= 5; i++) {
            userDao.insertUser("user" + i, "email" + i + "@sina.com");
        }
    }

    @Test
    void getAll() {
        System.out.println(userDao.getAll());
    }
}