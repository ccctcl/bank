package com.example.bank.servlet;

import com.example.bank.domain.Account;
import com.example.bank.service.AccountService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewServlet", value = "/ViewServlet")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        List<Account> allAccount =accountService.findAllAccount();
        request.setAttribute("list",allAccount);
        request.getRequestDispatcher("list.jsp").forward(request,response);


    }
}
