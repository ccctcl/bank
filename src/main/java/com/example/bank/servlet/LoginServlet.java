package com.example.bank.servlet;

import com.example.bank.domain.User;
import com.example.bank.service.AccountService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user =  new User();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        String goPath="";
        String errorReason="" ;

        if(request.getParameter("username").isEmpty()||request.getParameter("password").isEmpty()){
            goPath="failLogin.jsp";
            errorReason="账号或密码为空";
        }else{
            user=accountService.findAccountByName(request.getParameter("username"));
             if(user==null){
                 goPath="failLogin.jsp";
                 errorReason="账号或密码不正确";
             }else{
                 if(user.getPassword().equals(request.getParameter("password"))){
                     switch(user.getIdentity()){
                         case "root":{
                             goPath="successPage.jsp";
                             request.setAttribute("user",user);
                         }break;
                         case "common":{
                             goPath="customerSuccessPage.jsp";
                             request.setAttribute("user",user);
                         }break;
                     }
                 }
                 else{
                     goPath="failLogin.jsp";
                     errorReason="账号或密码不正确";
                 }
             }

        }

        request.setAttribute("errorReason",errorReason);
        request.getRequestDispatcher(goPath).forward(request,response);
    }
}
