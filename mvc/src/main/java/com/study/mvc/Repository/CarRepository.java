package com.study.mvc.Repository;

import java.util.List;

public interface CarRepository {

    public List<String> getCarNames();// 추상 메소드
    public int insertCar(String carName);
}
