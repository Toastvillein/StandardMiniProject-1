package com.example.springminipractice.controller;

import com.example.springminipractice.dto.MemberRequestDto;
import com.example.springminipractice.dto.MemberResponseDto;
import com.example.springminipractice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MemberResponseDto> signUp(@RequestBody MemberRequestDto dto){

        return new ResponseEntity<>(memberService.signUp(dto), HttpStatus.CREATED);
    }



}
