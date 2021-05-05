package com.csi.controller;

import com.csi.domain.SchoolRoll;
import com.csi.service.SchoolRollService;
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
@RequestMapping("/schoolRoll")
public class SchoolRollController {
    private static final Logger logger = LoggerFactory.getLogger(SchoolRollController.class);

    @Autowired
    private SchoolRollService service;
    @RequestMapping("/findAll")
    public List<SchoolRoll> findAll(){
        List<SchoolRoll> list = service.list();
        logger.info("学籍状态个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody SchoolRoll schoolRoll){
        Result result = new Result() ;
        service.save(schoolRoll);
        logger.info("新增学籍状态名称======"+schoolRoll);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody SchoolRoll schoolRoll){
        logger.info("删除学籍状态信息======"+schoolRoll);
        Result result = new Result() ;
        service.delete(schoolRoll.getId());
        result.setMessage("删除成功！");
        return result;
    }


}