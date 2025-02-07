package com.example.board.service;

import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.BoardWithAgeResponseDto;
import com.example.board.dto.CreateBoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repositoy.BoardRepository;
import com.example.board.repositoy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BoardResponseDto> findAll() {
        // 리포지토리에서 findAll이 List<Board>타입으로 반환하기 때문에 Board에서 BoardResponse로 바꿔주는
        // 메서드가 필요함 -> BoardResponseDto 클래스에 구현되어 있음
        return boardRepository.findAll().stream().map(BoardResponseDto::toDto).toList();
    }

    public BoardWithAgeResponseDto findById (Long id) {
        Board board = boardRepository.findByIdOrElseThrow(id);

        return new BoardWithAgeResponseDto(board.getId(), board.getTitle(), board.getContents(), board.getMember().getAge());

    }

    public void deleteBoard (Long id) {
        Board board = boardRepository.findByIdOrElseThrow(id);

        boardRepository.delete(board);
    }
}
