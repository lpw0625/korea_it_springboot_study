package com.study.mvc.Repository;

import java.util.List;

public interface StudentRepository {

   public List<String> getStudentListAll();

   public String findStudentNameByIndex(int index);

   // 인덱스 기준으로 학생 이름을 찾아라.
   //  디폴트는 같은 패키지에서만 호출이 가능하다.
   // 인터페이스들의 메소드들은 public이다.
   // 이런 기능이다라는 것을 구체화 시킴 .
   //




}
