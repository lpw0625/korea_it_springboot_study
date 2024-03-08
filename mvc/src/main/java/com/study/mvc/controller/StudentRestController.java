package com.study.mvc.controller;

import com.study.mvc.Repository.StudentRepository;
import com.study.mvc.Repository.StudentRepositoryImpl;
import com.study.mvc.Service.StudentService;
import com.study.mvc.Service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentRestController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private  StudentService studentService;

    // 시작은 컨트롤러 부터
  // StudentService 연결


    @GetMapping("/ex/students") // 응답 주소 설정.
    public ResponseEntity<?> students() {

        return ResponseEntity.ok(studentService.getStudentList());
    }



        @GetMapping("/ex/student/{index}")
        public ResponseEntity<?> student(@PathVariable int index) {

            // 학생 index 값을 정수로 받아오는 역활.
            return ResponseEntity.ok(studentService.getStudent(index));

        }

}




