package com.zjj.springboot;

import com.zjj.springboot.dao.userDAOMapper;
import com.zjj.springboot.entity.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinju.zeng on 2017/9/12.
 */
@RestController
public class TestController {
    @Autowired
    private userDAOMapper userdaoMapper;

    @RequestMapping("test")
    public UserDAO test(){
        return userdaoMapper.selectByNameAndPwd("zjj","123456");
    }
}
