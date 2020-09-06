package com.neusoft.service.impl;

import com.neusoft.dao.IAccountDao;
import com.neusoft.dao.impl.AccountDaoImpl;
import com.neusoft.domain.Account;
import com.neusoft.service.IAccountService;

import java.util.List;

/**
 * @Author: xuwenlong
 * @Date: 2020/9/6 11:33
 */
public class AccontServiceImpl implements IAccountService {
   private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
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
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
