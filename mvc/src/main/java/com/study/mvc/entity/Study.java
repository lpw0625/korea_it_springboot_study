package com.study.mvc.entity;

import com.study.mvc.Dto.DBStudySelectRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Study {
    private  int id;
    private  String name;
    private  int age;
    private LocalDateTime createDate; // 자바에서 쓰므로

    public DBStudySelectRespDto toDto() { /// DBStudySelectRespDto 리턴
        return DBStudySelectRespDto.builder() // 리턴을 하는데 빌더 패턴으로  DBStudySelectRespDto 생성

                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}

//  DTO >> C >> (DTO) >> S (DTO>>Entity >> E (Table이랑 같은형태) >> R

// db에 들거온것들을 보관용
//
// 데이터베이스에 가져온 형식들로 갖춰져야 한다.

// mysql의 테이블을 따라간다 .
//
// 빌더를 쓰기위해선 AllArgsConstructor 가 있어야 한다.