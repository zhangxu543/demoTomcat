package com.csi.service;

import com.csi.domain.SchoolRoll;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:10
 */

public interface SchoolRollService {
    SchoolRoll findById(int id) ;

    List<SchoolRoll> list();

    void save(SchoolRoll schoolRoll) ;

    void delete(int id);
}