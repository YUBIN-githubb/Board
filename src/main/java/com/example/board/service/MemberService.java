package com.example.board.service;

import com.example.board.dto.MemberResponseDto;
import com.example.board.dto.SignupResponseDto;
import com.example.board.entity.Member;
import com.example.board.repositoy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignupResponseDto signup (String username, String password, Integer age) {
        Member member = new Member(username, password, age);
        Member savedMember = memberRepository.save(member);

        return new SignupResponseDto(
                savedMember.getId(),
                savedMember.getUsername(),
                savedMember.getAge()
                );
    }

    public MemberResponseDto findById (Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        //널포인터익셉션 방지
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다.");
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getId(), findMember.getUsername(), findMember.getAge());
    }


}
