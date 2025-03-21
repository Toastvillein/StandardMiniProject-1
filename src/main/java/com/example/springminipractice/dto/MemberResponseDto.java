package com.example.springminipractice.dto;

import com.example.springminipractice.entity.Member;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.PrimitiveIterator;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String name;
    private int age;


    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
    }


}
