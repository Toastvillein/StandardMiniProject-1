package com.example.springminipractice.service;

import com.example.springminipractice.dto.MemberRequestDto;
import com.example.springminipractice.dto.MemberResponseDto;

public interface MemberService {

    MemberResponseDto signUp(MemberRequestDto dto);


}
