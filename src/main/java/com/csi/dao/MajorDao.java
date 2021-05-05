package com.csi.dao;

import com.csi.domain.Major;
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
public interface MajorDao {

    Major findById(int id) ;

    @Select("SELECT * FROM major WHERE name=#{name}")
    Major findByName(String name);

    List<Major> list();

    List<Major> findByLike(Major major);

    @Select("SELECT * FROM major where dept_id=#{dept_id}")
    List<Major> listByDept(int dept_id);

    @Insert("INSERT INTO major(name,dept_id) VALUE(#{name},#{dept_id})")
    void save(Major major) ;

    @Delete("delete from major where id=#{id}")
    void delete(int id);

    @Update("update major set name=#{name},dept_id=#{dept_id} where id=#{id}")
    void update(Major major);



}