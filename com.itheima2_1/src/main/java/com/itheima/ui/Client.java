package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1、获取核心容器对象(存入容器的事情交给sprig做)
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2、根据id获取bean对象
        IAccountService as=(IAccountService)ac.getBean("accountService");
//        IAccountService as2=(IAccountService)ac.getBean("accountService");
//        System.out.println(as);
//
//        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);

//        System.out.println(as==as2);
        as.saveAccount();
        ac.close();


    }
}
