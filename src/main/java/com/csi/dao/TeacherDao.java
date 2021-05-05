package com.csi.dao;

import com.csi.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:25
 */
@Repository
public interface TeacherDao {
    List<Teacher> findByLike(Map<String,Object> map);
    Teacher findById(String teaId);
    Teacher login(@Param("teaId") String teaId,@Param("password") String password);
    void insert(Teacher teacher);
    void updateByID(Teacher student);

    @Delete("delete from teacher where tea_id=#{teaId}")
    void delete(String teaId);
}