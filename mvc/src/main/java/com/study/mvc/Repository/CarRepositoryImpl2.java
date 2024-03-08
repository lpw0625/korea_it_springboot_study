package com.study.mvc.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarRepositoryImpl2 implements  CarRepository {


   //  a컴포넌트를 가져와서 들고오겠다,b컴포넌트를 가져와서 들고오겠다.
    // 필드명과 컴포넌트 명이 일치하면 자동으로 주입된다.
    // 이름이 불일치 하면 그 다음엔 같은 인터페이스인가를 확인한다.
    // 지금 예제는 이름이 달라서 두 개중 뭘 넣어야할지 모르는 상태
    // 캄포넌트 끼리 오토와이어 가 가능.
    // dto : ioc에 들어온걸 못씀
    // ioc

    // 대입을 할 객체가 2개라면?
    // 내가 뭘 주입을 해야할지 모르겠다.라는 상태가 됨

            // 업캐스팅
            // 여러개의 객체들을 장착을 시키고 싶을때 메소드들을 맞춘다.

    @Override

    public List<String> getCarNames() { return List.of("k3", "k5");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량 " + carName);
        return 1;
    }
}
