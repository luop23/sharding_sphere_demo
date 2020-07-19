package com.luop.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDaoTest {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;


    @Test
    void insertOrder() {
        List<Long> userIds = userDao.getAll().stream().map(map -> Long.parseLong(map.get("user_id").toString()))
                .collect(Collectors.toList());
        for (int i = 0; i < 20; i++) {
            int index = new Random().nextInt(5);
            orderDao.insertOrder(new BigDecimal(11.5 + i), userIds.get(index), i % 2 == 0 ? "SUCCESS" : "ERROR");
        }
    }

    @Test
    void getByWhere() {
        List<Long> idList = Arrays.asList(491693266589188096L, 491693267939753984L, 491693268048805889L);
        List<Map<String, Object>> maps = orderDao.getByWhere(idList);
        System.out.println(maps);
    }

    @Test
    void getOrderByUerId() {
        System.out.println(orderDao.getOrderByUerId(491738163518111744L));
    }
}