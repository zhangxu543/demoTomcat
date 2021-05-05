package com.csi.domain;

/**
 * 成绩表
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 17:07
 */
public class Grade {
    private int id;
    private Student student;
    private Subject subject;
    private double grade;
    private String term;
    private Teacher teacher;
    private Major major;
    private String classroom;

    public Grade() {
    }

    public Grade(int id, Student student, Subject subject, double grade, String term, Teacher teacher, Major major, String classroom) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.grade = grade;
        this.term = term;
        this.teacher = teacher;
        this.major = major;
        this.classroom = classroom;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", grade=" + grade +
                ", term='" + term + '\'' +
                ", teacher=" + teacher +
                ", major=" + major +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}