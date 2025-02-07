package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardWithAgeResponseDto {

    private Long id;

    private String title;

    private String contents;

    private Integer age;
}
