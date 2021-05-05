package com.csi.service.impl;

import com.csi.dao.SubjectDao;
import com.csi.domain.Subject;
import com.csi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 21:08
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao dao;

    @Override
    public  List<Subject> findByLike(String name) {
        return dao.findByLike(name);
    }

    @Override
    public Subject findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Subject> list() {
        return dao.list();
    }

    @Override
    public void save(Subject subject) {
        dao.save(subject);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Subject subject) {
        dao.update(subject);
    }
}