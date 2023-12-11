package com.example.demo.board.service;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
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
                .build();

        return boardRepository.save(newBoard);
    }
}
