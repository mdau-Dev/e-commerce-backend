package com.mdaucodes.ecommerce.service;

import com.mdaucodes.ecommerce.entity.Cart;
import com.mdaucodes.ecommerce.entity.Product;
import com.mdaucodes.ecommerce.entity.ProductDTO;
import com.mdaucodes.ecommerce.repository.CartRepository;
import com.mdaucodes.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CartRepository cartRepository;
    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void fetchAllProducts() {
        //Given
        List<Product> products=new ArrayList<>();
        products.add(new Product("Tecno PovaAir","Phone",20000,
                "ncvhbghdvysb",30));
        products.add(new Product("Infinix 50 pro","Phone",23000,
                "ncvhbghdvysb",20));
        List<ProductDTO> productDTOList=new ArrayList<>();
//        productDTOList.add(new ProductDTO("Tecno PovaAir","Phone",20000,
//                "ncvhbghdvysb",30,true));
//        productDTOList.add(new ProductDTO("Infinix 50 pro","Phone",23000,
//                "ncvhbghdvysb",12,true));

        //Mock the Calls
        when(productRepository.findAll()).thenReturn(products);

        //When
        List<ProductDTO> productDTOS=productService.fetchAllProducts();

        //then
        assertEquals(products.get(1).getProductName(),productDTOS.get(1).getProductName());
        assertEquals(products.size(),productDTOS.size());
    }

    @Test
    void fetchOneById() {
        //Given
        Product product=new Product(
                "Tecno PovaAir","Phone",20000,
                        "ncvhbghdvysb",30,10L,true
        );

        //Mock the Calls
        when(productRepository.findByProductId(null)).thenReturn(product);

        //When
        ProductDTO productDTO=productService.fetchOneById(null);
        //then
        assertEquals(productDTO.getProductQuantity(),product.getProductQuantity());
        assertEquals(productDTO.getProductName(),product.getProductName());
    }

    @Test
    void fetchProductsByDescriptionContains() {
        //Given
        List<ProductDTO> productDTOList=new ArrayList<>();
        List<Product> products=new ArrayList<>();
        products.add(new Product("Tecno PovaAir","Phone",20000,
                "ncvhbghdvysb",30));
        products.add(new Product("Infinix 50 pro","Phone",23000,
                "ncvhbghdvysb",20));

        //Mock the Calls
        when(productRepository.findProductsByProductDescriptionContainingIgnoreCase(null)).thenReturn(products);

        //When
        List<ProductDTO> dtoList=productService.fetchProductsByDescriptionContains(null);

        //Then
        assertEquals(dtoList.get(0).getProductDescription(),products.get(0).getProductDescription());
        assertEquals(dtoList.get(0).getProductName(),products.get(0).getProductName());
    }

    @Test
    void fetchCartById() {
        //Given
        List<Product> products=new ArrayList<>();
        products.add(new Product("Tecno PovaAir","Phone",20000,
                "ncvhbghdvysb",30));
        products.add(new Product("Infinix 50 pro","Phone",23000,
                "ncvhbghdvysb",20));
        Cart cart=new Cart();
        cart.setProductList(products);
        cart.setCustomerId(1L);
        cart.setCartId(10L);

        //Mock The Calls
        when(cartRepository.findById(10L)).thenReturn(Optional.of(cart));
        when(cartRepository.findCartByCartId(10L)).thenReturn(cart);

        //When
        Cart cart2=productService.fetchCartById(10L);

        //Then
        assertEquals(cart2.getTotalPrice(),cart.getTotalPrice());


    }

    @Test
    void fetchAllCarts() {
    }

    @Test
    void addNewProduct() {
    }

    @Test
    void updateProductInfo() {
    }

    @Test
    void updateProductQuantity() {
    }

    @Test
    void fetchProductByCategory() {
    }

    @Test
    void createCart() {
    }

    @Test
    void removeProductFromCart() {
    }

    @Test
    void fetchAllProductsWholly() {
    }

    @Test
    void deleteAllCarts() {
    }
}