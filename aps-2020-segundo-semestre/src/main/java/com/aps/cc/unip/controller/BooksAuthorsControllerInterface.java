package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.BooksAuthors;
import org.hibernate.HibernateException;

import java.util.List;

public interface BooksAuthorsControllerInterface {
    public List<BooksAuthors> getBooksAuthors() throws HibernateException;

    public BooksAuthors getBookAuthorByName(String name) throws HibernateException;

    public boolean addBooksAuthor(BooksAuthors booksAuthors) throws HibernateException;

    public boolean updateBookAuthor(BooksAuthors booksAuthors) throws HibernateException;

    public boolean deleteBookAuthor(BooksAuthors booksAuthors) throws HibernateException;
}