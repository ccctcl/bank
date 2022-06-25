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
import java.util.logging.SocketHandler;

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
                        if(account==null){
                            break;
                        }else{
                            list.add(account);
                        }
                    }break;
                    case "nameId":{
                        account=accountService.findAccountByNameId(Integer.valueOf(input));
                        if(account==null){
                            break;
                        }else{
                            list.add(account);
                        }
                    }break;
                }
                goPath="list.jsp";
            }break;

            case "trans":{
                Integer source,target;
                float money ;
                String choice1=request.getParameter("choice1");
                String choice2=request.getParameter("choice2");
                Account sourceAccount = new Account();
                Account targetAccount = new Account();
                if(request.getParameter("money").isEmpty()){
                    money=0;
                }else {
                    money = Float.parseFloat(request.getParameter("money"));
                }
                if(request.getParameter("source").isEmpty()||request.getParameter("target").isEmpty()){
                    errorReason="输入框为空";
                    goPath="failOperation.jsp";break;
                }else{
                     source = Integer.valueOf(request.getParameter("source"));
                     target = Integer.valueOf(request.getParameter("target"));
                }
                switch (choice1){
                    case "id":{
                        sourceAccount=accountService.findAccountById(Integer.valueOf(source));
                    }break;
                    case "nameId":{
                        sourceAccount =accountService.findAccountByNameId(Integer.valueOf(source));
                    }break;
                }
                switch (choice2){
                    case "id":{
                        targetAccount=accountService.findAccountById(Integer.valueOf(target));
                    }break;

                    case "nameId":{
                        targetAccount=accountService.findAccountByNameId(Integer.valueOf(target));
                    }break;
                }
                if(targetAccount==null||sourceAccount==null){
                    errorReason="无法查询到该用户";
                    goPath="failOperation.jsp";break;
                }
                if (sourceAccount.getMoney()>=money){
                    accountService.transfer(sourceAccount,targetAccount,money);
                    goPath="ViewServlet";
                }else{
                    errorReason="转账方账户余额不足";
                    goPath="failOperation.jsp";
                }
            }break;
        }
        request.setAttribute("list",list);
        request.setAttribute("errorReason",errorReason);
        request.getRequestDispatcher(goPath).forward(request,response);
    }
}
