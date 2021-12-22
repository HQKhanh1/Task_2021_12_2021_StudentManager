package com.example.task_2021_12_2021_studentmanager.service;

import com.example.task_2021_12_2021_studentmanager.model.User;

import java.util.List;

public interface UserService {
    User getUserById(String userid);

    List<User> getAllUsers();

    String deleteUserById(String userid);

    User saveUser(User user);
}
