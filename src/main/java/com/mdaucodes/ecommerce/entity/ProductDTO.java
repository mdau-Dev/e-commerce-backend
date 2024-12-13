package com.mdaucodes.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private String productCategory;
    private Integer price;
    private String productDescription;
    private Integer productQuantity;
//    private Long imageId;
    private boolean isAvailable;

    public ProductDTO(String productName, String productCategory,
                      Integer price, String productDescription, Integer productQuantity,
                       boolean isAvailable) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.isAvailable = isAvailable;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
