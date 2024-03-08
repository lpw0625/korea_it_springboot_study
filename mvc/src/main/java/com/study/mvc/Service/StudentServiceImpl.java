package com.study.mvc.Service;

import com.study.mvc.Dto.StudentExDto;
import com.study.mvc.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor // final을 달면
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    // >> 레파시토리를 불러옴


    @Override
    public List<?> getStudentList() {
        List<StudentExDto> studentDtoList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudentListAll();

        for(String studentName : studentList) {
            studentDtoList.add(new StudentExDto (studentName));
        }

        return studentDtoList; // studentMapList를 만들기 위한 목표
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentNameByIndex(index);
        // return Map.of("name", studentName);
        return new StudentExDto(studentName);

        // StudentExDto 객체를 생성하여 반환
        //
    }
}



