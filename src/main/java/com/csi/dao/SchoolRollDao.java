package com.csi.dao;

import com.csi.domain.SchoolRoll;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:10
 */

@Repository
public interface SchoolRollDao {

    @Select("SELECT * FROM school_roll WHERE id=#{id}")
    SchoolRoll findById(int id) ;

    @Select("SELECT * FROM school_roll")
    List<SchoolRoll> list();

    @Insert("INSERT INTO school_roll(name) VALUE(#{name})")
    void save(SchoolRoll schoolRoll) ;

    @Delete("delete from school_roll where id=#{id}")
    void delete(int id);
}