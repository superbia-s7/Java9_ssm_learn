package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll();

    //根据id查询
    User findById(Integer id);

    //保存用户  返回插入后自增长的id 在 user里面 不是这个返回值

    int savaUser(User user);
}
