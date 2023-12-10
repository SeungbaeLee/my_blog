package com.example.demo.category.service;

import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;
import com.example.demo.global.exception.BusinessException;
import com.example.demo.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category category;

    public Category createCategory(Category category) {

        Boolean newName = checkCategoryName(category.getCategoryName());
        if (!newName) {
            throw new BusinessException(ExceptionCode.CATEGORY_EXISTS);
        }

        Category newCategory = Category.builder()
                .categoryName(category.getCategoryName())
                .build();

        return categoryRepository.save(newCategory);
    }

    private Boolean checkCategoryName(String name) {
        Optional<Category> optionalCategory = categoryRepository.findByCategoryName(name);
        return optionalCategory.isEmpty();
    }
}
