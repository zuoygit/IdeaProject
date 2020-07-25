package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //依赖关系，直接new对象导致代码耦合性强
    private IAccountDao accountDao=new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    //解耦
    //private IAccountDao accountDao= (IAccountDao)BeanFactory.getBean("accountDao");

    //private int i=1;

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
