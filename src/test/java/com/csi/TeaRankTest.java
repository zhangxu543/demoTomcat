package com.csi;

import com.csi.dao.TeaRankDao;
import com.csi.domain.TeaRank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:41
 */
@SpringBootTest
public class TeaRankTest {
    @Autowired
    private TeaRankDao dao;

    @Test
    void save(){
        TeaRank teaRank=new TeaRank(1,"垃圾");
        dao.save(teaRank);
    }

    @Test
    void select(){
        for (TeaRank m:dao.list()
             ) {
            System.out.println(m);
        }
    }

    @Test
    void delete(){
        dao.delete(3);
    }


}