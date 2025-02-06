package com.example.board.controller;

import com.example.board.dto.MemberResponseDto;
import com.example.board.dto.SignupRequestDto;
import com.example.board.dto.SignupResponseDto;
import com.example.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //유저 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {
        MemberResponseDto findMember = memberService.findById(id);

        return new ResponseEntity<>(findMember, HttpStatus.OK);
    }
}
