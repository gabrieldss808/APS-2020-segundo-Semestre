package com.aps.cc.unip.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BooksAuthors implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name="isbn")
    private Books isbn;

    @Id
    @OneToOne
    @JoinColumn(name="author_id")
    private Authors author_id;

    @Column(unique = true)
    private Integer seq_no;

    public void BooksAuthors(){}

    public Books getIsbn() {
        return isbn;
    }

    public void setIsbn(Books isbn) {
        this.isbn = isbn;
    }

    public Authors getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Authors author_id) {
        this.author_id = author_id;
    }

    public Integer getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(Integer seq_no) {
        this.seq_no = seq_no;
    }
}