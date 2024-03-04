package com.study.mvc.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResDto {

    private String studentname;
    private int studentage;
    private String studentphone;
    private String studentaddress;

}