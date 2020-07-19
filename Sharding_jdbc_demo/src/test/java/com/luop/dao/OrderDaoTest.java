package com.luop.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDaoTest {

    @Resource
    private OrderDao orderDao;


    @Test
    void insertOrder() {
        for (int i = 0; i < 20; i++) {
            orderDao.insertOrder(new BigDecimal(11.5 + i), (long)i, "SUCCESS");
        }
    }

    @Test
    void getByWhere() {
        List<Long> idList = Arrays.asList(491693266589188096L, 491693267939753984L, 491693268048805889L);
        List<Map<String, Object>> maps = orderDao.getByWhere(idList);
        System.out.println(maps);
    }
}