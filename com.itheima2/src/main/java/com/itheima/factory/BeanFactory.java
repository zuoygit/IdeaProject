package com.itheima.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean在计算机英语中，有可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 *      javabean>=实体类
 *     创建service和dao对象的
 *     第一个，需要一个配置文件配置service和dao
 *          配置文件内容：唯一标志=全限定类名(key=value)
 *     第二，通过读取配置文件中配置的内容，反射创建对象（IOC?）
 *
 *     配置文件可以是xml，也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;
    //定义一个map用于存放要创建的对象，我们称之为容器
    private static Map<String,Object> beans;
    //使用静态代码块为Properties对象赋值
    static{
        try{
            //实例化对象
            props =new Properties();
            //获取properties文件的流对象
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans=new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys=props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key=keys.nextElement().toString();
                //跟key获取value
                String beanPath=props.getProperty(key);
                //反射创建对象
                Object value=Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key,value);
            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){

        return beans.get(beanName);
    }

    //为了更通用，返回值定为Object类型
    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return
     */
//    public static Object getBean(String beanName){
//        Object bean=null;
//        try{
//            //通过全限定类名获取对象名称
//            String beanPath=props.getProperty(beanName);
//            //通过反射方式创建对象
//            //System.out.println(beanPath);
//            bean=Class.forName(beanPath).newInstance();//newInstance每次都会调用默认的构造函数创建对象
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
