package com.csi.service;

import com.csi.domain.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:25
 */

public interface TeacherService {
    List<Teacher> findByLike(Map<String,Object> map);
    Teacher findById(String teaId);
    Teacher login(String teaId, String password);
    void insert(Teacher teacher);
    void updateByID(Teacher student);
    void delete(String teaId);
}