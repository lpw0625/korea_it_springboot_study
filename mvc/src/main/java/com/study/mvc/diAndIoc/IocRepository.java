package com.study.mvc.diAndIoc;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
// 순서 >> 레파시토리 >> 서비스 >> 컨트롤러
// 모든 클래스에 컴포넌트를 달면 안된다
// 하나만 생성이 가능하다.
// 컴포넌트들끼리만 ioc가(autowired) 가능하다.
//
public class IocRepository {
    private  List<String> nameList = List.of("김도균", "정건희", "조성민");

    public Map<String, String> convertNameMap() {
        Map<String, String> nameMap = new HashMap<>();
        for(int i = 0; i < nameList.size(); i++) {
            nameMap.put("name" + (i + 1), nameList.get(i));

        }
        return  nameMap;

    }
}
