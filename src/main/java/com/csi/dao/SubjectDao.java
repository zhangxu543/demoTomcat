package com.csi.dao;

import com.csi.domain.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:36
 */
@Repository
public interface SubjectDao {

    @Select("SELECT * FROM Subject WHERE id=#{id}")
    Subject findById(int id) ;

    @Select("SELECT * FROM Subject WHERE name like concat('%',#{name},'%')")
    List<Subject> findByLike(String name) ;

    @Select("SELECT * FROM subject")
    List<Subject> list();

    @Insert("INSERT INTO subject(name,credit) VALUE(#{name},#{credit})")
    void save(Subject subject) ;

    @Delete("delete from subject where id=#{id}")
    void delete(int id);

    @Update("update Subject set name=#{name},credit=#{credit} where id=#{id}")
    void update(Subject major);



}