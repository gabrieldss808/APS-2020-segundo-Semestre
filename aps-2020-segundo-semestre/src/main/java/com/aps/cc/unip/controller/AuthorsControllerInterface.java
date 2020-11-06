package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Authors;
import org.hibernate.HibernateException;

import java.util.List;

public interface AuthorsControllerInterface {

    List<Authors> getAuthors() throws HibernateException;

    List<Authors> getAuthorsPesq(String nameAuthorPesq) throws HibernateException;

    Authors getAuthorByName(String name) throws HibernateException;

    boolean addAuthor(Authors author) throws HibernateException;

    boolean updateAuthor(Authors author) throws HibernateException;

    boolean deleteAuthor(Authors author) throws HibernateException;
}
