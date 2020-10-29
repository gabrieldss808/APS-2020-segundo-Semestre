package com.aps.cc.unip.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Authors implements Serializable {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;
    private String name;
    private String fname;

    public Authors(){}

    public Authors(String name, String fname){
        this.setName(name);
        this.setFname(fname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                '}';
    }
}
