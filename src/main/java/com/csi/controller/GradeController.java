package com.csi.controller;

import com.alibaba.fastjson.JSON;
import com.csi.domain.Grade;
import com.csi.domain.Student;
import com.csi.domain.Subject;
import com.csi.domain.Teacher;
import com.csi.service.GradeService;
import com.csi.service.StudentService;
import com.csi.util.PoiUpload;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
    @Autowired
    private PoiUpload poiUpload;

    @RequestMapping("/updateGrade/{id}/{score}")
    public Result updateGrade(@PathVariable("id") int id ,@PathVariable("score") double score) {
        Result result = new Result();
        Grade grade = service.findById(id);
        grade.setGrade(score);
        service.update(grade);
        result.setCode(200);
        result.setMessage("修改成功！");
        return result;
    }

    @RequestMapping("/insertExcel")
    public String insertExcel(HttpServletRequest request, @RequestParam() MultipartFile file) throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        InputStream inputStream =null;
        List<List<Object>> list = null;
        //MultipartFile file = multipartRequest.getFile("filename");
        if(file.isEmpty()){
            return "文件不能为空";
        }
        inputStream = file.getInputStream();
        list =poiUpload.getBankListByExcel(inputStream,file.getOriginalFilename());
        inputStream.close();
        //连接数据库部分
        try {
            List<Grade> list1=new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                List<Object> lo = list.get(i);
                Grade grade=new Grade();
                Student student = studentService.findById(String.valueOf(lo.get(0)));
                grade.setStudent(student);
                Subject subject=new Subject();
                String subId=String.valueOf(lo.get(2));
                double aa=Double.parseDouble(subId);
                subject.setId((int)aa);
                grade.setSubject(subject);
                Double grade0=Double.valueOf(String.valueOf(lo.get(4)));
                grade.setGrade(grade0);
                grade.setTerm(String.valueOf(lo.get(5)));
                Teacher teacher=new Teacher();
                teacher.setTeaId(String.valueOf(lo.get(6)));
                grade.setTeacher(teacher);
                list1.add(grade);
            }
            logger.info("学生个数==========="+list1.size());
            service.insertExcel(list1);
        }catch(Exception e){
            return "上传失败";
        }
        return "上传成功";
    }

    @RequestMapping("/exportGrades/{grade}")
    @ResponseBody
    public void exportStudent(@PathVariable(value = "grade") String stu, HttpServletRequest request,
                              HttpServletResponse response){
        Grade grade = JSON.parseObject(stu, Grade.class);
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
        try {
            //调用业务,获取所有的用户信息
            byte[] excelData=service.exportGrade(list);
            //把excle的字节数组中的数据以文件的方式下载到客户端
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=studentsGrade.xls");
            response.setContentLength(excelData.length);
            OutputStream os=response.getOutputStream();
            os.write(excelData);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("/findByLike")
    public List<Grade> findByLike(@RequestBody Grade grade) {
        logger.info("筛选条件======" + grade);
        Map<String, Object> map = new HashMap<>();
        map.put("majorId", grade.getMajor().getId());
        map.put("subId", grade.getSubject().getId());


        if(!("".equals(grade.getTerm())))
            map.put("term",grade.getTerm());
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