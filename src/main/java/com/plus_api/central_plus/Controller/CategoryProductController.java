package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.CategoryProductModel;
import com.plus_api.central_plus.Service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriesproduct")
public class CategoryProductController {

    @Autowired
    private CategoryProductService categoryProductService;

    // Get all categories
    @GetMapping
    public List<CategoryProductModel> getAllCategories() {
        return categoryProductService.getAllCategories();
    }

    // Get a single category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryProductModel> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryProductService.getCategoryById(id));
    }

    // Create a new category
    @PostMapping
    public ResponseEntity<CategoryProductModel> createCategory(@RequestBody CategoryProductModel category) {
        return ResponseEntity.ok(categoryProductService.createCategory(category));
    }

    // Update an existing category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryProductModel> updateCategory(@PathVariable Long id, @RequestBody CategoryProductModel category) {
        return ResponseEntity.ok(categoryProductService.updateCategory(id, category));
    }
}
