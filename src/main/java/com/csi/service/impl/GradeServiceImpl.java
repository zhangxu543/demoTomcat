package com.csi.service.impl;

import com.csi.dao.GradeDao;
import com.csi.domain.Grade;
import com.csi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 20:25
 */
@Transactional
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao dao;
    @Override
    public void insert(Grade grade) {
        dao.insert(grade);
    }

    @Override
    public void update(Grade grade) {
        dao.update(grade);
    }

    @Override
    public List<Grade> findByLike(Map<String, Object> map) {
        return dao.findByLike(map);
    }
}