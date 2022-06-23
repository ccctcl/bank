package com.example.bank.servlet;

import com.example.bank.domain.Account;
import com.example.bank.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerViewServlet", value = "/customerViewServlet")
public class customerViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        Account account =accountService.findAccountById(3);
        List<Account> list=new ArrayList<>();
        list.add(account);
        request.setAttribute("list",account);
        request.getRequestDispatcher("customerList.jsp").forward(request,response);


    }
}
