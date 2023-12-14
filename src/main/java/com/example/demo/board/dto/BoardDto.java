package com.example.demo.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Not;

import java.time.LocalDateTime;
import java.util.List;

public class BoardDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        @NotBlank(message = "제목을 입력해주세요")
        private String title;

        @NotBlank(message = "내용을 입력해주세요")
        private String content;

        @NotEmpty(message = "태그를 입력해주세요")
        private List<String> tags;

        private String categoryName;

//        private List<String> imageUrl;   // 이미지 기능 추가 예정
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        @NotBlank(message = "제목을 입력해주세요")
        private String title;

        @NotBlank(message = "내용을 입력해주세요")
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long boardId;
        private String title;
        private String content;
        private long viewCount;
        private String member;//
        private String category;//
        private List<String> tags;//
        private List<String> comments;//
//        private List<String> imageUrl;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

    }

}
