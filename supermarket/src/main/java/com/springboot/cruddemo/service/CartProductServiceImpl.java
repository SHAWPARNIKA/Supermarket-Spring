package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.CartProductRepository;
import com.springboot.cruddemo.dao.CartRepository;
import com.springboot.cruddemo.entity.Cart;
import com.springboot.cruddemo.entity.Cart_Product;
import com.springboot.cruddemo.entity.Product;
import com.springboot.cruddemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class CartProductServiceImpl implements CartProductService {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;


	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartProductRepository cartProductRepository;
	@Override
	public Cart_Product addToCart(Map<String ,String> addCartInput) {
		Cart_Product cart_product=new Cart_Product();
		User user=userService.findById(Integer.parseInt(addCartInput.get("user_id")));
		Product product=productService.findById(Integer.parseInt(addCartInput.get("product_id")));
		Cart cart=user.getCart();
		cart_product.setQuantity_purchased(Integer.parseInt(addCartInput.get("quantity_purchased")));
		if(cart_product.getQuantity_purchased()>product.getProductQuantity()){
			throw new RuntimeException(" Quantity not available");
		}
		product.setProductQuantity(product.getProductQuantity()-cart_product.getQuantity_purchased());
		cart_product.setProduct(product);
		cart_product.setCart(user.getCart());
		cart_product.setNetAmount(cart_product.getQuantity_purchased()*cart_product.getProduct().getProductPrice());
		cart.setTotalAmount(cart.getTotalAmount()+cart_product.getNetAmount());
		cartRepository.save(cart);
		return cartProductRepository.save(cart_product);
	}

	@Override
	@Transactional
	public void removeFromCart(Map<String, String> removeCartInput) {
		Product product= productService.findById(Integer.parseInt(removeCartInput.get("productId")));
		Cart cart=userService.findById(Integer.parseInt(removeCartInput.get("userId"))).getCart();
		Cart_Product cart_product=cartProductRepository.findByProductAndCart(product,cart);
		cart.setTotalAmount(cart.getTotalAmount()-cart_product.getNetAmount());
		product.setProductQuantity(product.getProductQuantity()+cart_product.getQuantity_purchased());
		cartRepository.save(cart);
		cartProductRepository.delete(cart_product);
	}

	/*public void deleteCart(Cart cart) {
		Cart_Product cart_product=cartProductRepository.findByCart(cart);
		cartProductRepository.delete(cart_product);
	}*/
	public void deleteCart (Cart cart){
		List<Cart_Product> cartList=cartProductRepository.findByCart(cart);
		cartProductRepository.deleteAll(cartList);

	}
}
