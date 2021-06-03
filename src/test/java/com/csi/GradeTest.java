package com.csi;

import com.csi.dao.GradeDao;
import com.csi.domain.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:38
 */
@SpringBootTest
public class GradeTest {

    @Autowired
    private GradeDao dao;

    @Test
    void test(){
        for (Grade g:dao.findByLike(null)
             ) {
            System.out.println(g);
        }
    }
    @Test
    void insert(){
        Grade grade=new Grade();
        grade.setId(1);
        grade.setTerm("2017");
        dao.insert(grade);
    }
    @Test
    void update(){
        Grade grade=new Grade();
        grade.setId(1);
        grade.setClassroom("软件C17");
        grade.setTerm("2017");
        dao.update(grade);
    }


}