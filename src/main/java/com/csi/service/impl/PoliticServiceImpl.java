package com.csi.service.impl;

import com.csi.dao.PoliticDao;
import com.csi.domain.Politic;
import com.csi.service.PoliticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 20:52
 */
@Service
@Transactional
public class PoliticServiceImpl implements PoliticService {
    @Autowired
    private PoliticDao dao;

    @Override
    public Politic findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Politic> list() {
        return dao.list();
    }

    @Override
    public void save(Politic politic) {
        dao.save(politic);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}