package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Books;
import org.hibernate.HibernateException;

import java.util.List;

public interface BooksControllerInterface {
    List<Books> getBooks() throws HibernateException;

    List<Books> getBooksPesq(String namePesq) throws HibernateException;

    Books getBookByName(String name) throws HibernateException;

    boolean addBook(Books books) throws HibernateException;

    boolean updateBook(Books books) throws HibernateException;

    boolean deleteBook(Books books) throws HibernateException;
}
