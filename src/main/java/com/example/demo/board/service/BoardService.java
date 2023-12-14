package com.example.demo.board.service;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    //Create
    public Board createBoard(Board board) {

        Optional<Category> optionalCategory = categoryRepository.findByCategoryName(board.getCategory().getCategoryName());
        Category category = optionalCategory.orElseThrow(() -> new RuntimeException("해당하는 Category가 없습니다."));// 나중에 예외처리
        Board newBoard = Board.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .commentList(new ArrayList<>())
                .tags(board.getTags())
                .category(category)
                .build();
        return boardRepository.save(newBoard);
    }

    //Read
    public Page<Board> readBoardsOfCategory(Pageable pageable, long categoryId) {
        Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return boardRepository.findByCategory_CategoryId(pageRequest, categoryId);
    }
}
