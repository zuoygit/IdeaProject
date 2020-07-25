package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    //private IAccountDao accountDao=new AccountDaoImpl();
    public void saveAccount(){
        System.out.println("保存了账户22");
    }

}
