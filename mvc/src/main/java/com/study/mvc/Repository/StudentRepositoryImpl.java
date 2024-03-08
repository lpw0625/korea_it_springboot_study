package com.study.mvc.Repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 이 자체가 컴포넌트
public class StudentRepositoryImpl implements StudentRepository {
    private List<String> studentList = List.of("전주환", "서창현", "예홍렬");
    // studentList = ["전주환", "서창현", "예홍렬"]  선언
    // List<String> : 리스트에 있는 값은 문자열이기에 String이다
    //

    @Override
    public List<String> getStudentListAll() {
        return studentList;  // 메서드를 호출하면 studentList가 리턴이 된다.
        }

    @Override
    public String findStudentNameByIndex(int index) { return studentList.get(index);



    }
}

