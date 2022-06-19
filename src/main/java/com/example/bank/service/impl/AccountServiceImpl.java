package com.example.bank.service.impl;

import com.example.bank.dao.AccountDao;
import com.example.bank.domain.Account;
import com.example.bank.service.AccountService;
import com.example.bank.utils.ConnectionUtils;
import com.example.bank.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

//    private TransactionManager transactionManager;
//
//    public void setTransactionManager(TransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }

    public void setAccountDao(AccountDao accountDao) {

        this.accountDao=accountDao;
    }

    @Override
    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer Id) {
        return accountDao.findAccountById(Id);
    }

    @Override
    public Account findAccountByNameId(Integer nameId) {
        return accountDao.findAccountByNameId(nameId);
    }


    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(Integer sourceNameId, Integer targetNameId, Float money) {
        Account source=accountDao.findAccountByNameId(sourceNameId);
        Account target= accountDao.findAccountByNameId(targetNameId);
        if (source.getMoney()>=money){
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
//            transactionManager.commitTransaction();
        }
//        try{
//            transactionManager.beginTransaction();
//
//        }catch (Exception e){
//            transactionManager.rollBack();
//            System.out.println("回滚");
//            e.printStackTrace();
//
//        }finally {
//            transactionManager.release();
//        }
    }


}
