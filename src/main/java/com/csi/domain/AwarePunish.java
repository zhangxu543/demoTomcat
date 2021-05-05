package com.csi.domain;

/**
 * 奖罚
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 17:37
 */
public class AwarePunish {
    private int id;
    private Student student;
    private String levels;
    private String description;
    private String times;
    private String status;
    private String classroom;
    private Teacher teacher;

    public AwarePunish() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        this.classroom =student.getStuClass();
    }

    public String getClassroom() {
        return classroom;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "AwarePunish{" +
                "id=" + id +
                ", student=" + student +
                ", levels='" + levels + '\'' +
                ", description='" + description + '\'' +
                ", times=" + times +
                ", status=" + status +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}