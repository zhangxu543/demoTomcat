package com.csi.controller;


import com.alibaba.fastjson.JSON;
import com.csi.domain.*;
import com.csi.service.MajorService;
import com.csi.service.StudentService;
import com.csi.util.MD5Utils;
import com.csi.util.PoiUpload;
import com.csi.util.Result;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.codec.digest.Md5Crypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
    public String insertExcel(@RequestParam("file") MultipartFile file) throws Exception {

        //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream inputStream = null;
        List<List<Object>> list = null;
        //MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        inputStream = file.getInputStream();
        list = poiUpload.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        //连接数据库部分
        try {
            List<Student> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                List<Object> lo = list.get(i);
                Student student = new Student();
                student.setStuId(String.valueOf(lo.get(0)));
                student.setStuName(String.valueOf(lo.get(1)));
                student.setStuClass(String.valueOf(lo.get(2)));
                student.setStuSex(String.valueOf(lo.get(3)));
                student.setStuDorm(String.valueOf(lo.get(5)));
                Major major = majorService.findByName(String.valueOf(lo.get(4)));
                if (major == null)
                    return "文件专业名称不对";
                student.setMajor(major);
                student.setStuPassword(MD5Utils.stringToMD5("123456"));
                Nation nation = new Nation();
                nation.setId(1);
                student.setNation(nation);
                Politic politic = new Politic();
                politic.setId(1);
                student.setPolitic(politic);
                SchoolRoll schoolRoll = new SchoolRoll();
                schoolRoll.setId(1);
                student.setSchoolRoll(schoolRoll);
                list1.add(student);
            }
            studentService.insertExcel(list1);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


    @RequestMapping("/list")
    @ResponseBody
    public List<Student> list() {
        List<Student> list = studentService.findByLike(null);
        logger.info("学生个数======" + list.size());
        return list;
    }

    @RequestMapping("/findByLike")
    @ResponseBody
    public List<Student> findByLike(@RequestBody Student student) {
        if ("".equalsIgnoreCase(student.getStuClass())) {
            student.setStuClass(null);
        }
        if ("".equalsIgnoreCase(student.getStuId())) {
            student.setStuId(null);
        }
        if ("".equalsIgnoreCase(student.getStuName())) {
            student.setStuName(null);
        }
        if ("".equalsIgnoreCase(student.getStuSex())) {
            student.setStuSex(null);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("stuId", student.getStuId());
        map.put("stuName", student.getStuName());
        map.put("stuSex", student.getStuSex());
        map.put("stuClass", student.getStuClass());
        List<Student> list = studentService.findByLike(map);
        logger.info("学生个数======" + list.size());
        return list;
    }

    @RequestMapping("/exportStudent/{student}")
    @ResponseBody
    public void exportStudent(@PathVariable(value = "student") String stu, HttpServletRequest request,
                              HttpServletResponse response) {
        Student student = JSON.parseObject(stu, Student.class);
        if ("".equalsIgnoreCase(student.getStuClass())) {
            student.setStuClass(null);
        }
        if ("".equalsIgnoreCase(student.getStuId())) {
            student.setStuId(null);
        }
        if ("".equalsIgnoreCase(student.getStuName())) {
            student.setStuName(null);
        }
        if ("".equalsIgnoreCase(student.getStuSex())) {
            student.setStuSex(null);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("stuId", student.getStuId());
        map.put("stuName", student.getStuName());
        map.put("stuSex", student.getStuSex());
        map.put("stuClass", student.getStuClass());
        List<Student> list = studentService.findByLike(map);
        logger.info("学生个数======" + list.size());
        try {
            //调用业务,获取所有的用户信息
            byte[] excelData = studentService.exportStudent(list);
            //把excle的字节数组中的数据以文件的方式下载到客户端
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=studentsInfo.xls");
            response.setContentLength(excelData.length);
            OutputStream os = response.getOutputStream();
            os.write(excelData);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody Student student) {
        Result result = new Result();
        Student student1 = studentService.findById(student.getStuId());
        if (student1 == null) {
            student.setStuPassword(MD5Utils.stringToMD5("123456"));
            Nation nation = new Nation();
            nation.setId(1);
            student.setNation(nation);
            Politic politic = new Politic();
            politic.setId(1);
            student.setPolitic(politic);
            SchoolRoll schoolRoll = new SchoolRoll();
            schoolRoll.setId(1);
            student.setSchoolRoll(schoolRoll);
            studentService.insert(student);
            result.setCode(200);
            result.setMessage("添加成功！");
        }else {
            result.setMessage("该学号已经存在，添加失败！");
        }
        return result;
    }

    @RequestMapping("/updatePass/{stuId}/{oldPass}/{pass}")
    @ResponseBody
    public Result updatePass(HttpSession session, @PathVariable("stuId") String stuId,
                             @PathVariable("oldPass") String oldPass,
                             @PathVariable("pass") String pass) {
        oldPass = MD5Utils.stringToMD5(oldPass);
        pass = MD5Utils.stringToMD5(pass);
        Student student = studentService.login(stuId, oldPass);
        Result result = new Result();
        if (student != null) {
            student.setStuPassword(pass);
            studentService.updateByID(student);
            result.setMessage("修改成功！");
            result.setCode(200);
        } else {
            result.setMessage("原密码不对！");
            result.setCode(400);
        }

        return result;
    }

    @RequestMapping("findById/{id}")
    public ModelAndView findById(@PathVariable(value = "id") String id) {
        logger.info("学生id======" + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/studentInfo");
        modelAndView.addObject("studentInfo", studentService.findById(id));
        return modelAndView;
    }

    @RequestMapping("findById0/{id}")
    @ResponseBody
    public Student findById0(@PathVariable(value = "id") String id) {
        logger.info("学生id======" + id);
        Student student = studentService.findById(id);
        logger.info("单个学生信息======" + student);
        return student;
    }

    @RequestMapping("/findById1")
    public String findById1(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("user");
        model.addAttribute("studentInfo", studentService.findById(student.getStuId()));
        return "student/studentInfo";
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public Result updateStudent(@RequestBody Student student) {
        Result result = new Result();
        logger.info("修改后学生信息======" + student);
        studentService.updateByID(student);
        result.setMessage("修改成功！");
        return result;
    }

}

