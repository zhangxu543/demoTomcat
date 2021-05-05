package com.csi.service;

import com.csi.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:25
 */

public interface StudentService {
    Student findById(String stuId);
    Student login(String stuId,  String password);
    void insert(Student student);
    void updateByID(Student student);
    void updateSchoolRoll(Student student);
    List<Student> findByLike(Map<String,Object> map);
}