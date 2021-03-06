package com.example.bank.service.impl;

import com.example.bank.dao.AccountDao;
import com.example.bank.domain.Account;
import com.example.bank.domain.User;
import com.example.bank.service.AccountService;
import com.example.bank.utils.ConnectionUtils;
import com.example.bank.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;


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
    public User findAccountByName(String name) {
        return accountDao.findAccountByName(name);
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
    public void transfer(Account source,Account target, Float money) {
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }


}
