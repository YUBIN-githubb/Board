package com.example.board.service;

import com.example.board.dto.CreateBoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repositoy.BoardRepository;
import com.example.board.repositoy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public CreateBoardResponseDto save(String title, String contents, String username) {
        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);
        Board newBoard = new Board(title, contents);
        newBoard.setMember(findMember);

        boardRepository.save(newBoard);

        return new CreateBoardResponseDto(newBoard.getId(), newBoard.getTitle(), newBoard.getContents());
    }
}
