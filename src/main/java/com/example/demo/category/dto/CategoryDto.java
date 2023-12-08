package com.example.demo.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CategoryDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "카테고리 이름을 작성해주세요")
        private String categoryName;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        @NotBlank(message = "카테고리 이름을 작성해주세요")
        private String categoryName;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long categoryId;
        private String categoryName;
        private List<String> boards;
    }
}
