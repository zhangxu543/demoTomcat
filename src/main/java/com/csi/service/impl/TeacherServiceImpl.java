package com.csi.service.impl;

import com.csi.dao.TeacherDao;
import com.csi.domain.Teacher;
import com.csi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 21:10
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao dao;
    @Override
    public List<Teacher> findByLike(Map<String, Object> map) {
        return dao.findByLike(map);
    }

    @Override
    public Teacher findById(String teaId) {
        return dao.findById(teaId);
    }

    @Override
    public Teacher login(String teaId, String password) {
        return dao.login(teaId,password);
    }

    @Override
    public void insert(Teacher teacher) {
        dao.insert(teacher);
    }

    @Override
    public void updateByID(Teacher teacher) {
        dao.updateByID(teacher);
    }

    @Override
    public void delete(String teaId) {
        dao.delete(teaId);
    }
}