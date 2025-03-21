package com.example.springminipractice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberRequestDto {

    @Size(min=2)
    private String name;
    @Min(18)
    private int age;

}
