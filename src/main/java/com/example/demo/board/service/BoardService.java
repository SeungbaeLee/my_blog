package com.example.demo.board.service;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public Board createBoard(Board board) {

        Board newBoard = Board.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .commentList(new ArrayList<>())
                .tags(board.getTags())
                .category(board.getCategory())
                .build();
        return boardRepository.save(newBoard);
    }

    public Page<Board> readBoardsOfCategory(Pageable pageable, long categoryId) {
        Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return boardRepository.findByCategory_CategoryId(pageRequest, categoryId);
    }
}
