package com.csi.service.impl;

import com.csi.dao.CityDao;
import com.csi.domain.City;
import com.csi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/30 23:01
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao dao;
    @Override
    public City findCityId(int id) {
        return dao.findCityId(id);
    }

    @Override
    public List<City> cities() {
        return dao.cities();
    }

    @Override
    public List<City> citiesByCid(int id) {
        return dao.citiesByCid(id);
    }
}