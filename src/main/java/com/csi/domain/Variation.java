package com.csi.domain;

/**
 * 学籍变更
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 17:34
 */
public class Variation {
    private int id;
    private Student student;
    private String time;
    private String description;

    public Variation() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Variation{" +
                "id=" + id +
                ", student=" + student +
                ", time=" + time +
                ", desc='" + description + '\'' +
                '}';
    }
}