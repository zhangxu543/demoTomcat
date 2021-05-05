package com.csi.service;


import com.csi.domain.Grade;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 19:53
 */

public interface GradeService {
    void insert(Grade grade);
    void update(Grade grade);
    List<Grade> findByLike(Map<String,Object> map);
    byte[] exportGrade(List<Grade> list);
}