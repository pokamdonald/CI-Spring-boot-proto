package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.CategoryMarchandModel;
import com.plus_api.central_plus.Repository.CategoryMarchandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMarchandService {

    @Autowired
    private CategoryMarchandRepository categoryMarchandRepository;

    // Get all categories
    public List<CategoryMarchandModel> getAllCategories() {
        return categoryMarchandRepository.findAll();
    }

    // Get a single category by ID
    public CategoryMarchandModel getCategoryById(Long id) {
        return categoryMarchandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Create a new category
    public CategoryMarchandModel createCategory(CategoryMarchandModel category) {
        return categoryMarchandRepository.save(category);
    }

    // Update an existing category
    public CategoryMarchandModel updateCategory(Long id, CategoryMarchandModel categoryDetails) {
        CategoryMarchandModel category = categoryMarchandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDetails.getName());
        return categoryMarchandRepository.save(category);
    }

    // Delete a category
    public void deleteCategory(Long id) {
        CategoryMarchandModel category = categoryMarchandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryMarchandRepository.delete(category);
    }
}
