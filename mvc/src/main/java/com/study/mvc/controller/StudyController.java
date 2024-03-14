package com.study.mvc.controller;

import com.study.mvc.Model.HelloModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@org.springframework.stereotype.Controller

public class StudyController {

        // 주소
        // http  요청을 할떄 Mapping으로 쓰인다 .
        // 서블릿을 여러개 만드는 것이 아닌
        // Controller 클래스를 만들어서
        // 메소드를 늘려서 서블릿처럼 쓸 예정이다.
        // 하나의 컨트롤러에 여러개의 서블릿이 들어갈 수 있다.
        // 여러 개의 get 요청을 넣을 수 있다.
        // 이게 가능한 이유는 DisPatch Servlet 의 개념 때문
        // 어떠한 요청이든 Dispatcer Servlet 으로 들어감.

        //MVC
        @GetMapping ("/hello")
 public  String helloPage(Model model) {
            HelloModel helloModel = HelloModel.builder()
                    .name1("이평원")
                    .name2("이평투")
                    .name3("이평삼")
                    .build();

            model.addAttribute("helloModel", helloModel);
            return "hello";
        }

    // ModelandView(파일명)

        //모델이랑 뷰를 갖춘 객체
        // thymeleaf : 경로 설정. // 리턴은 파일명으로 설정하면 된다.
        // test/hello >> 자동으로 html이랑 templet이 붙여진다.


        // REST (ResponseBody) 가 무조건 있어야 함.
        @GetMapping("/test") // 데이터만 리턴을 한다.
        @ResponseBody // Body: 데이터 >> response를 데이터로 하겠다.

        public Map<String, Object> testpage() {
            Map<String,Object> testObj = new HashMap<>();
            testObj.put("age", 32);
            return  testObj; //

        }

    }

// 이 두개의 차이점 ***
// ModelAndView 모델 맵이 따로 있다.
// 모델을 만들 수 있다.

// GetMapping : 모델이랑 뷰를 응답할 수 없다,
// 모델도 정해져있고 방법이 정해져있다.
// 이걸 많이 쓴다 .

// 메서드 하나하나가 부서라고 생각하면 된다
// ResponseBody가 붙어 있으면 무조건 데이터 응답이다.
