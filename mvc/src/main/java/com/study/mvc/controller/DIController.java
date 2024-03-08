package com.study.mvc.controller;


import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController // component를 안달아도 됨.
public class DIController {
    /**
     *
     * DI(Dependency Injection) - 의존성 투입
     *
     */


    @GetMapping("/di")
    public ResponseEntity<?> diTest() {
        DiRepository diRepository = new DiRepository(); // 생성
        DiService diService = new DiService(diRepository); // 메모리 주소를 넘겨준다.

        Map<String, Object> responseData = Map.of
                (
                        "total", diService.getTotal(),
                        "average", diService.getAverage());


        // Map이 Json으로 변환이 된다.

        return ResponseEntity.ok().body(responseData);
        // 어떤 자료형인지 따라서 값이 맞춰서 들어간다.
    }
}


// 함수 : 기능
// 변수 : 데이터
// 클래스 : 자료혀으이 집합체

// ArrayList :
// 무엇을 담는가를 선택
// 정해놓고 이것만 들어와야한다.