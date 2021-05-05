package com.csi.domain;

import java.io.Serializable;
import java.util.Date;

public class Student0 implements Serializable {

    private Integer student_no ;

    private String student_name ;

    private Date student_borndate ;

    private int student_gender;

    private int grade_id;


    private Grade0 grade ;

    public Student0() {
    }
    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public Integer getStudent_no() {
        return student_no;
    }

    public void setStudent_no(Integer student_no) {
        this.student_no = student_no;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Date getStudent_borndate() {
        return student_borndate;
    }

    public void setStudent_borndate(Date student_borndate) {
        this.student_borndate = student_borndate;
    }

    public int getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(int student_gender) {
        this.student_gender = student_gender;
    }

    public Grade0 getGrade() {
        return grade;
    }

    public void setGrade(Grade0 grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_no=" + student_no +
                ", student_name='" + student_name + '\'' +
                ", student_borndate=" + student_borndate +
                ", student_gender=" + student_gender +
                ", grade=" + grade +
                '}';
    }
}
