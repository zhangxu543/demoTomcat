package com.csi.controller;

import com.csi.domain.Subject;
import com.csi.service.SubjectService;
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
@RequestMapping("/subject")
public class SubjectController {
    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @Autowired
    private SubjectService service;
    @RequestMapping("/findAll")
    public List<Subject> findAll(){
        List<Subject> list = service.list();
        logger.info("部门个数======"+list.size());
        return list;
    }

    @RequestMapping("/findByLike")
    public List<Subject> findByLike(@RequestBody Subject subject){
        logger.info("查询条件======"+subject.getName());
        if (subject.getName()==null)
            subject.setName(" ");
        List<Subject> list = service.findByLike(subject.getName());
        logger.info("科目个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody Subject subject){
        Result result = new Result() ;
        service.save(subject);
        logger.info("新增院系名称======"+subject);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody Subject subject){
        logger.info("删除院系信息======");
        Result result = new Result() ;
        service.delete(subject.getId());
        result.setMessage("删除成功！");
        return result;
    }


}