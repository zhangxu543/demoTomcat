package com.csi.controller;

import com.csi.domain.Student;
import com.csi.domain.Teacher;
import com.csi.service.StudentService;
import com.csi.service.TeacherService;
import com.csi.util.MD5Utils;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/16 21:53
 */
@Controller

public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session){
        Result result = new Result() ;
        session.removeAttribute("user");
        result.setCode(200);
        return result;
    }

    @RequestMapping("/login/{id}/{password}/{status}")
    @ResponseBody
    public Result login(HttpSession session, @PathVariable(value = "id")String id, @PathVariable(value = "password") String password, @PathVariable(value = "status") String status){
        password= MD5Utils.stringToMD5(password);
        logger.info("账号==="+id+"==密码==="+password+"===身份===="+status);
        Result result = new Result() ;
        if("3".equals(status)){
            Teacher teacher = teacherService.login(id, password);
            logger.info("登录信息====="+teacher);
            if(teacher==null){
                result.setCode(4);
                result.setMessage("账号密码错误！");
            }else if("是".equals(teacher.getTeaState())){
                result.setCode(3);
                session.setAttribute("user",teacher);
            }else {
                result.setCode(4);
                result.setMessage("账号密码错误！");
            }
        }else if("2".equals(status)){
            Teacher teacher1 =teacherService.login(id,password);
            logger.info("登录信息====="+teacher1);
            if(teacher1!=null){
                result.setCode(2);
                session.setAttribute("user",teacher1);
            }else {
                result.setCode(4);
                result.setMessage("账号密码错误！");
            }
        }else{
            Student student = studentService.login(id, password);
            if(student!=null){
                result.setCode(1);
                session.setAttribute("user",student);
            }else {
                result.setCode(4);
                result.setMessage("账号密码错误！");
            }
        }

        return result;
    }

}