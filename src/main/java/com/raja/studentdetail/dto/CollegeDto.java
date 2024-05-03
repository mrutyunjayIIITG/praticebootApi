package com.raja.studentdetail.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor

@NoArgsConstructor
@Getter
@Setter
public class CollegeDto {
    private int    collegeId;
    private String  collegeName;
    private String  collegeAddress;
}
