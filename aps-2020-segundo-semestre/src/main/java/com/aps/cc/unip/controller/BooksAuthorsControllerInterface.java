package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.BooksAuthors;
import org.hibernate.HibernateException;

import java.util.List;

public interface BooksAuthorsControllerInterface {
    List<BooksAuthors> getBooksAuthors() throws HibernateException;

    BooksAuthors getBookAuthorByIsbn(Books Isbn) throws HibernateException;

    Integer getBooksCountByAuthorId(Integer authorId) throws HibernateException;

    List<BooksAuthors> getBooksByAuthorId(Integer authorId) throws HibernateException;

    boolean addBooksAuthor(BooksAuthors booksAuthors) throws HibernateException;

    boolean updateBookAuthor(BooksAuthors booksAuthors) throws HibernateException;

    boolean deleteBookAuthor(BooksAuthors booksAuthors) throws HibernateException;
}