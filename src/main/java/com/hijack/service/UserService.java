package com.hijack.service;

import com.hijack.dao.inter.UserDao;
import com.hijack.entity.daoEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User processUser(User user) {
        if(user.getUsername() == null || user.getUsername().isBlank())
            return null;
        return userDao.save(user);
    }
}
