package com.study.mvc.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HelloDto {

    private String name;
    private  int age;

    // @AllArgsConstructor : 모든 값이 필수값이 되어버린다.
    // @NoArgsConstructor : 기본 값이 되어버린다.
    // dto는 빌더랑 AllArgsConstructor 를 쓰지 않는다.


}
