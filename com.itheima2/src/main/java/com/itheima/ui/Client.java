package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //依赖关系，直接new对象导致代码耦合性强
        //IAccountService as=new AccountServiceImpl();
        for(int i=0;i<5;i++){
            //工厂模式实现解耦
            IAccountService as= (IAccountService)BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
