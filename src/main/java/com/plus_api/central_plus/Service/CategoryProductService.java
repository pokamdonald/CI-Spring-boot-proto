package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.CategoryProductModel;
import com.plus_api.central_plus.Repository.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductService {

    @Autowired
    private CategoryProductRepository categoryProductRepository;

    // Get all categories
    public List<CategoryProductModel> getAllCategories() {
        return categoryProductRepository.findAll();
    }

    // Get a single category by ID
    public CategoryProductModel getCategoryById(Long id) {
        return categoryProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Create a new category
    public CategoryProductModel createCategory(CategoryProductModel category) {
        return categoryProductRepository.save(category);
    }

    // Update an existing category
    public CategoryProductModel updateCategory(Long id, CategoryProductModel updatedCategory) {
        CategoryProductModel existingCategory = categoryProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingCategory.setCategoryname(updatedCategory.getCategoryname());
        existingCategory.setDescription(updatedCategory.getDescription());
        existingCategory.setCreation_date(updatedCategory.getCreation_date());
        existingCategory.setUpdate_date(updatedCategory.getUpdate_date());

        return categoryProductRepository.save(existingCategory);
    }
}
