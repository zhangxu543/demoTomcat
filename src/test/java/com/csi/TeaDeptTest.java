package com.csi;


import com.csi.dao.TeaDeptDao;
import com.csi.domain.TeaDept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class TeaDeptTest {
    @Autowired
    private TeaDeptDao dao;

    @Test
    void save(){
        TeaDept politic=new TeaDept(1,"计算机部");
        dao.save(politic);
    }

    @Test
    void select(){
        for (TeaDept m:dao.list()
             ) {
            System.out.println(m);
        }
    }

    @Test
    void delete(){
        dao.delete(2);
    }


}