package com.csi.service.impl;

import com.csi.dao.SchoolRollDao;
import com.csi.domain.SchoolRoll;
import com.csi.service.SchoolRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 20:55
 */
@Service
@Transactional
public class SchoolRollServiceImpl implements SchoolRollService {
    @Autowired
    private SchoolRollDao dao;

    @Override
    public SchoolRoll findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<SchoolRoll> list() {
        return dao.list();
    }

    @Override
    public void save(SchoolRoll schoolRoll) {
        dao.save(schoolRoll);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}