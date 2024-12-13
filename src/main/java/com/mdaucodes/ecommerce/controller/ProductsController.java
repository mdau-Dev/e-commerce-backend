package com.mdaucodes.ecommerce.controller;

import com.mdaucodes.ecommerce.entity.Cart;
import com.mdaucodes.ecommerce.entity.Product;
import com.mdaucodes.ecommerce.entity.ProductDTO;
import com.mdaucodes.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mdaucodes/products/")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> fetchAllProductsWholly(){
        return productService.fetchAllProductsWholly();
    }
    @GetMapping("/all")
    public List<ProductDTO> fetchAllProducts(){
        return productService.fetchAllProducts();
    }

    @GetMapping("/getOneProduct/{id}")
    public ProductDTO fetchOneById(
            @PathVariable(value = "id")Long productId
    ){
        return productService.fetchOneById(productId);
    }

    @GetMapping("/getByCategory/{category}")
    public List<ProductDTO> fetchProductByCategory(
            @PathVariable(value = "category")String productCategory
    ){
        return productService.fetchProductByCategory(productCategory);
    }
    @GetMapping("/getByDescription/{description}")
    public List<ProductDTO> fetchProductsByDescriptionOrName(
            @PathVariable(value = "description",required = true)String description
    ){
        return productService.fetchProductsByDescriptionOrName(description);
    }

    @GetMapping("/getCart/{id}")
    public Cart fetchCartById(
            @PathVariable(value = "id")Long cartId
    ){
        return productService.fetchCartById(cartId);
    }

    @GetMapping("/getAllCarts")
    public List<Cart> fetchAllCarts(){
        return productService.fetchAllCarts();
    }

    @PostMapping("/addProduct")
    public ProductDTO addNewProduct(
            @RequestBody ProductDTO productDTO
    ){
       return productService.addNewProduct(productDTO);
    }

    @PostMapping("/createCart/{customerId}/{productId}")
    public ResponseEntity<Cart> createCart(
            @PathVariable(value = "customerId")Long customerId,
            @PathVariable(value = "productId")Long productId

    ){
        return productService.createCart(customerId,productId);
    }

    @DeleteMapping("/deleteAllCarts")
    public List<Cart> deleteAllCarts(){
        return productService.deleteAllCarts();
    }
    @PostMapping("removeProductFromCart/{customerId}/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(
            @PathVariable(value = "customerId")Long customerId,
            @PathVariable(value = "productId")Long productId
    ){
        return productService.removeProductFromCart(customerId,productId);
    }
    @PostMapping("/updateProductInfo/{id}")
    public ProductDTO updateProductInfo(
            @PathVariable(value = "id")Long productId,
            @RequestBody ProductDTO productDTO
    ){
        return productService.updateProductInfo(productId,productDTO);
    }

    @PostMapping("/updateProductQuantity/{id}/{quantity}")
    public ProductDTO updateProductQuantity(
            @PathVariable(value = "id")Long productId,
            @PathVariable(value = "quantity")Integer productQuantity
    ){
        return productService.updateProductQuantity(productId,productQuantity);
    }
}
