package com.example.bank.service;

import com.example.bank.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer Id);

    Account findAccountByNameId(Integer nameId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    void transfer(Integer sourceNameId,Integer targetNameId,Float money);

}
