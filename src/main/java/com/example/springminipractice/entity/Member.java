package com.example.springminipractice.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private int age;

    public Member(String name,int age){
        this.name = name;
        this.age = age;
    }

}
