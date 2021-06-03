package com.csi;

import com.csi.dao.VariationDao;
import com.csi.domain.Student;
import com.csi.domain.Variation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VariationTest {

    @Autowired
    private VariationDao dao;

    @Test
    void insert() {
        Variation change=new Variation();
        Student student=new Student();
        student.setStuId("1777782");
        change.setStudent(student);
        dao.insert(change);

    }

    @Test
    void select() {
        for (Variation v:dao.selectByStu("11")
             ) {
            System.out.println(v);
        }

    }


}
