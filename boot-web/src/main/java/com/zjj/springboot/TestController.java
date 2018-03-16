package com.zjj.springboot;

import com.alibaba.fastjson.JSON;
import com.zjj.springboot.dao.userDAOMapper;
import com.zjj.springboot.entity.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public UserDAO test(HttpServletRequest request, @RequestParam("userName")String userName){
        UserDAO userDAO= userdaoMapper.selectByNameAndPwd(userName,"123456");
        System.out.println(JSON.toJSONString(userDAO));
        return userDAO;
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
