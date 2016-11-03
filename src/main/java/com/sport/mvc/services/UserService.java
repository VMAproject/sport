package com.sport.mvc.services;

import com.sport.mvc.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void addUser(User user);
}
