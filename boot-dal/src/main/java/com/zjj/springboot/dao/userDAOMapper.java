package com.zjj.springboot.dao;

import com.zjj.springboot.entity.UserDAO;
import org.apache.ibatis.annotations.Param;

public interface userDAOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDAO record);

    int insertSelective(UserDAO record);

    UserDAO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDAO record);

    UserDAO selectByNameAndPwd(@Param("userName") String userName, @Param("password") String password);

    int updateId();
}