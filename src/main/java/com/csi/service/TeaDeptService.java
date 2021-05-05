package com.csi.service;

import com.csi.domain.TeaDept;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:10
 */

public interface TeaDeptService {

    TeaDept findById(int id) ;
    List<TeaDept> list();
    void save(TeaDept teaDept) ;
    void delete(int id);
}