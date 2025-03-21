package com.example.springminipractice.service;

import com.example.springminipractice.dto.MemberRequestDto;
import com.example.springminipractice.dto.MemberResponseDto;
import com.example.springminipractice.entity.Member;
import com.example.springminipractice.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponseDto signUp(MemberRequestDto dto) {

        Member member = new Member(dto.getName(), dto.getAge());

        return memberRepository.signUp(member);
    }

    @Override
    public MemberResponseDto check(String name) {

        Member member = memberRepository.check(name);

        return new MemberResponseDto(member);
    }


}
