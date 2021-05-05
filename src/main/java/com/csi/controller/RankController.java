package com.csi.controller;

import com.csi.domain.TeaRank;
import com.csi.service.TeaRankService;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/13 20:10
 */
@RestController
@RequestMapping("/teaRank")
public class RankController {
    private static final Logger logger = LoggerFactory.getLogger(RankController.class);

    @Autowired
    private TeaRankService service;
    @RequestMapping("/findAll")
    public List<TeaRank> findAll(){
        List<TeaRank> list = service.list();
        logger.info("部门个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody TeaRank teaRank){
        Result result = new Result() ;
        service.save(teaRank);
        logger.info("新增院系名称======"+teaRank);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody TeaRank teaRank){
        logger.info("删除院系信息======");
        Result result = new Result() ;
        service.delete(teaRank.getId());
        result.setMessage("删除成功！");
        return result;
    }


}