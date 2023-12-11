package com.example.demo.board.controller;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.Board;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    //글 생성
    @PostMapping
    public ResponseEntity postBoard(@Valid @RequestBody BoardDto.Post boardPostDto) {
        Board board = boardMapper.boardPostToBoard(boardPostDto);
        Board savedBoard = boardService.createBoard(board);
        BoardDto.Response response = boardMapper.boardToResponse(savedBoard);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    //글 조회

    //글 수정

    //글 삭제
}
