package com.csi.domain;

/**
 * 专业
 * @author 張旭
 * @version 1.0
 * @date 2021/3/24 17:25
 */
public class Major {
    private Integer id;
    private String name;
    private Integer dept_id;
    private String dept_name;

    public Major() {
    }

    public Major(Integer id, String name, Integer dept_id) {
        this.id = id;
        this.name = name;
        this.dept_id = dept_id;
    }

    public Integer getId() {
        return id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
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

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
