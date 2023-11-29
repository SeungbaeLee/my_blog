package com.example.demo.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

public class tagDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post{

        @NonNull
        private String tagName;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private long tagId;
        private String tagName;
    }
}
