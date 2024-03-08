package com.study.mvc.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

// Bean 수동 등록(2개 이상 등록 가능)
// 컴포넌트 등록한 것 이외에 수정을 하고 싶을때 사용

@Configuration // ***
// 무조건 클래스에서만 @component를 달 수 있ㄷ
public class BeanConfig {
// 메소드 에서만 빈을 쓸 수 있다.
    @Bean //리턴이 되어 ioc에 등록해서 오토와이어로 쓸 수 있다.
    public ObjectMapper objectMapper() {
        return  new ObjectMapper();
        // 컴포넌트는 메소드(function)명으로 쓰여진다.
        // 라이브러리 있는 것을 ioc로 바꿀때

    }


}


// 가장 기본인 컴포넌트, 컨트롤러, 서비스, 레파시토리, 컨피규레이션
//  이 다섯개는 무조건 알아야 한다.