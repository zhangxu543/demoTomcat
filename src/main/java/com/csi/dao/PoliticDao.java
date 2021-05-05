package com.csi.dao;

import com.csi.domain.Politic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 19:10
 */

@Repository
public interface PoliticDao {

    @Select("SELECT * FROM Politic WHERE id=#{id}")
    Politic findById(int id) ;

    @Select("SELECT * FROM Politic")
    List<Politic> list();

    @Insert("INSERT INTO Politic(name) VALUE(#{name})")
    void save(Politic politic) ;

    @Delete("delete from Politic where id=#{id}")
    void delete(int id);
}