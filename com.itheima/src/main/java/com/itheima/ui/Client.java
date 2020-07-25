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
     * 获取spring的Ioc核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext:可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在加载不了(更常用)
     *      FileSystemXMLApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：可以用于读取注解创建容器
     *
     * 核心容器的两个接口引发出的问题
     * ApplicationContext：单例对象适用 （采用此接口）
     *      它在构建核心容器时创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     * BeanFactory:       多例对象适用
     *      它在构架核心容器时，创建对象采取的策略是延迟加载的方式，也就是说什么时候根据id获取对象，什么时候才真正创建对象
     * @param args
     */
    public static void main(String[] args) {
//        //1、获取核心容器对象(存入容器的事情交给sprig做)
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        //ApplicationContext ac=new FileSystemXmlApplicationContext("bean.xml");
//        //2、根据id获取bean对象
//        IAccountService as=(IAccountService)ac.getBean("accountService");
//        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(as);
//        System.out.println(adao);
//        //as.saveAccount();
        //-----------BeanFactory-------------
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        IAccountService as=(IAccountService)factory.getBean("accountService");
        System.out.println(as);


    }
}
