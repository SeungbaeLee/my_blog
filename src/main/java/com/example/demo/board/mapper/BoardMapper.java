package com.example.demo.board.mapper;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    Board boardPostToBoard(BoardDto.Post post);

    Board boardPatchToBoard(BoardDto.Patch patch);

    @Mapping(target = "comments", source = "commentList")
    @Mapping(target = "member", source = "member.name")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "tags", source = "tags")
    BoardDto.Response boardToResponse(Board board);
}
