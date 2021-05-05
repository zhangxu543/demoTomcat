package com.csi.service;

import com.csi.domain.TeaRank;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:10
 */


public interface TeaRankService {
    TeaRank findById(int id) ;
    List<TeaRank> list();
    void save(TeaRank teaRank) ;
    void delete(int id);
}