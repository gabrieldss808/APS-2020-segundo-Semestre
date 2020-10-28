package com.aps.cc.unip.model;
//
//import net.bytebuddy.implementation.bind.MethodDelegationBinder;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//
//public class Author implements Serializable {
//
//
//    @Id
//    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer author_id;
//    private String name;
//    private String fname;
//
//    public Author(String name, String fname){
//        this.setName(name);
//        this.setFname(fname);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getFname() {
//        return fname;
//    }
//
//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//}
