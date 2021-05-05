package com.csi.service.impl;

import com.csi.dao.TeaRankDao;
import com.csi.domain.TeaRank;
import com.csi.service.TeaRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/31 21:20
 */
@Service
@Transactional
public class TeaRankServiceImpl implements TeaRankService {
    @Autowired
    private TeaRankDao dao;
    @Override
    public TeaRank findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<TeaRank> list() {
        return dao.list();
    }

    @Override
    public void save(TeaRank teaRank) {
        dao.save(teaRank);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}