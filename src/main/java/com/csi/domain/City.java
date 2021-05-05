package com.csi.domain;

/**
 * 城市
 * @author 張旭
 * @version 1.0
 * @date 2021/3/24 17:25
 */
public class City {
    private int id;
    private String name;
    private int cid;

    public City() {
    }

    public City(int id, String name, int cid) {
        this.id = id;
        this.name = name;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                '}';
    }
}
