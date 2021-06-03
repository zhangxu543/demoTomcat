package com.csi;

import com.csi.dao.StudentDao;
import com.csi.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:38
 */
@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentDao dao;

    @Test
    void test(){
        Student student = dao.findById("11");
        System.out.println(student);
    }
    @Test
    void insert(){
        Student student=new Student();
        student.setStuId("177777");
        dao.insert(student);
    }
    @Test
    void update(){
        Student student=new Student();
        student.setStuId("177777");
        student.setStuName("张旭");
        dao.updateByID(student);
    }
    @Test
    void selectByLike(){
        Map<String,Object> map=new HashMap<>();
        map.put("stuName","张旭");
        List<Student> students = dao.findByLike(map);
        for (Student s:students
             ) {
            System.out.println(s);
        }
    }

}