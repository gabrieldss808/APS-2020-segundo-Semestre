package com.aps.cc.unip.model;

public class Author {
    private String name;
    private String fname;

    public Author(String name, String fname){
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
}
