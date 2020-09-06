package com.neusoft.test;

import com.neusoft.domain.Account;
import com.neusoft.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: xuwenlong
 * @Date: 2020/9/6 11:19
 */
public class TestAccountService {
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        List<Account> allAccount = as.findAllAccount();
        for(Account account: allAccount){
            System.out.println(account);
        }
    }

    @Test
    public void testFindbyId(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account ab = as.findAccountById(3);

            System.out.println(ab);

    }
    @Test
    public void testSave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1000);
        as.saveAccount(account);

        //System.out.println(account);

    }
    @Test
    public void testUpdate(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(4);
        account.setName("eee");
        account.setMoney(1300);
        as.updateAccount(account);
        System.out.println(account);

    }
    @Test
    public void testdel(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        as.deleteAccount(4);

        System.out.println("yes");

    }
}
