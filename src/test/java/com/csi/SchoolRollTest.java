package com.csi;


import com.csi.dao.SchoolRollDao;
import com.csi.domain.SchoolRoll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class SchoolRollTest {
    @Autowired
    private SchoolRollDao dao;

    @Test
    void save(){
        SchoolRoll schoolRoll=new SchoolRoll(1,"垃圾");
        dao.save(schoolRoll);
    }

    @Test
    void select(){
        for (SchoolRoll m:dao.list()
             ) {
            System.out.println(m);
        }
    }

    @Test
    void delete(){
        dao.delete(3);
    }


}