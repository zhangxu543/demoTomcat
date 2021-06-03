package com.csi;

import com.csi.dao.AwarePunishDao;
import com.csi.domain.AwarePunish;
import com.csi.domain.Student;
import com.csi.service.AwarePunishService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/28 13:38
 */
@SpringBootTest
public class AwarePunishTest {

    @Autowired
    private AwarePunishDao dao;

    @Autowired
    private AwarePunishService service;

    @Test
    void test(){
        System.out.println(dao.findById(1));
    }

    @Test
    void test1(){
        System.out.println(service.findById(1));
    }

    @Test
    void insert(){
        AwarePunish awarePunish=new AwarePunish();
        Student student=new Student();
        student.setStuId("11");
        student.setStuClass("1345");
        awarePunish.setStudent(student);

        dao.insert(awarePunish);
    }
    @Test
    void update(){
        AwarePunish awarePunish=new AwarePunish();
        Student student=new Student();
        student.setStuId("11");
        student.setStuClass("1345");
        awarePunish.setStudent(student);
        awarePunish.setDescription("66666666");

        awarePunish.setId(1);
        dao.update(awarePunish);
    }
    @Test
    void selectByLike(){
        Map<String,Object> map=new HashMap<>();
        //map.put("levels","11");
        //map.put("classroom","");
        //map.put("stuId","11");
        System.out.println("============");
       /* for (AwarePunish a:dao.findByLike(map)
             ) {
            System.out.println(a);
        }
*/

    }

}