package com.study.mvc.Repository;

import com.study.mvc.entity.Study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DBStudyRepository {
    public int save(Study study);
    public Study findStudyById(int id);
    public Study findStudyByName(String name); // name이 유니크 키이기 때문
    public List<Study> findAll();
    public int deleteById(int id);
    public int putById(Study study);
    public int patchById(Study study);


    // 테이블 마다 레파시토리가 하나씩 있다고 생각하자.
    // 앞으로 레파시토리는 인터페이스 하나씩 추가될 예정.
    // xml 매개변수 save에 Study를 주는것
    // xml은 sql 테이블에서 dto로 변환된 것들을 entity로 바뀐것을 레파시토리에  들고오면 그 entitiy를 저장을 하는 것.
    //
}
