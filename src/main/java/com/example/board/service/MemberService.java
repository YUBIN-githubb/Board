package com.example.board.service;

import com.example.board.dto.SignupResponseDto;
import com.example.board.entity.Member;
import com.example.board.repositoy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
