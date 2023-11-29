package com.example.demo.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post{

        @NotBlank(message = "내용을 입력해주세요")
        private String content;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {

        @NotBlank(message = "내용을 입력해주세요")
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {

        private long commentId;
        private String content;
        private String memberName;
        private long boardId;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }

}
