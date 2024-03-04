package com.study.mvc.Dto;

import lombok.Data;


@Data
public class StudentReqDto {

    private String studentname;
    private int studentage;
    private String studentphone;
    private  String studentaddress;

    public StudentResDto toResDto() {
        return StudentResDto.builder()
                .studentname(getStudentname())
                .studentage(getStudentage())
                .studentphone(getStudentphone())
                .studentaddress(getStudentaddress())
                .build();

    }
}
