package com.example.demo.member.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class MemberDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
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
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
