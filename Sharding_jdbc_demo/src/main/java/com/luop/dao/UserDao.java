package com.luop.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserDao {

    /**
     * 新增用户
     *
     * @param userName
     * @param userEmail
     * @return
     */
    @Insert("insert into t_user(user_name,user_email) values (#{userName},#{userEmail})")
    int insertUser(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from t_user")
    List<Map<String, Object>> getAll();

}
