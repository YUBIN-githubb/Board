package com.example.board.controller;

import com.example.board.dto.CreateBoardRequestDto;
import com.example.board.dto.CreateBoardResponseDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    //의존성 주입할 때 final 키워드 빼먹지 말기
    //final 없으면 @RequiredArgsConstructor가 생성자 못만듬
    private final BoardService boardService;

    //게시물 생성
    @PostMapping
    public ResponseEntity<CreateBoardResponseDto> createBoard(@RequestBody CreateBoardRequestDto dto) {
        CreateBoardResponseDto savedBoard = boardService.save(dto.getTitle(), dto.getContents(), dto.getUsername());

        CreateBoardResponseDto createBoardResponseDto = new CreateBoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
        return new ResponseEntity<>(createBoardResponseDto, HttpStatus.CREATED);
    }
}
