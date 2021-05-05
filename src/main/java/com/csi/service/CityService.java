package com.csi.service;

import com.csi.domain.City;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:06
 */

public interface CityService {
    City findCityId(int id) ;
    List<City> cities();
    List<City> citiesByCid(int id);

}