package com.example.demo.category.mapper;

import com.example.demo.board.entity.Board;
import com.example.demo.category.dto.CategoryDto;
import com.example.demo.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category categoryPostToCategory(CategoryDto.Post post);

    Category categoryPatchToCategory(CategoryDto.Patch patch);


    @Mapping(target = "boards", source = "boardList")
    CategoryDto.Response categoryToResponse(Category category);

    default List<String> mapBoardListToBoardNames(List<Board> boardList) {
        return boardList.stream()
                .map(Board::getTitle)
                .collect(Collectors.toList());
    }
}
