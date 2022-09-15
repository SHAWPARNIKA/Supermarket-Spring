package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.dao.CartProductRepository;
import com.springboot.cruddemo.entity.Cart_Product;
import com.springboot.cruddemo.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cartProduct")
public class CartProductRestController {

    @Autowired
    private CartProductService cartProductService;

    @Autowired
    private CartProductRepository cartProductRepository;

    @PostMapping("/addtocart")
    public ResponseEntity<Cart_Product> addToCart(@RequestBody Map<String,String> thecp){
        return new ResponseEntity<>(cartProductService.addToCart(thecp), HttpStatus.CREATED);
    }

    @DeleteMapping("/removefromcart")
    public ResponseEntity<String> removeFromCart(@RequestBody Map<String,String> removecp){
        cartProductService.removeFromCart(removecp);
        return new ResponseEntity<>("Entry Deleted",HttpStatus.CREATED);
    }

    @GetMapping("/displayCartproduct")
    public List<Cart_Product> display(){
        return cartProductRepository.findAll();
    }
}
