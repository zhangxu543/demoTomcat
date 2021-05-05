package com.csi.dao;

import com.csi.domain.TeaDept;
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
public interface TeaDeptDao {

    @Select("SELECT * FROM tea_dept WHERE id=#{id}")
    TeaDept findById(int id) ;

    @Select("SELECT * FROM tea_dept")
    List<TeaDept> list();

    @Insert("INSERT INTO tea_dept(name) VALUE(#{name})")
    void save(TeaDept teaDept) ;

    @Delete("delete from tea_dept where id=#{id}")
    void delete(int id);
}