package com.csi.dao;

import com.csi.domain.City;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:06
 */

@Repository
public interface CityDao {
    @Select("SELECT * FROM city WHERE id=#{Id}")
    City findCityId(int id) ;

    @Select("SELECT * FROM city")
    List<City> cities();

    @Select("SELECT * FROM city where cid=#{id}")
    List<City> citiesByCid(int id);

}