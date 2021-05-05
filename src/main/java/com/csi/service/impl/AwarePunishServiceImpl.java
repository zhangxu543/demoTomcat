package com.csi.service.impl;

import com.csi.dao.AwarePunishDao;
import com.csi.domain.AwarePunish;
import com.csi.service.AwarePunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/30 22:51
 */
@Service
@Transactional
public class AwarePunishServiceImpl implements AwarePunishService {
    @Autowired
    private AwarePunishDao dao;
    @Override
    public void insert(AwarePunish awarePunish) {
        dao.insert(awarePunish);
    }

    @Override
    public void update(AwarePunish awarePunish) {
        dao.update(awarePunish);
    }

    @Override
    public List<AwarePunish> findByLike(AwarePunish awarePunish) {
        return dao.findByLike(awarePunish);
    }

    @Override
    public AwarePunish findById(int id) {
        return dao.findById(id);
    }
}