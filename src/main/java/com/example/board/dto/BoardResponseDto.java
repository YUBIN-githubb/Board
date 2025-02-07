package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private Long id;

    private String title;

    private String contents;

    public static BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
    }


}
