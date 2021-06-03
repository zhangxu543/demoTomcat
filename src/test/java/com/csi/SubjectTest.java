package com.csi;


import com.csi.dao.SubjectDao;
import com.csi.domain.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class SubjectTest {
    @Autowired
    private SubjectDao dao;

    @Test
    void save(){
        Subject major=new Subject(1,"java程序数设计",3);
        dao.save(major);
    }

    @Test
    void select(){
        for (Subject m:dao.list()
             ) {
            System.out.println(m);
        }
    }

    @Test
    void delete(){
        dao.delete(4);
    }

    @Test
    void update(){
        Subject major=new Subject(3 ,"计算机组成",1.5);
        dao.update(major);
    }
}