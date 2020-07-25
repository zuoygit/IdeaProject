package com.bjsxt.dao.impl;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {


    @Override
    public User checkLoginDao(String uname, String pwd) {

        //声明jdbc对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User u=null;
        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/t_user?serverTimezone=UTC","root","123456");
            //创建sql命令
            String sql="select * from t_user where uname=? and pwd=?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //给站位符赋值
            ps.setString(1,uname);
            ps.setString(2,pwd);
            //执行
            rs=ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                u=new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //关闭资源
        finally {
            {
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        //返回
        return u;
    }
}
