package com.csi.service.impl;

import com.csi.dao.VariationDao;
import com.csi.domain.Variation;
import com.csi.service.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 21:23
 */
@Service
@Transactional
public class VariationServiceImpl implements VariationService {
    @Autowired
    private VariationDao dao;
    @Override
    public void insert(Variation change) {
        dao.insert(change);
    }

    @Override
    public List<Variation> selectByStu(String stuId) {
        return dao.selectByStu(stuId);
    }

    @Override
    public List<Variation> findAll() {
        return dao.findAll();
    }
}