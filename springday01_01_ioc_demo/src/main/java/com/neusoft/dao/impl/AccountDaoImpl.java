package com.neusoft.dao.impl;

import com.neusoft.dao.IAccountDao;
import com.neusoft.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: xuwenlong
 * @Date: 2020/9/6 11:02
 */
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;

    public QueryRunner getRunner() {
        return runner;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }


    @Override
    public List<Account> findAll() {
       try {
           String sql="select * from account";
           return runner.query(sql,new BeanListHandler<Account>(Account.class));
       } catch (SQLException e) {
           throw  new RuntimeException(e);
       }

    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            String sql="select * from account where id = ?";
            return runner.query(sql,new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            String sql="insert into account (name,money) value(?,?)";
           runner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            String sql="update account set name = ?,money = ?";
            runner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            String sql="delete from  account where id = ?";
            runner.update(sql,id);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
