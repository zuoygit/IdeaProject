package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        //设置请求编码格式：
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname=req.getParameter("uname");
        //uname=new String(uname.getBytes("ISO8859-1"),"UTF-8");
        String pwd=req.getParameter("pwd");

        System.out.println(uname+":"+pwd);
        //处理请求信息
            //获取业务层对象
        LoginService ls=new LoginServiceImpl();
        User u=ls.checkLoginService(uname,pwd);
        System.out.println(u);
        //响应处理结果
        if(u!=null){
            resp.getWriter().write("登陆成功");
        }else{
            resp.getWriter().write("登陆失败");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
