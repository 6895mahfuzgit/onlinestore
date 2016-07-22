package com.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MahfuzCSE'11 on 23-Jun-16.
 */

@Entity
public class CartItem implements Serializable {


    private static final long serialVersionUID = -769579900090317811L;

    @Id
    @GeneratedValue
    private int caetItemId;

    /****************************
     * many cartItem and one cart
     *****************************/
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalPrice;

    public int getCaetItemId() {
        return caetItemId;
    }

    public void setCaetItemId(int caetItemId) {
        this.caetItemId = caetItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
