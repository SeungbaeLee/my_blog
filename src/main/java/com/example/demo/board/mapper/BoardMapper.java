package com.example.demo.board.mapper;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.Board;
import com.example.demo.comment.entity.Comment;
import com.example.demo.tag.entity.BoardTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    //List<Comment>를 List<String>으로 명시적으로 변환
    default List<String> mapCommentListToStringList(List<Comment> comments) {
        return comments.stream()
                .map(Comment::getContent)
                .collect(Collectors.toList());
    }

    default List<String> mapBoardTagListToStringList(List<BoardTag> tags) {
        return tags.stream()
                .map(BoardTag::getTagName)
                .collect(Collectors.toList());
    }

    default List<BoardTag> mapStringListToBoardTagList(List<String> tags) {
        return tags.stream()
                .map(tagName -> BoardTag.builder().tagName(tagName).build())
                .collect(Collectors.toList());
    }


    @Mapping(target = "category.categoryId", source = "categoryId")
    Board boardPostToBoard(BoardDto.Post post);

    Board boardPatchToBoard(BoardDto.Patch patch);

    @Mapping(target = "comments", source = "commentList")
    @Mapping(target = "member", source = "member.name")
    @Mapping(target = "category", source = "category.categoryName")
    @Mapping(target = "tags", source = "tags")
    BoardDto.Response boardToResponse(Board board);

    List<BoardDto.Response> boardsToResponseDto(List<Board> boards);
}
