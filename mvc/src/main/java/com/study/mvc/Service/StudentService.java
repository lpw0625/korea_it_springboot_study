package com.study.mvc.Service;

import java.util.List;

public interface StudentService {

    public List<?> getStudentList();
    // Map으로 할건지 Dto로 할건지

    public Object getStudent(int index);

}
