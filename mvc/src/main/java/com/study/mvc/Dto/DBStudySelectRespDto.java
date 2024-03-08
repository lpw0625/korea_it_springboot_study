package com.study.mvc.Dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DBStudySelectRespDto {

    private  int id;
    private  String name;
    private  int age;
}
