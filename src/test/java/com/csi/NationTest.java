package com.csi;


import com.csi.dao.NationDao;
import com.csi.domain.Nation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class NationTest {
    @Autowired
    private NationDao dao;


    @Test
    void select(){
        for (Nation m:dao.list()
             ) {
            System.out.println(m);
        }
    }


}