package com.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cruddemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
