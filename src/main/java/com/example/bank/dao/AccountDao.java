package com.example.bank.dao;

import com.example.bank.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAllAccount();

    Account findAccountById(Integer Id);

    Account findAccountByNameId(Integer nameId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);


}
