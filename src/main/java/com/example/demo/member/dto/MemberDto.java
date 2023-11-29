package com.example.demo.member.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class MemberDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        @NonNull
        @Pattern(regexp = "^[a-zA-Z0-9+.-]+@[a-zA-Z0-9.-]+$")
        private String email;
        @NonNull
        @Pattern(regexp = ".{8,}")
        private String password;
        @NonNull
        @Pattern(regexp = ".{2,}")
        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private long memberId;
        private String name;
        private String email;
        private LocalDateTime createAt;
        private LocalDateTime modifiedAt;
        private List<String> boards;
        private List<String> comments;
    }
}
