package com.csi.dao;

import com.csi.domain.TeaRank;
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
public interface TeaRankDao {
    @Select("SELECT * FROM tea_rank WHERE id=#{id}")
    TeaRank findById(int id) ;

    @Select("SELECT * FROM tea_rank")
    List<TeaRank> list();

    @Insert("INSERT INTO tea_rank(name) VALUE(#{name})")
    void save(TeaRank teaRank) ;

    @Delete("delete from tea_rank where id=#{id}")
    void delete(int id);
}