package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User save(User user);

    User findUserById(Integer id);
}
