package com.csi.service;
import com.csi.domain.Politic;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:10
 */


public interface PoliticService {

    Politic findById(int id) ;
    List<Politic> list();
    void save(Politic politic) ;
    void delete(int id);
}