package com.example.bank.dao.impl;

import com.example.bank.dao.AccountDao;
import com.example.bank.domain.Account;
import com.example.bank.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }


    @Override
    public List<Account> findAllAccount() {
        try {
            return  runner.query(connectionUtils.getThreadConnection(),"select * from bank",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer Id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from bank where Id =?",new BeanHandler<Account>(Account.class),Id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByNameId(Integer nameId) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from bank where nameId =?",new BeanHandler<Account>(Account.class),nameId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveAccount(Account account) {

        try {
            runner.update(connectionUtils.getThreadConnection(),"insert into bank(name,nameId,money) values(?,?,?)",account.getName(),account.getNameId(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {

        try {
            runner.update(connectionUtils.getThreadConnection(),"update bank set name=?,nameId=?,money=? where id=?",account.getName(),account.getNameId(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {

        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from bank where id=?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
