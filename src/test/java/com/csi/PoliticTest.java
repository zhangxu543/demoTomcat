package com.csi;


import com.csi.dao.PoliticDao;
import com.csi.domain.Politic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class PoliticTest {
    @Autowired
    private PoliticDao dao;

    @Test
    void save(){
        Politic politic=new Politic(1,"群众");
        dao.save(politic);
    }

    @Test
    void select(){
        for (Politic m:dao.list()
             ) {
            System.out.println(m);
        }
    }

    @Test
    void delete(){
        dao.delete(2);
    }


}