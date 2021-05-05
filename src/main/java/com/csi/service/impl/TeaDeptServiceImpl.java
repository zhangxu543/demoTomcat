package com.csi.service.impl;

import com.csi.dao.TeaDeptDao;
import com.csi.domain.TeaDept;
import com.csi.service.TeaDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 21:17
 */
@Service
@Transactional
public class TeaDeptServiceImpl implements TeaDeptService {
    @Autowired
    private TeaDeptDao dao;
    @Override
    public TeaDept findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<TeaDept> list() {
        return dao.list();
    }

    @Override
    public void save(TeaDept teaDept) {
        dao.save(teaDept);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}