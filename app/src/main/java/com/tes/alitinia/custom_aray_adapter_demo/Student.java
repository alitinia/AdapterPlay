package com.tes.alitinia.custom_aray_adapter_demo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alitinia on 10/7/2016.
 */


public class Student implements Serializable {
    private int id;
    private String noreg;
    private String name;
    private String mail;
    private String phone;

    public Student(int id, String noreg, String name, String mail, String phone) {
        this.setId(id);
        this.noreg=noreg;
        this.name=name;
        this.mail=mail;
        this.phone=phone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}