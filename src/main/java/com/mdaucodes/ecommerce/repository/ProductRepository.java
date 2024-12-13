package com.mdaucodes.ecommerce.repository;

import com.mdaucodes.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByProductId(Long productId);
    Product findProductByProductName(String productName);
    List<Product> findProductsByProductDescriptionContainingIgnoreCase(String description);

    Optional<Product> findByProductNameIgnoreCase(String productName);

    List<Product> findProductsByProductCategoryContainingIgnoreCase(String productCategory);
}
