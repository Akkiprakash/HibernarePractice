package com.model;


import jakarta.persistence.*;

@Entity
@Table(name = "StudentTable")
public class Student {
    @Id
    @Column
    private Integer sid;

    private String sname;
    private String scity;
    public Student(){

    }


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    @Override
    public String toString() {
        return "student{" + "sid=" + sid + ", sname='" + sname + '\'' +
                ", scity='" + scity + '\'' +
                '}';
    }
}

