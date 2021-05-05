package com.csi.domain;

/**
 * 学生学籍状态
 * @author 張旭
 * @version 1.0
 * @date 2021/3/24 17:25
 */
public class SchoolRoll {
    private Integer id;
    private String name;

    public SchoolRoll() {
    }

    public SchoolRoll(Integer id, String name) {
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
        return "SchoolRoll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
