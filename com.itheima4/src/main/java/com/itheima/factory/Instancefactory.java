package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类，该类可能是存在与jar包中，我们无法通过修改源码的方式来提供默认构造函数
 */
public class Instancefactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
