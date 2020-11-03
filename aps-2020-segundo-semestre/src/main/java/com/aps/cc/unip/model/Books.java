package com.aps.cc.unip.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Books implements Serializable {

    private String title;
    @Id
    @Column(unique = true)
    private String isbn;
    @OneToOne
    @JoinColumn(name = "Publisher_id")
    private Integer publisher_id;
    private Float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher_id=" + publisher_id +
                ", price=" + price +
                '}';
    }
}