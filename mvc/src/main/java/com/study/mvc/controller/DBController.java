package com.study.mvc.controller;


import com.study.mvc.Dto.DBstudyReqDto;
import com.study.mvc.Service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DBController {

    @Autowired
    private DBStudyService dbStudyService; // 호출

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBstudyReqDto dBstudyReqDto) {


        return ResponseEntity.ok(dbStudyService.createStudy(dBstudyReqDto));

        //@RequestBody: json 데이터를 받음
        //dto : key,value 기준으로 만듬
        // c >> s >> R >(mybatis)> DB
        // entitiy를 다시
        // 서비스에서 받아온 enti
    }

    @GetMapping("/select/study/{id}")
    public ResponseEntity<?> selectStudy(@PathVariable int id) {

        return ResponseEntity.ok(dbStudyService.findStudyById(id));
    }

    @GetMapping("/select/study")  /// ?name = 이평원 이런식으로 요청을 할 것이다.
    public ResponseEntity<?> selectStudy(@RequestParam String name) {
            return ResponseEntity.ok(dbStudyService.findStudyByName(name));
    }

    @GetMapping("/select/studies")
    public ResponseEntity<?> selectStudyAll() {
        return ResponseEntity.ok(dbStudyService.findAll());
    }
    @DeleteMapping("/delete/study/{id}")
    public ResponseEntity<?> deleteStudy(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.deleteById(id));
    }

    @PutMapping("/update/study/{id}")
    public ResponseEntity<?> updateStudy(

            @PathVariable int id,
            @RequestBody DBstudyReqDto dBstudyReqDto) {
        // 전체 수정
        // 값을 다 지우면 지워진 값이 DB에 저장이 된다.
        // ex {nickname: aaa, password: 1234} => {nickname: "", password: 1111}
        //이대로 저장.


        return ResponseEntity.ok(dbStudyService.putByID(id, dBstudyReqDto));

    }


    @PatchMapping("/update/study/{id}")
    public ResponseEntity<?> patchStudy(
            @PathVariable int id,
            @RequestBody DBstudyReqDto dBstudyReqDto) {
        // 부분 수정
        //DB에 빈값을 보내면 수정을 할 게 없다고 취급을 한다.
        // 바뀐 부분만 업데이트를 한다.
        //ex {nickname: aaa, password: 1234} => {nickname: "", password: null} => {nickname: aaa, password: 1111}

        return ResponseEntity.ok(dbStudyService.patchByID(id,dBstudyReqDto));

    }
}
