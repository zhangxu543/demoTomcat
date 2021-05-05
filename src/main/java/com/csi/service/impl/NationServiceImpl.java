package com.csi.service.impl;

import com.csi.dao.NationDao;
import com.csi.domain.Nation;
import com.csi.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 20:32
 */
@Service
@Transactional
public class NationServiceImpl implements NationService {

    @Autowired
    private NationDao dao;
    @Override
    public Nation findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Nation> list() {
        return dao.list();
    }
}