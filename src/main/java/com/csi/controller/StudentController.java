package com.csi.controller;


import com.csi.domain.*;
import com.csi.service.MajorService;
import com.csi.service.StudentService;
import com.csi.util.PoiUpload;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;

    @Autowired
    private PoiUpload poiUpload;

    @RequestMapping("/insertExcel")
    @ResponseBody
    public String insertExcel(HttpServletRequest request) throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream inputStream =null;
        List<List<Object>> list = null;
        MultipartFile file = multipartRequest.getFile("filename");
        if(file.isEmpty()){
            return "文件不能为空";
        }
        inputStream = file.getInputStream();
        list =poiUpload.getBankListByExcel(inputStream,file.getOriginalFilename());
        inputStream.close();
        //连接数据库部分
        try {
            for (int i = 0; i < list.size(); i++) {
                List<Object> lo = list.get(i);
                Student student=new Student();
                student.setStuId(String.valueOf(lo.get(0)));
                student.setStuName(String.valueOf(lo.get(1)));
                student.setStuClass(String.valueOf(lo.get(2)));
                student.setStuSex(String.valueOf(lo.get(3)));
                student.setStuDorm(String.valueOf(lo.get(5)));
                Major major = majorService.findByName(String.valueOf(lo.get(4)));
                student.setMajor(major);
                student.setStuPassword("123456");
                Nation nation=new Nation();
                nation.setId(1);
                student.setNation(nation);
                Politic politic=new Politic();
                politic.setId(1);
                student.setPolitic(politic);
                SchoolRoll schoolRoll=new SchoolRoll();
                schoolRoll.setId(1);
                student.setSchoolRoll(schoolRoll);
                studentService.insert(student);
            }
        }catch(Exception e){
            return "上传失败";
        }
        return "上传成功";
    }




    @RequestMapping("/list")
    @ResponseBody
    public List<Student> list(){
        List<Student> list = studentService.findByLike(null);
        logger.info("学生个数======"+list.size());
        return list;
    }

    @RequestMapping("/findByLike")
    @ResponseBody
    public List<Student> findByLike(@RequestBody Student student){
        if("".equalsIgnoreCase(student.getStuClass())){
            student.setStuClass(null);
        }if("".equalsIgnoreCase(student.getStuId())){
            student.setStuId(null);
        }if("".equalsIgnoreCase(student.getStuName())){
            student.setStuName(null);
        }if("".equalsIgnoreCase(student.getStuSex())){
            student.setStuSex(null);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("stuId",student.getStuId());
        map.put("stuName",student.getStuName());
        map.put("stuSex",student.getStuSex());
        map.put("stuClass",student.getStuClass());
        List<Student> list = studentService.findByLike(map);
        logger.info("学生个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody Student student){
        Result result = new Result() ;
        student.setStuPassword("123456");
        Nation nation=new Nation();
        nation.setId(1);
        student.setNation(nation);
        Politic politic=new Politic();
        politic.setId(1);
        student.setPolitic(politic);
        SchoolRoll schoolRoll=new SchoolRoll();
        schoolRoll.setId(1);
        student.setSchoolRoll(schoolRoll);
        studentService.insert(student);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("findById/{id}")
    public ModelAndView findById(@PathVariable(value = "id") String id) {
        logger.info("学生id======"+id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/studentInfo");
        modelAndView.addObject("studentInfo", studentService.findById(id));
        return modelAndView;
    }

    @RequestMapping("findById0/{id}")
    @ResponseBody
    public Student findById0(@PathVariable(value = "id") String id) {
        logger.info("学生id======"+id);
        Student student = studentService.findById(id);
        logger.info("单个学生信息======"+student);
        return student;
    }

    @RequestMapping("/findById1")
    public String findById1(HttpSession session,Model model) {
        Student student =  (Student)session.getAttribute("user");
        model.addAttribute("studentInfo", studentService.findById(student.getStuId()));
        return "student/studentInfo";
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public Result updateStudent(@RequestBody Student student){
        Result result = new Result() ;
        logger.info("修改后学生信息======"+student);
        studentService.updateByID(student);
        result.setMessage("修改成功！");
        return result;
    }

}

