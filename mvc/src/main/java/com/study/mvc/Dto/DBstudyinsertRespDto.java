package com.study.mvc.Dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DBstudyinsertRespDto {

    private int id;
    private  String name;
    private  int age;
    private  boolean successStatus;
    private int successCount;

    //내가 응답해주고 싶은 정보들만 입력


}
