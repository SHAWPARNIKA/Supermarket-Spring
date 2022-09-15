package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findAll();
    public void deleteById(int theId);
    public User findById(int theId);

    public User addUser(Map<String ,String> userInput);

}
