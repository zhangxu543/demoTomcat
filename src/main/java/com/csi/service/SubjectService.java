package com.csi.service;

import com.csi.domain.Subject;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:36
 */

public interface SubjectService {
    List<Subject> findByLike(String name) ;
    Subject findById(int id) ;
    List<Subject> list();
    void save(Subject subject) ;
    void delete(int id);
    void update(Subject major);
}