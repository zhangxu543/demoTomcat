package com.csi.service.impl;

import com.csi.dao.MajorDao;
import com.csi.domain.Major;
import com.csi.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/11 22:55
 */
@Service
@Transactional
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao dao;
    @Override
    public Major findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Major findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Major> list() {
        return dao.list();
    }

    @Override
    public List<Major> listByDept(int dept_id) {
        return dao.listByDept(dept_id);
    }

    @Override
    public List<Major> findByLike(Major major) {
        return dao.findByLike(major);
    }

    @Override
    public void save(Major major) {
        dao.save(major);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Major major) {
        dao.update(major);
    }
}