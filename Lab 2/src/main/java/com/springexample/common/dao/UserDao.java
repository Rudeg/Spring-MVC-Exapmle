package com.springexample.common.dao;

import com.springexample.common.model.Entity.User;

import java.util.List;

public interface UserDao extends AbstractDao<User, String> {
    void saveUser(User user);
    User getByID(Long id);
    User getByUsername(String username);
    List<User> findUsers(String userName);
}
