package com.example.demo.category.controller;

import com.example.demo.category.dto.CategoryDto;
import com.example.demo.category.entity.Category;
import com.example.demo.category.mapper.CategoryMapper;
import com.example.demo.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    //카테고리 생성
    @PostMapping
    public ResponseEntity postCategory(@Valid @RequestBody CategoryDto.Post categoryPostDto) {
        Category category = categoryMapper.categoryPostToCategory(categoryPostDto);
        Category savedCategory = categoryService.createCategory(category);
        CategoryDto.Response response = categoryMapper.categoryToResponse(savedCategory);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    //카테고리 전체 조회

    //카테고리 단일 조회(카테고리 클릭 시 카테고리 내 글 전체 조회)

    //카테고리 이름 변경

    //카테고리 삭제
}
