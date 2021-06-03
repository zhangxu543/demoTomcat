package com.csi;

import com.csi.dao.TeacherDao;
import com.csi.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:38
 */
@SpringBootTest
public class TeacherTest {

    @Autowired
    private TeacherDao dao;

    @Test
    void test(){
        Teacher student = dao.findById("1");
        System.out.println(student);
    }
    @Test
    void insert(){
        Teacher teacher=new Teacher();
        teacher.setTeaId("123456");
        dao.insert(teacher);
    }
    @Test
    void update(){
        Teacher teacher=new Teacher();
        teacher.setTeaId("123456");
        teacher.setTeaName("张旭");
        dao.updateByID(teacher);
    }


}