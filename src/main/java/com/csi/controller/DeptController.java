package com.csi.controller;

import com.csi.domain.TeaDept;
import com.csi.service.TeaDeptService;
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
@RequestMapping("/teaDept")
public class DeptController {
    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private TeaDeptService deptService;
    @RequestMapping("/findAll")
    public List<TeaDept> findAll(){
        List<TeaDept> list = deptService.list();
        logger.info("部门个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody TeaDept teaDept){
        Result result = new Result() ;
        deptService.save(teaDept);
        logger.info("新增院系名称======"+teaDept);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody TeaDept teaDept){
        logger.info("删除院系信息======");
        Result result = new Result() ;
        deptService.delete(teaDept.getId());
        result.setMessage("删除成功！");
        return result;
    }


}