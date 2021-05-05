package com.csi.domain;

/**
 * 城市
 * @author 張旭
 * @version 1.0
 * @date 2021/3/24 17:25
 */
public class Subject {
    private Integer id;
    private String name;
    private double credit;

    public Subject() {
    }

    public Subject(Integer id, String name, double credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
