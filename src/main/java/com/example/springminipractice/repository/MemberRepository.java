package com.example.springminipractice.repository;

import com.example.springminipractice.dto.MemberResponseDto;
import com.example.springminipractice.entity.Member;

public interface MemberRepository {

    MemberResponseDto signUp(Member member);

}
