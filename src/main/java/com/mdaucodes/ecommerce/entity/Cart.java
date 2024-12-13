package com.mdaucodes.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Integer totalPrice;
    private Long customerId;

    @ManyToMany
    @JoinTable(
            name = "cart_product_table",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList =new ArrayList<>();

    public Cart() {
    }

    public Cart(Integer totalPrice, List<Product> productList) {
        this.totalPrice = totalPrice;
        this.productList = productList;
    }

    public Cart(Long cartId, Integer totalPrice, List<Product> productList) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.productList = productList;
    }

    public Integer getTotalPrice() {
        if (totalPrice==null){
            totalPrice=0;
        }
        for (Product product : productList) {
            totalPrice = totalPrice + product.getPrice();
        }
        return totalPrice;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                ", customerId=" + customerId +
                ", productList=" + productList +
                '}';
    }
}
