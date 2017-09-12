package com.zjj.springboot;

import com.zjj.springboot.dao.userDAOMapper;
import com.zjj.springboot.entity.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinju.zeng on 2017/9/12.
 */
@Controller
public class TestController {
    @Autowired
    private userDAOMapper userdaoMapper;

    @Transactional
    @RequestMapping("test")
    @ResponseBody
    public UserDAO test(){
        return userdaoMapper.selectByNameAndPwd("zjj","123456");
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
