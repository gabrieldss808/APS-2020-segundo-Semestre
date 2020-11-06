package com.aps.cc.unip.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BooksAuthors implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name="isbn")
    private Books isbn;

    @OneToOne
    @JoinColumn(name="author_id")
    private Authors author_id;

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
}