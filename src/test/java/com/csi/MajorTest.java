package com.csi;

import com.csi.dao.MajorDao;
import com.csi.domain.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class MajorTest {
    @Autowired
    private MajorDao dao;

    @Test
    void save(){
        Major major=new Major(1,"软件工程",0);
        dao.save(major);
    }

    @Test
    void select(){
        for (Major m:dao.findByLike(null)
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
        Major major=new Major(5,"计算机科学与技术",1);
        dao.update(major);
    }
    @Test
    void s(){
        System.out.println(dao.findByName("软件工程"));
    }
}