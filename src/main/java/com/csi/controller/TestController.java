package com.csi.controller;


import com.csi.domain.Student;
import com.csi.domain.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class TestController {
    @RequestMapping("/questionBasicList")
    public String firstpage() {
        return "index0";
    }

    @RequestMapping("/students")
    public String students(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
              return "admin/studentList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/teacherStudents")
    public String teacherStudents(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            return "teacher/studentList";
        else
            return "index";

    }

    @RequestMapping("/majors")
    public String majors(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/majorList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/adminIndex")
    public String adminLogin(HttpSession session,Model model) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        model.addAttribute("teacherInfo",teacher);
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/index";
            else
                return "index";
        else
            return "index";
    }

    @RequestMapping("/teacherIndex")
    public String teacherLogin(HttpSession session,Model model) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        model.addAttribute("teacherInfo",teacher);

        if(teacher!=null)
            return "teacher/index";
        else
            return "index";

    }

    @RequestMapping("/studentIndex")
    public String studentLogin(HttpSession session, Model model) {
        Student student =  (Student) session.getAttribute("user");
        model.addAttribute("studentInfo",student);
        if(student!=null)
            return "student/index";
        else
            return "index";

    }

    @RequestMapping("/depts")
    public String depts(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/deptList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/schoolRolls")
    public String schoolRolls(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/schoolRollList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/subjects")
    public String subjects(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/subjectList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/politics")
    public String politics(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/politicList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/awarePunishes")
    public String awarePunishes(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            return "admin/awarePunishList";
        else
            return "index";

    }

    @RequestMapping("/stuAwarePunishes")
    public String stuAwarePunishes(HttpSession session) {
        Student student =  (Student) session.getAttribute("user");
        if(student!=null)
            return "student/awarePunishList";
        else
            return "index";

    }

    @RequestMapping("/teachers")
    public String teachers(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/teacherList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/teaRanks")
    public String teaRanks(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/teaRankList";
            else
                return "index";
        else
            return "index";

    }

    @RequestMapping("/variations")
    public String variations(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            if ("是".equals(teacher.getTeaState()))
                return "admin/variationList";
            else
                return "index";
        else
            return "index";

    }


    @RequestMapping("/grades")
    public String grades(HttpSession session) {
        Teacher teacher =  (Teacher) session.getAttribute("user");
        if(teacher!=null)
            return "teacher/gradeList";
        else
            return "index";
    }

    @RequestMapping("/stuGrades")
    public String stuGrades(HttpSession session) {
        Student student =  (Student) session.getAttribute("user");
        if(student!=null)
            return "student/gradeList";
        else
            return "index";

    }

}
