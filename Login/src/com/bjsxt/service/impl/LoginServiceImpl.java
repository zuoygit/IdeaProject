package com.bjsxt.service.impl;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.dao.impl.LoginDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;
import com.bjsxt.servlet.LoginServlet;

public class LoginServiceImpl implements LoginService {
    //创建Dao层对象
    LoginDao ld=new LoginDaoImpl();

    @Override
    public User checkLoginService(String uname, String pwd) {

        return ld.checkLoginDao(uname,pwd);
    }
}
