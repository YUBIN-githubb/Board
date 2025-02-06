package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateBoardResponseDto {
    private Long id;

    private String title;

    private String contents;
}
