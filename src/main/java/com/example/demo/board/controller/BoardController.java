package com.example.demo.board.controller;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.entity.Board;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.global.page.PageDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{categoryId}")
    public ResponseEntity readBoardsOfCategory(Pageable pageable,@PathVariable("categoryId") @Positive Long categoryId) {
        Page<Board> boardPage = boardService.readBoardsOfCategory(pageable, categoryId);
        List<Board> boardList = boardPage.getContent();
        return new ResponseEntity<>(new PageDto<>(boardMapper.boardsToResponseDto(boardList), boardPage), HttpStatus.OK);
    }

    //글 수정

    //글 삭제
}
