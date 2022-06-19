package com.example.bank.factory;

import com.example.bank.service.AccountService;
import com.example.bank.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private AccountService accountService;

    private TransactionManager transactionManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public AccountService getAccountService() {

       return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object proxyObj=null;
                try{
                    transactionManager.beginTransaction();
                    proxyObj=method.invoke(accountService,args);
                    transactionManager.commitTransaction();

                }catch (Exception e){
                    transactionManager.rollBack();
                    System.out.println("回滚");
                }finally {
                    transactionManager.release();
                }
                return proxyObj;
            }
        });


    }
}
