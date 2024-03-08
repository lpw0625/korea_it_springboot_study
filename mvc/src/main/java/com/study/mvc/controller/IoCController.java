package com.study.mvc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import com.study.mvc.diAndIoc.IocService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class IoCController {


    private final IocService iocService;

    // 제어의 역전 , Ioc컨테이너
    // Ioc컨테이너 : 객체들이 쌓여 있고 싱글톤과 유사함.
    // 컴포넌트 객체, Bean 객체 직접 new를 하지 않는다.
    // 쓸때는 똑같이 맞춰줘야한다.
    // ioc 를 쓰는 이유
    // 메모리  할당하기는 것에 한정적이기에
    // 하나만 있으면 객체드ㅜㄹ 등록하고 갖다쓰는것
    // autowired ioc 객체들을 갖다 쓰게 해주는 것.

    @GetMapping("/ioc")
    public ResponseEntity<?> iocTest() throws JsonProcessingException {
     String json = iocService.getJson();

        return ResponseEntity.ok(json); // 주소참조
    }
}
