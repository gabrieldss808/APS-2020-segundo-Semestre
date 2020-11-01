package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Authors;
import org.hibernate.HibernateException;

import java.util.List;

public interface AuthorsControllerInterface {

    public List<Authors> getAuthors() throws HibernateException;

    public Authors getAuthorByName(String name) throws HibernateException;

    public boolean addAuthor(Authors author) throws HibernateException;

    public boolean updateAuthor(Authors author) throws HibernateException;

    public boolean deleteAuthor(Authors author) throws HibernateException;
}
