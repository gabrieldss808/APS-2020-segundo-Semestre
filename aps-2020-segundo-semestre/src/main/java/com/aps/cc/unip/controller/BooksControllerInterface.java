package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Books;
import org.hibernate.HibernateException;

import java.util.List;

public interface BooksControllerInterface {
    public List<Books> getBooks() throws HibernateException;

    public List<Books> getBooksPesq(String namePesq) throws HibernateException;

    public Books getBookByName(String name) throws HibernateException;

    public boolean addBook(Books books) throws HibernateException;

    public boolean updateBook(Books books) throws HibernateException;

    public boolean deleteBook(Books books) throws HibernateException;
}
