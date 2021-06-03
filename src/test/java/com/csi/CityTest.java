package com.csi;

import com.csi.dao.CityDao;
import com.csi.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CityTest {

    @Autowired
    private CityDao cityDao;

    @Test
    void select() {
        List<City> cities = cityDao.citiesByCid(110100);
        System.out.println(cities.size());
        for (City c:cities) {
            System.out.println(c);
        }

    }


}
