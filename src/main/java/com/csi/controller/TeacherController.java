package com.csi.controller;

import com.csi.domain.Student;
import com.csi.domain.Teacher;
import com.csi.service.TeacherService;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/16 15:47
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @RequestMapping("/updatePass/{teaId}/{oldPass}/{pass}")
    @ResponseBody
    public Result updatePass(HttpSession session,@PathVariable("teaId") String teaId,
                             @PathVariable("oldPass") String oldPass,
                             @PathVariable("pass") String pass){
        Teacher teacher = service.login(teaId, oldPass);
        Result result = new Result() ;
        if(teacher!=null){
            teacher.setTeaPassword(pass);
            service.updateByID(teacher);
            result.setMessage("修改成功！");
            result.setCode(200);
        }else{
            result.setMessage("原密码不对！");
            result.setCode(400);
        }

        return result;
    }

    @RequestMapping("/findById")
    public String findById1(HttpSession session, Model model) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        model.addAttribute("teacherInfo", service.findById(teacher.getTeaId()));
        if(teacher!=null)
           return "teacher/teacherInfo";
        else
            return "index";
    }

    @RequestMapping("findById0/{id}")
    @ResponseBody
    public Teacher findById0(@PathVariable(value = "id") String id) {
        logger.info("教师id======"+id);
        Teacher teacher = service.findById(id);
        logger.info("单个教师信息======"+teacher);
        return teacher;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Teacher> findAll(){
        List<Teacher> list = service.findByLike(null);
        logger.info("教师个数======"+list.size());
        return list;
    }

    @RequestMapping("/findByLike")
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
    public Result delete(@PathVariable(value = "id") String id){
        Result result = new Result() ;
        service.delete(id);
        result.setMessage("删除成功！");
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Teacher teacher){
        logger.info("修改后教师信息======"+teacher);
        Result result = new Result() ;
        service.updateByID(teacher);
        logger.info("修改后教师信息======"+teacher);
        result.setMessage("修改成功！");
        return result;
    }
}