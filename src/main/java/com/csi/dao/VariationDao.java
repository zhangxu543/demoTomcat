package com.csi.dao;

import com.csi.domain.Variation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 17:23
 */
@Repository
public interface VariationDao {
    @Insert("insert into Variation(stu_id,times,description) value(#{student.stuId},#{time},#{description})")
    void insert(Variation change);
    List<Variation> selectByStu(@Param("stuId") String stuId);
    List<Variation> findAll();
}