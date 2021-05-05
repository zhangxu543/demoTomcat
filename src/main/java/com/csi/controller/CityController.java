package com.csi.controller;

import com.csi.domain.City;
import com.csi.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/11 13:36
 */
@RestController
@RequestMapping("/city")
public class CityController {
    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService service;

    @RequestMapping("/findSheng")
    public List<City> findSheng(){
        List<City> cities = service.citiesByCid(0);
        logger.info("省市个数======"+cities.size());
        return cities;
    }

    @RequestMapping("findByCid/{cid}")
    public List<City> findAll(@PathVariable("cid") int id){
        List<City> cities = service.citiesByCid(id);
        logger.info("个数======"+cities.size());
        return cities;
    }

    @RequestMapping("/findById/{id}")
    public City findById( @PathVariable("id") int id){
        City city = service.findCityId(id);
        logger.info("城市信息======"+city);
        return city;
    }


}