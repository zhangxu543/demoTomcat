package com.csi.service;

import com.csi.domain.Nation;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:05
 */

public interface NationService {
    Nation findById(int id) ;
    List<Nation> list();
}