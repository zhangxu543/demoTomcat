package com.csi.dao;

import com.csi.domain.Grade0;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Grade0Dao {

    @Results(
            id="gradeResult",value = {
            @Result(id = true,property = "grade_id",column = "grade_id"),
            @Result(property = "grade_name",column = "grade_name")
    }
    )
    @Select("SELECT * FROM grade WHERE grade_id=#{gradeId}")
    Grade0 findSingleGrade() ;

    @Select("SELECT * FROM grade")
    List<Grade0> grades();

}
