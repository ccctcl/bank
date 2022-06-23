package com.example.bank.service;

import com.example.bank.domain.Account;
import com.example.bank.domain.User;

import java.util.List;

public interface AccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer Id);

    User findAccountByName(String name);

    Account findAccountByNameId(Integer nameId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    void transfer(Account source,Account target,Float money);

}
