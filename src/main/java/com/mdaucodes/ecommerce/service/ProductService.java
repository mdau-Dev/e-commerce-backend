package com.mdaucodes.ecommerce.service;

import com.mdaucodes.ecommerce.entity.Cart;
import com.mdaucodes.ecommerce.entity.Product;
import com.mdaucodes.ecommerce.entity.ProductDTO;
import com.mdaucodes.ecommerce.repository.CartRepository;
import com.mdaucodes.ecommerce.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public List<ProductDTO> fetchAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDTO(
                        product.getProductName(), product.getProductCategory(),
                         product.getPrice(),product.getProductDescription(),
                        product.getProductQuantity(), product.isAvailable()
                )).collect(Collectors.toList());
    }

    public ProductDTO fetchOneById(Long productId) {
        Product product=productRepository.findByProductId(productId);
        return new ProductDTO(product.getProductName(), product.getProductCategory(), product.getPrice(),
                product.getProductDescription(), product.getProductQuantity(), product.isAvailable());
    }

    public List<ProductDTO> fetchProductsByDescriptionContains(String description) {
        return productRepository.findProductsByProductDescriptionContainingIgnoreCase(description)
                .stream()
                .map(product -> new ProductDTO(
                        product.getProductName(), product.getProductCategory(), product.getPrice(),
                        product.getProductDescription(), product.getProductQuantity(), product.isAvailable()
                )).collect(Collectors.toList());
    }

    public Cart fetchCartById(Long cartId) {
        Optional<Cart> exists= Optional.of(cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("CART OF id %s COULDN'T BE FOUND", cartId)
                )));
        return cartRepository.findCartByCartId(cartId);
    }

    public List<Cart> fetchAllCarts() {
        return cartRepository.findAll();
    }

    public ProductDTO addNewProduct(ProductDTO productDTO) {
        Optional<Product> exists=productRepository.findByProductNameIgnoreCase(productDTO.getProductName());
        if (exists.isPresent()){
            throw new IllegalArgumentException(String
                    .format("%s is already saved",productDTO.getProductName()));
        }
        Product product = getProduct(productDTO);

        productRepository.save(product);
        return productDTO;
    }

    private static Product getProduct(ProductDTO productDTO) {
        Product product=new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductCategory(productDTO.getProductCategory());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductQuantity(productDTO.getProductQuantity());
        product.setPrice(productDTO.getPrice());
        product.setAvailable(productDTO.isAvailable());

        //TODO: complete on image upload functionality
        product.setImageId(null);
        return product;
    }

    public ProductDTO updateProductInfo(Long productId,ProductDTO productDTO) {
        Optional<Product> exists=productRepository.findById(productId);
        if (exists.isEmpty()){
            throw new IllegalArgumentException(String
                    .format("%s is NOT SAVED",productDTO.getProductName()));
        }
        Product product= productRepository.findProductByProductName(productDTO.getProductName());
        product.setProductName(productDTO.getProductName());
        product.setProductCategory(productDTO.getProductCategory());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductQuantity(productDTO.getProductQuantity());
        product.setPrice(productDTO.getPrice());
        product.setAvailable(productDTO.isAvailable());

        //TODO: complete on image update functionality
        product.setImageId(null);
        productRepository.save(product);

        return productDTO;
    }

    public ProductDTO updateProductQuantity(Long productId, Integer productQuantity) {

        Optional<Product> exists=productRepository.findById(productId);
        if (exists.isEmpty()){
            throw new IllegalArgumentException(String
                    .format("PRODUCT OF ID %s is NOT SAVED",productId));
        }
        Product product=productRepository.findByProductId(productId);
        product.setProductQuantity(productQuantity);
        //TODO: we can also implement an automatic scanning functional that is alerted whenever product quantity is low

        return new ProductDTO(product.getProductName(), product.getProductCategory(),product.getPrice(),
                product.getProductDescription(), product.getProductQuantity(),product.isAvailable());
    }

    public List<ProductDTO> fetchProductByCategory(String productCategory) {

        return productRepository.findProductsByProductCategoryContainingIgnoreCase(productCategory)
                .stream()
                .map(product -> new ProductDTO(
                        product.getProductName(), product.getProductCategory(), product.getPrice(),
                        product.getProductDescription(), product.getProductQuantity(), product.isAvailable()
                )).collect(Collectors.toList());
    }

    public ResponseEntity<Cart> createCart(Long customerId,Long productId) {
        Optional<Product> product=productRepository.findById(productId);

        if (product.isEmpty()){
            throw new IllegalArgumentException(String.format(
                    "The Product OF ID %S COULDN'T BE FOUND",productId
            ));
        }
            Cart cartsByCustomerId = cartRepository.findCartsByCustomerId(customerId);
            Product product1 = productRepository.findByProductId(productId);

            if (cartsByCustomerId != null) {
                List<Product> products = cartsByCustomerId.getProductList();
                products.add(product1);
                cartsByCustomerId.setProductList(products);
                cartRepository.save(cartsByCustomerId);
                return ResponseEntity.ok(cartsByCustomerId);
            }
        Cart cart = new Cart();
            cart.setCustomerId(customerId);

            cart.setProductList(List.of(product1));
            cartRepository.save(cart);

        return ResponseEntity.ok(cart);

    }

    public ResponseEntity<Cart> removeProductFromCart(Long customerId, Long productId) {
        Cart cart=cartRepository.findCartsByCustomerId(customerId);
        if(cart==null){
            throw new IllegalArgumentException(String.format("THIS CUSTOMER OF ID %S DOES NOT HAVE A CART CURRENTLY",
                    customerId));
        }
        List<Product> productList=cart.getProductList();

        for (int i = 0; i < productList.size(); i++) {
            Product product=productList.get(i);

            if (Objects.equals(product.getProductId(), productId)){
                productList.remove(product);
                i=productList.size();
            }
        }
        cart.setProductList(productList);
        cartRepository.save(cart);

        return ResponseEntity.ok(cart);
    }

    public List<Product> fetchAllProductsWholly() {
        return productRepository.findAll();
    }

    public List<Cart> deleteAllCarts() {
        cartRepository.deleteAll();
        return cartRepository.findAll();
    }
}
