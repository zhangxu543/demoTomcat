package com.csi.service.impl;

import com.csi.dao.StudentDao;
import com.csi.domain.Student;
import com.csi.service.StudentService;
import com.csi.util.StudentExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 21:02
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    public void insertExcel(List<Student> list) {
        dao.insertExcel(list);
    }

    @Override
    public Student findById(String stuId) {
        return dao.findById(stuId);
    }

    @Override
    public Student login(String stuId, String password) {
        return dao.login(stuId,password);
    }

    @Override
    public void insert(Student student) {
        dao.insert(student);
    }

    @Override
    public void updateByID(Student student) {
        dao.updateByID(student);
    }

    @Override
    public void updateSchoolRoll(Student student) {
        dao.updateSchoolRoll(student);
    }

    @Override
    public List<Student> findByLike(Map<String, Object> map) {
        return dao.findByLike(map);
    }

    @Override
    public byte[] exportStudent(List<Student> list) {
        return StudentExportUtil.write2Excel(list);
    }
}