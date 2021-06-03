package com.csi;

import com.csi.dao.CourseDao;
import com.csi.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:38
 */
@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseDao dao;

    @Test
    void test(){
        for (Course c:dao.findByClass("1")
             ) {
            System.out.println(c);
        }
    }
    @Test
    void insert(){
        Course course=new Course();
        course.setId(2);
        dao.insert(course);
    }
    @Test
    void update(){
        Course course=new Course();
        course.setId(2);
        course.setClassRoom("302");
        dao.updateById(course);
    }


}