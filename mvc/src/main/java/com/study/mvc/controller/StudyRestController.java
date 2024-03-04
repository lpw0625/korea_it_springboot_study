package com.study.mvc.controller;

import com.study.mvc.Dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;



@RestController
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto) {
        // String을 자동으로 Parshing으로 해서 들어간다.

        System.out.println(helloDto);

        return "Hello";
    }
}

//RestController : Html은 따로 만들수는 없지만 이 컨트롤러는 모두 데이터로 응답 받는다.
