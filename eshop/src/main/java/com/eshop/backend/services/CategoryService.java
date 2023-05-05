package com.eshop.backend.services;

import com.eshop.backend.dto.CategoryDTO;
import com.eshop.backend.models.Category;
import com.eshop.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::toCategoryDTO).collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Long id) {
        return toCategoryDTO(getExistingCategory(id));
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
            Category category = new Category();
            category.setId(UUID.randomUUID().getMostSignificantBits());
            category.setName(categoryDTO.getName());
            category.setProducts(categoryDTO.getProducts());
        return toCategoryDTO(categoryRepository.save(category));
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = getExistingCategory(id);
        existingCategory.setName(categoryDTO.getName());
        existingCategory.setProducts(categoryDTO.getProducts());
        return toCategoryDTO(categoryRepository.save(existingCategory));
    }

    private Category getExistingCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(
                category.getName(),
                category.getProducts()
        );
    }
}
