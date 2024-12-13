package com.mdaucodes.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String productName;
    private String productCategory;
    private Integer price;
    private String productDescription;
    private Integer productQuantity;
    private Long imageId;
    private boolean isAvailable;

    @ManyToMany(
            mappedBy = "productList"
    )
    private List<Cart> cartList=new ArrayList<>();
    public Product(String productName, String productCategory,
                   Integer price, String productDescription, Integer productQuantity,
                   Long imageId, boolean isAvailable) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.imageId = imageId;
        this.isAvailable = isAvailable;
    }

    public Product() {
    }

    public Product(String productName, String productCategory,
                   Integer price, String productDescription, Integer productQuantity) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public boolean isAvailable() {
        if(productQuantity>2){
            isAvailable=true;
        }
        return false;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", productQuantity=" + productQuantity +
                ", imageId=" + imageId +
                ", isAvailable=" + isAvailable +
                ", cartList=" + cartList +
                '}';
    }
}
