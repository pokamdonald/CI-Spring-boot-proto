package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.CategoryMarchandModel;
import com.plus_api.central_plus.Service.CategoryMarchandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryMarchandController {

    @Autowired
    private CategoryMarchandService categoryMarchandService;

    // Get all categories
    @GetMapping
    public List<CategoryMarchandModel> getAllCategories() {
        return categoryMarchandService.getAllCategories();
    }

    // Get a single category by ID
    @GetMapping("/{id}")
    public CategoryMarchandModel getCategoryById(@PathVariable Long id) {
        return categoryMarchandService.getCategoryById(id);
    }

    // Create a new category
    @PostMapping
    public CategoryMarchandModel createCategory(@RequestBody CategoryMarchandModel category) {
        return categoryMarchandService.createCategory(category);
    }

    // Update an existing category
    @PutMapping("/{id}")
    public CategoryMarchandModel updateCategory(@PathVariable Long id, @RequestBody CategoryMarchandModel categoryDetails) {
        return categoryMarchandService.updateCategory(id, categoryDetails);
    }

    // Delete a category
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryMarchandService.deleteCategory(id);
    }
}
