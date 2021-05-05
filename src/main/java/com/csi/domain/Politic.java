package com.csi.domain;

/**
 * 政治面貌
 * @author 張旭
 * @version 1.0
 * @date 2021/3/24 17:25
 */
public class Politic {
    private Integer id;
    private String name;

    public Politic() {
    }

    public Politic(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Politic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
