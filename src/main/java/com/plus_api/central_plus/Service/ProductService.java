package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.ProductModel;
import com.plus_api.central_plus.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to get all products
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to get a product by id
    public Optional<ProductModel> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Method to create a new product
    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }

    // Method to update a product
    public ProductModel updateProduct(Long id, ProductModel productDetails) {
        ProductModel product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
       // product.setCreation_Date(LocalDate.now());
        product.setUpdate_date(LocalDate.now());// update creation date to the current date if needed
// Only update dates if they are provided in the request
        if (productDetails.getCreationDate() != null) {
            product.setCreationDate(productDetails.getCreationDate());
        }

        if (productDetails.getUpdateDate() != null) {
            product.setUpdateDate(productDetails.getUpdateDate());
        } else {
            product.setUpdateDate(LocalDate.now()); // Set the update date to current date if not provided
        }


        return productRepository.save(product);
    }

    // Method to delete a product by id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
