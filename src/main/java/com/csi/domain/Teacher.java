package com.csi.domain;

/**
 * 教师信息
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 17:00
 */
public class Teacher {
    private String teaId;
    private String teaPassword;
    private String teaName;
    private String teaSex;
    private String teaPhone;
    private String teaAddress;
    private TeaDept dept;
    private String teaState;//判断是否管理员
    private TeaRank rank;

    public Teacher() {
    }

    public Teacher(String teaId, String teaPassword, String teaName, String teaSex, String teaPhone, String teaAddress, TeaDept dept, String teaState, TeaRank rank) {
        this.teaId = teaId;
        this.teaPassword = teaPassword;
        this.teaName = teaName;
        this.teaSex = teaSex;
        this.teaPhone = teaPhone;
        this.teaAddress = teaAddress;
        this.dept = dept;
        this.teaState = teaState;
        this.rank = rank;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    public String getTeaAddress() {
        return teaAddress;
    }

    public void setTeaAddress(String teaAddress) {
        this.teaAddress = teaAddress;
    }

    public TeaDept getDept() {
        return dept;
    }

    public void setDept(TeaDept dept) {
        this.dept = dept;
    }

    public String getTeaState() {
        return teaState;
    }

    public void setTeaState(String teaState) {
        this.teaState = teaState;
    }

    public TeaRank getRank() {
        return rank;
    }

    public void setRank(TeaRank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teaId='" + teaId + '\'' +
                ", teaPassword='" + teaPassword + '\'' +
                ", teaName='" + teaName + '\'' +
                ", teaSex='" + teaSex + '\'' +
                ", teaPhone='" + teaPhone + '\'' +
                ", teaAddress='" + teaAddress + '\'' +
                ", dept=" + dept +
                ", teaState=" + teaState +
                ", rank=" + rank +
                '}';
    }
}