package com.csi.service;

import com.csi.domain.Major;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:36
 */

public interface MajorService {
    Major findById(int id) ;
    Major findByName(String name);
    List<Major> list();
    List<Major> listByDept(int dept_id);
    List<Major> findByLike(Major major);
    void save(Major major) ;
    void delete(int id);
    void update(Major major);

}