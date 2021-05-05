package com.csi.controller;

import com.csi.domain.Student;
import com.csi.domain.Variation;
import com.csi.service.StudentService;
import com.csi.service.VariationService;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/21 21:01
 */
@Controller
@RequestMapping("/variation")
public class VariationController {
    private static final Logger logger = LoggerFactory.getLogger(VariationController.class);
    @Autowired
    private VariationService service;
    @Autowired
    private StudentService studentService;


    @RequestMapping("/updateSchoolRoll")
    @ResponseBody
    public Result insert(@RequestBody Variation variation) {
        Result result = new Result();
        Student student = variation.getStudent();
        logger.info("学籍========" + variation);
        logger.info("学籍变更========" + student.getStuId() + "---------" + student.getSchoolRoll().getId());
        studentService.updateSchoolRoll(student);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=simpleDateFormat.format(new Date());
        System.out.println(date);
        variation.setTime(date);
        service.insert(variation);
        result.setMessage("学籍变得成功。");
        return result;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Variation> findAll(){
        List<Variation> list = service.findAll();
        logger.info("学籍变更个数======"+list.size());
        return list;
    }

}