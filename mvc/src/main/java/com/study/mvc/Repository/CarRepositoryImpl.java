package com.study.mvc.Repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("a") // 카멜 표기법으로 자동으로 컴포넌트 이름을 ioc에 저장한다.
// Repostiory : 데이터 연결
//@Service // 트랜잭션 관리, 로그
public class CarRepositoryImpl implements  CarRepository {

    //private final String componentName = "a";

            // 업캐스팅
            // 여러개의 객체들을 장착을 시키고 싶을때 메소드들을 맞춘다.

    @Override

    public List<String> getCarNames() {
        return List.of("아반떼", "소나타");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량 " + carName);
        return 1;
    }
}
