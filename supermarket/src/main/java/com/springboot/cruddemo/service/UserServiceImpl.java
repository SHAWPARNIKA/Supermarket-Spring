package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.CartRepository;
import com.springboot.cruddemo.dao.UserRepository;
import com.springboot.cruddemo.entity.Cart;
import com.springboot.cruddemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public User findById(int theId) {
        return userRepository.findById(theId).get();
    }

    public User addUser(Map<String,String> userInput){
        User user=new User();
        Cart cart=new Cart();
        user.setUser_name(userInput.get("user_name"));
        user.setPhone_number(Long.parseLong(userInput.get("phone_number")));
        cart.setTotalAmount(0);
        cart=cartRepository.save(cart);
        user.setCart(cart);
        return userRepository.save(user);
    }
}
