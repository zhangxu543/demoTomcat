package com.csi.dao;

import com.csi.domain.Nation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:05
 */
@Repository
public interface NationDao {

    @Select("SELECT * FROM nation WHERE id=#{id}")
    Nation findById(int id) ;

    @Select("select * from nation")
    List<Nation> list();
}