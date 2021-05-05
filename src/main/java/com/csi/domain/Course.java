package com.csi.domain;

/**
 * 课程
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 17:14
 */
public class Course {
    private int id;
    private int weekDay;
    private int several;
    private Subject subject;
    private Teacher teacher;
    private String classRoom;
    private String description;

    public Course() {
    }

    public Course(int id, int weekDay, int several, Subject subject, Teacher teacher, String classRoom, String description) {
        this.id = id;
        this.weekDay = weekDay;
        this.several = several;
        this.subject = subject;
        this.teacher = teacher;
        this.classRoom = classRoom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getSeveral() {
        return several;
    }

    public void setSeveral(int several) {
        this.several = several;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", weekDay=" + weekDay +
                ", several=" + several +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", classRoom=" + classRoom +
                ", desc='" + description + '\'' +
                '}';
    }
}