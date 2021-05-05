package com.csi.dao;

import com.csi.domain.Student0;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student0Dao {

    @Results(
            id="studentResult",value = {
            @Result(id = true,property = "student_no",column = "studentNO"),
            @Result(property = "student_name",column = "studentName"),
            @Result(property = "student_gender",column = "studentGender"),
            @Result(property = "student_borndate",column = "studentBorndate"),
            @Result(property = "grade",column = "gradeId",one=@One(select = "com.csi.dao.GradeDao.findSingleGrade"))
            }
    )

    @Select("SELECT * FROM student")
    List<Student0> list() ;

    @ResultMap("studentResult")
    @Select("SELECT * FROM student WHERE studentNO=#{studentNO}")
    Student0 findById(int studentNO) ;

    @Insert("INSERT INTO student(studentName,studentBorndate,studentGender,gradeId) " +
            "VALUE(#{student_name},#{student_borndate},#{student_gender},#{grade_id})")
    void save(Student0 student) ;

    @Delete("DELETE FROM student WHERE studentNO = #{studentNO}")
    void deleteById(int studentNO) ;

    @Update("UPDATE student SET studentName = #{student_name},studentBorndate = #{student_borndate},studentGender = #{student_gender},gradeId=#{grade_id} WHERE studentNO=#{student_no}")
    void update(Student0 student) ;
}
