package com.csi.dao;

import com.csi.domain.Student;
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
public interface StudentDao {
    void insertExcel(List<Student> list);
    Student findById(String stuId);
    Student login(@Param("stuId") String stuId,@Param("password") String password);
    void insert(Student student);
    void updateByID(Student student);
    void updateSchoolRoll(Student student);
    List<Student> findByLike(Map<String,Object> map);
}