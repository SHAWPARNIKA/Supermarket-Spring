package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.entity.Product;
import com.springboot.cruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/displayProducts")
    public List<Product> findAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/getById/{productId}")
    public ResponseEntity<Product> getEmployee(@PathVariable int productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @DeleteMapping("/deleteById/{productId}")
    public String deleteEmployee(@PathVariable int productId) {
        Product tempProduct=productService.findById(productId);
        //throw exception if null
        if(tempProduct==null){
             return "Product id not found- "+productId;
        }
        productService.deleteById(productId);
        return "Deleted product id- "+productId;
    }

    @PostMapping("/addProducts")
    public Product addProduct(@RequestBody  Map<String,String> productInput){
        return productService.addProduct(productInput);
    }

}
