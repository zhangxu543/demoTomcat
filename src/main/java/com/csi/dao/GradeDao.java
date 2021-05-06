package com.csi.dao;

import com.csi.domain.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 19:53
 */
@Repository
public interface GradeDao {
    Grade findById(int id);
    void insert(Grade grade);
    void update(Grade grade);
    List<Grade> findByLike(Map<String,Object> map);
}