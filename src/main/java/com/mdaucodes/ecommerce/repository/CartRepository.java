package com.mdaucodes.ecommerce.repository;

import com.mdaucodes.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findCartsByCustomerId(Long customerId);

    Cart findCartByCartId(Long cartId);
}
