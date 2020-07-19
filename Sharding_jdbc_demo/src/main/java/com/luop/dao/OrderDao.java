package com.luop.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface OrderDao {

    /**
     * 新增订单
     *
     * @param price  价格
     * @param userId 用户
     * @param status 订单状态
     * @return
     */
    @Insert("insert into t_order(price,user_id,status) values (#{price},#{userId},#{status} )")
    int insertOrder(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);

    /**
     * 根据条件查询
     * @param ids
     * @return
     */
    @Select("<script> " +
            "select * from t_order where order_id in " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach>" +
            "</script>")
    List<Map<String, Object>> getByWhere(@Param("ids") List<Long> ids);

    /**
     * 根据用户查询订单数据
     * @param userId
     * @return
     */
    @Select("select o.order_id,o.price,o.status,u.user_id,u.user_name,u.user_email " +
            "from t_order o left join t_user u on o.user_id=u.user_id where u.user_id=#{userId}")
    List<Map<String,Object>> getOrderByUerId(@Param("userId") Long userId);
}
