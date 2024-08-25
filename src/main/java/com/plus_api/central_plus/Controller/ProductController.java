package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.ProductModel;
import com.plus_api.central_plus.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product") // Setting the base URL to /product
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        Optional<ProductModel> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new product
    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel product) {
        return productService.createProduct(product);
    }

    // Update an existing product by ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
