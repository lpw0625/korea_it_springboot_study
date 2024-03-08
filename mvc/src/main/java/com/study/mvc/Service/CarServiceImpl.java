package com.study.mvc.Service;

import com.study.mvc.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {


    @Autowired
    @Qualifier("a")
    private CarRepository carRepository;

    public String getCarNames() {
      return String.join(",", carRepository.getCarNames());
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
