package com.raja.studentdetail.dto;

import com.raja.studentdetail.entity.College;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDto {
    private String firstName;

    private String lastName;
    private String email;
    private int age;
    private College college;


}