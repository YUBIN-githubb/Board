package com.example.board.controller;

import com.example.board.dto.SignupRequestDto;
import com.example.board.dto.SignupResponseDto;
import com.example.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원 가입
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto dto) {
        SignupResponseDto signupResult = memberService.signup(
                dto.getUsername(),
                dto.getPassword(),
                dto.getAge()
        );

        return new ResponseEntity<>(signupResult, HttpStatus.CREATED);
    }
}
