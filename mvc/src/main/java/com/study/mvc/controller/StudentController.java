package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.Dto.StudentReqDto;
import com.study.mvc.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {


    //===========postman 요청
    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue String students, @RequestBody Student student) throws JsonProcessingException { // 파라미터 요청을 할때 RequestBody를 쓴다 왜? JSON때문에// JSON이 아니면 RequestBody를 빼야한다.
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;
        if(students != null) {
            if(!students.isBlank()) {
                ObjectMapper studentsCookie = new ObjectMapper();
                studentList = studentsCookie.readValue(students, List.class);
                lastId = studentList.get(studentList.size() - 1).getStudentId();
            }

        }
        student.setStudentId(lastId + 1);
        studentList.add(student);

        ObjectMapper newStudentList = new ObjectMapper();
        String newStudents = newStudentList.writeValueAsString(studentList);
        ResponseCookie responseCookie = ResponseCookie
                .from("students", newStudents)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .domain("localhost:8080")
                .build();
        // Cookie : " 문자 저장이 x

        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(student);
    }

    /**
     * Controller명: StudentController
     * <p>
     * 메소드명:getStudentInfo()
     * 요청 메소드 Get
     * 요청 URL: /student
     * 요청 Params : name, age, phone, address
     * 응답데이터: JSON(name, age, phone, address)
     */


    @GetMapping("/student")
    public ResponseEntity<?> getStudentInfo(StudentReqDto studentReqDto) {
        System.out.println(studentReqDto);

        return ResponseEntity.badRequest().body(studentReqDto.toResDto());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable int studentId) { // 변수명과 자료형이 동일하면 자동으로 들고온다.
        List<Student> studentList = List.of(
                new Student(1, "이평원"),
                new Student(2, "이평이"),
                new Student(3, "이평삼"),
                new Student(4, "이평사")
                );


        // id를 가지고 학생 데이터를 조회
        // 만약 존재하지 않는 id를 입력할 시 존재하지 않는 ID입니다.
        Student findStudent = null;
        for(Student student : studentList) {
            if(student.getStudentId() == studentId) {
                findStudent = student;
            }
        }

        // 필터 방식
        // Optional<Student> optionalStudent =
        // studentList.steram().filter(student -> student.getStudentID()  == studentId).findFirst();
        // if(optionalStudent.isEmpty()) {
        // return ResponseEntitiy.badRequest().Body(Map.of("errorMseeage", "존재하지 않는 id입니다"));
        // }
        // findStudent = optionalStudent.get();
       if(findStudent == null) {
        return ResponseEntity.ok().body(Map.of("errorMessage", "존재하지 않는 ID입니다."));


            }

       return ResponseEntity.ok().body(findStudent);
        }
}
/*
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentname("이평원");
        studentInfo.setStudentage(30);
        studentInfo.setStudentphone("010-2909-1213");
        studentInfo.setStudentaddress("경남 양산");

        */

// 앞으로 ResponseEntity 로만 할것이고 뒤에는 상태 코드를 쓸 것이다.
// ResponseEntity<?> : 내가 들어갈 데이터를 입력을 한다. 명시하는걸 좋지만 그러면 코드가 난잡해질수도 있다.
// ResponseEntity : 이걸 쓰게되면 상태코드를 바꿔줄 수 있다.  ***
// PathVariable ***
// 이걸 안쓰면 리엑트에서 querySelector를 쓰지 말라는 것과 같다는 의미이다.
