package com.example.springminipractice.controller;

import com.example.springminipractice.dto.MemberRequestDto;
import com.example.springminipractice.dto.MemberResponseDto;
import com.example.springminipractice.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MemberResponseDto> signUp(@RequestBody @Valid MemberRequestDto dto){

        return new ResponseEntity<>(memberService.signUp(dto), HttpStatus.CREATED);
    }

    @GetMapping("/check/{name}")
    public ResponseEntity<MemberResponseDto> check(@PathVariable String name){

        return new ResponseEntity<>(memberService.check(name),HttpStatus.OK);
    }


}
