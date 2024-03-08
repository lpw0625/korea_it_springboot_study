package com.study.mvc.diAndIoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component

public class IocService {

     // 클래스가 생성이 될 때  // 그냥쓰면 기본값으로 true로 잡혀져 있음.
    @Autowired
    private  IocRepository iocRepository;  // 상수가 된다 상수는 무조건 초기화 한번은 된다.

    /*
    private final IocRepository iocRepository;
    private final IocRepository iocRepository;
    private final IocRepository iocRepository;
    private final IocRepository iocRepository; */ // 만약에 스캔할 상수가 많으면 RequriedArgsConstructor를 쓴다.

    // 단점 : final을 붙였기에 무조건 true인 상태이므로 주입이 되어야 한다.


    public String getJson()  throws JsonProcessingException {
       Map<String, String> nameMap =  iocRepository.convertNameMap();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(nameMap);


        return objectMapper.writeValueAsString(nameMap);
    }
}
