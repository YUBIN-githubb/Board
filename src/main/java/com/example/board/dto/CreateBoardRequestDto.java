package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateBoardRequestDto {

    private String title;

    private String contents;

    private String username;
}
