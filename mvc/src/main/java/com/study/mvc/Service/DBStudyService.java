package com.study.mvc.Service;

import com.study.mvc.Dto.DBStudySelectRespDto;
import com.study.mvc.Dto.DBstudyReqDto;
import com.study.mvc.Dto.DBstudyinsertRespDto;
import com.study.mvc.Repository.DBStudyRepository;
import com.study.mvc.entity.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBStudyService {

    @Autowired
    private DBStudyRepository dbStudyRepository;

    public DBstudyinsertRespDto createStudy(DBstudyReqDto dBstudyReqDto) { //
        // 컨트롤러에 받아온 DTO를 넣는다.

        //  [All Args]
        //    Study study = new Study(0,dBstudyReqDto.getName(), dBstudyReqDto.getAge(), null);

        //[Noargu
        //   Study study = new Study();
        //  study.setName(dBstudyReqDto.getName());
        //  study.setAge(dBstudyReqDto.getAge());
        // [Builder ]
        // z커ㅗㄴ트롤러 서비스 사이엔 무조간 dto
        // json이 dto로 변환
            Study findStudy = dbStudyRepository.findStudyByName(dBstudyReqDto.getName());

            if(findStudy != null) {
                return DBstudyinsertRespDto.builder()
                        .successStatus(false) // 기본값이 false 이므로 안넣어줘도 일일이 안써줘도 된다.
                        .build();
            }


        Study study = Study.builder()
                .name(dBstudyReqDto.getName())
                .age(dBstudyReqDto.getAge())
                .build();
        // dto를 가져와서 study entity로 변환
        // 이걸 레파시토리에 보내줘야한다.

        int successCount = dbStudyRepository.save(study); //DBinsert를 시킴

        DBstudyinsertRespDto dBstudyinsertRespDto = DBstudyinsertRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0)
                .successCount(successCount)
                .build();


                return dBstudyinsertRespDto;

        //return dbStudyRepository.save(study);
        // 실행하면 1건 성공했다는 것으로 1이 들어온다.
        // 갈때 호출을 한다.
        //

    }

    public DBStudySelectRespDto findStudyById(int id) {
        Study study = dbStudyRepository.findStudyById(id);
        System.out.println(study);

            DBStudySelectRespDto dbStudySelectRespDto =
                    DBStudySelectRespDto.builder()
                            .id(study.getId())
                            .name(study.getName())
                            .age(study.getAge())
                            .build();
            return dbStudySelectRespDto;

            // dto로 변환하는 과정

    }

    public DBStudySelectRespDto findStudyByName(String name) {
        Study study = dbStudyRepository.findStudyByName(name);
        return study == null ? null : study.toDto(); // study라는 변수를 dto로 바꾸겠다.
    }

    public List<DBStudySelectRespDto> findAll() {
        List<DBStudySelectRespDto> respDtoList = new ArrayList<>(); // 담을 리스트를 만듬.
        List<Study> studyList = dbStudyRepository.findAll();

        for(Study study : studyList) {
            respDtoList.add(study.toDto());
            // studyList에 담겨진 값들을 하나씩 넣어 다시 담을 리스트에 넣는다.

        }
        return respDtoList;

    }


public List<DBStudySelectRespDto> findAll2() {
    return dbStudyRepository.findAll()
            .stream()
            .map(Study::toDto)
            .collect(Collectors.toList());
            // 그 스트림을 리스트로 바꿔라.
        }

        public int deleteById(int id) {
            return dbStudyRepository.deleteById(id);
        }

        public int putByID(int id, DBstudyReqDto dBstudyReqDto) {
            return dbStudyRepository.putById(dBstudyReqDto.toEntity(id));

        }

    public int patchByID(int id, DBstudyReqDto dBstudyReqDto) {
        return dbStudyRepository.patchById(dBstudyReqDto.toEntity(id));
    }

}


