package com.example.bank.servlet;

import com.example.bank.domain.Account;
import com.example.bank.service.AccountService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OperationServlet", value = "/OperationServlet")
public class OperationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Account account = new Account();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        List<Account> list = new ArrayList<>();
        String goPath="";
        String errorReason="";
        String action = request.getParameter("action");

        switch (action){
            case "add":{

                if(request.getParameter("name").isEmpty()||request.getParameter("nameId").isEmpty()){
                    goPath="failOperation.jsp";
                    errorReason="姓名或ID为空";
                }else{
                    account.setName(request.getParameter("name"));
                    account.setNameId(Integer.valueOf(request.getParameter("nameId")));
                    account.setMoney(Float.valueOf(request.getParameter("money")));
                    accountService.saveAccount(account);
                    goPath="ViewServlet";
                }
            }break;

            case "delete":{
                if(request.getParameter("id").isEmpty()){
                    goPath="failOperation.jsp";
                    errorReason="序号为空";
                }else {
                    account.setId(Integer.valueOf(request.getParameter("id")));
                    accountService.deleteAccount(account.getId());
                    goPath="ViewServlet";
                }
            }break;

            case "update":{
                if(request.getParameter("id").isEmpty()){
                    goPath="failOperation.jsp";
                    errorReason="序号为空";
                }else{
                    account.setId(Integer.valueOf(request.getParameter("id")));
                    account.setName(request.getParameter("name"));
                    account.setNameId(Integer.valueOf(request.getParameter("nameId")));
                    account.setMoney(Float.valueOf(request.getParameter("money")));
                    accountService.updateAccount(account);
                    goPath="ViewServlet";
                }
            }break;

            case "select":{
                String input=request.getParameter("input");
                String choice=request.getParameter("choice");
                if (input.isEmpty()){
                    errorReason="输入框为空";
                    goPath="failOperation.jsp";break;
                }
                switch (choice){
                    case "id":{
                        account=accountService.findAccountById(Integer.valueOf(input));
                            list.add(account);
                    }break;

                    case "nameId":{
                        account=accountService.findAccountByNameId(Integer.valueOf(input));
                        list.add(account);
                    }break;
                }
                goPath="list.jsp";
            }

//            case "trans":{
//
//            }break;
        }
        request.setAttribute("list",list);
        request.setAttribute("errorReason",errorReason);
        request.getRequestDispatcher(goPath).forward(request,response);
    }
}
