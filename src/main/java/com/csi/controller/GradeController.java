package com.csi.controller;

import com.csi.domain.Grade;
import com.csi.domain.Student;
import com.csi.domain.Teacher;
import com.csi.service.GradeService;
import com.csi.service.StudentService;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/21 21:01
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
    @Autowired
    private GradeService service;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/findByLike")
    public List<Grade> findByLike(@RequestBody Grade grade) {
        logger.info("筛选条件======" + grade);
        Map<String, Object> map = new HashMap<>();
        map.put("majorId", grade.getMajor().getId());
        map.put("subId", grade.getSubject().getId());

        if (!("".equals(grade.getStudent().getStuId())))
            map.put("stuId", grade.getStudent().getStuId());

        if (!("".equals(grade.getClassroom())))
            map.put("classroom", grade.getClassroom());

        if (!("".equals(grade.getTeacher().getTeaId())))
            map.put("teaId", grade.getTeacher().getTeaId());
        List<Grade> list = service.findByLike(map);
        logger.info("查询出来成绩个数======" + list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(HttpSession session, @RequestBody Grade grade) {
        Result result = new Result();
        Teacher user = (Teacher) session.getAttribute("user");
        logger.info("登录教师信息======" + user);
        grade.setTeacher(user);
        grade.setStudent(studentService.findById(grade.getStudent().getStuId()));
        service.insert(grade);
        logger.info("新增学生成绩信息======" + grade);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/findAll")
    public List<Grade> findAll() {
        List<Grade> list = service.findByLike(null);
        logger.info("查询出来成绩个数======" + list.size());
        return list;
    }

    @RequestMapping("/findByStuId")
    public List<Grade> findByStuId(HttpSession session) {
        Student student =  (Student)session.getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        map.put("stuId", student.getStuId());
        logger.info("筛选条件======" + student.getStuId());
        List<Grade> list = service.findByLike(map);
        logger.info("查询出来成绩个数======" + list.size());
        return list;
    }

}