package com.onlinestore.controller;

import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;
import com.onlinestore.model.Customer;
import com.onlinestore.model.Product;
import com.onlinestore.service.CartItemService;
import com.onlinestore.service.CartService;
import com.onlinestore.service.CustomerService;
import com.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartRestServicesController {

    @Autowired
    private CartService cartService;


    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;


    @RequestMapping("/{cartId}")
    public
    @ResponseBody
    Cart getCartById(@PathVariable("cartId") int cartId) {

        return cartService.getCartById(cartId);

    }


    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void add(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser) {

        Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());

        Cart cart = customer.getCart();

        Product product = productService.getProductById(productId);

        List<CartItem> cartItems = cart.getCartItems();

        for (int i = 0; i < cartItems.size(); i++) {

            if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {


                CartItem cartItem = cartItems.get(i);

                cartItem.setQuantity((cartItem.getQuantity() + 1));
                cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());

                return;


            }


        }


        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);


    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable("productId") int productId) {

        CartItem cartItem = cartItemService.getCartItemProductId(productId);

        cartItemService.removeCartItem(cartItem);


    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable("cartId") int cartId) {


        Cart cart = cartService.getCartById(cartId);
        cartItemService.readAllCartItem(cart);


    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception ex) {

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception ex) {

    }


}
