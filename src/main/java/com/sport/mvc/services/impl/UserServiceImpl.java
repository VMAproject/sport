package com.sport.mvc.services.impl;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.User;
import com.sport.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Qualifier("userDatabaseDao")
    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }


    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.add(user);
    }

}
