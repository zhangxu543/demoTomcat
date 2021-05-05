package com.csi.controller;

import com.csi.domain.Teacher;
import com.csi.service.TeacherService;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/16 15:47
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @RequestMapping("/findAll")
    public List<Teacher> findAll(){
        List<Teacher> list = service.findByLike(null);
        logger.info("教师个数======"+list.size());
        return list;
    }

    @RequestMapping("/findByLike")
    public List<Teacher> findByLike(@RequestBody Teacher teacher){
        Map<String,Object> map=new HashMap<>();
        map.put("teaId",teacher.getTeaId());
        map.put("teaName",teacher.getTeaName());
        map.put("tea_dept_id",teacher.getDept().getId());
        map.put("tea_rank_id",teacher.getRank().getId());
        List<Teacher> list = service.findByLike(map);
        logger.info("教师个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody Teacher teacher){
        Result result = new Result() ;
        teacher.setTeaState("否");
        teacher.setTeaPassword("123456");
        service.insert(teacher);
        logger.info("新增教师信息======"+teacher);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable(value = "id") String id){
        Result result = new Result() ;
        service.delete(id);
        result.setMessage("删除成功！");
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Teacher teacher){
        Result result = new Result() ;
        service.updateByID(teacher);
        logger.info("修改后教师信息======"+teacher);
        result.setMessage("修改成功！");
        return result;
    }
}