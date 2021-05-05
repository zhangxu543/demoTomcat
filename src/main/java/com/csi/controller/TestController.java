package com.csi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
    @RequestMapping("/questionBasicList")
    public String firstpage() {
        return "index0";
    }

    @RequestMapping("/students")
    public String students() {
        return "admin/studentList";
    }

    @RequestMapping("/teacherStudents")
    public String teacherStudents() {
        return "teacher/studentList";
    }

    @RequestMapping("/majors")
    public String majors() {
        return "admin/majorList";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/adminIndex")
    public String adminLogin() {
        return "admin/index";
    }

    @RequestMapping("/teacherIndex")
    public String teacherLogin() {
        return "teacher/index";
    }

    @RequestMapping("/studentIndex")
    public String studentLogin() {
        return "student/index";
    }

    @RequestMapping("/depts")
    public String depts() {
        return "admin/deptList";
    }

    @RequestMapping("/schoolRolls")
    public String schoolRolls() {
        return "admin/schoolRollList";
    }

    @RequestMapping("/subjects")
    public String subjects() {
        return "admin/subjectList";
    }

    @RequestMapping("/politics")
    public String politics() {
        return "admin/politicList";
    }

    @RequestMapping("/awarePunishes")
    public String awarePunishes() {
        return "admin/awarePunishList";
    }

    @RequestMapping("/stuAwarePunishes")
    public String stuAwarePunishes() {
        return "student/awarePunishList";
    }

    @RequestMapping("/teachers")
    public String teachers() {
        return "admin/teacherList";
    }

    @RequestMapping("/teaRanks")
    public String teaRanks() {
        return "admin/teaRankList";
    }

    @RequestMapping("/variations")
    public String variations() {
        return "admin/variationList";
    }


    @RequestMapping("/grades")
    public String grades() {
        return "teacher/gradeList";
    }

    @RequestMapping("/stuGrades")
    public String stuGrades() {
        return "student/gradeList";
    }

}
