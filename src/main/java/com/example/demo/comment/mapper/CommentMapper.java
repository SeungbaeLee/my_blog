package com.example.demo.comment.mapper;

import com.example.demo.comment.dto.CommentDto;
import com.example.demo.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentPostToComment(CommentDto.Post post);

    Comment commentPatchToComment(CommentDto.Patch patch);


    @Mapping(target = "memberName", source = "member.name")
    CommentDto.Response commentToResponse(Comment comment);
}
