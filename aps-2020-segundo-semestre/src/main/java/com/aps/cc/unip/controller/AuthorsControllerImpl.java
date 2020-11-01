package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoAuthors;
import com.aps.cc.unip.model.Authors;
import org.hibernate.HibernateException;

import java.util.List;

public class AuthorsControllerImpl implements AuthorsControllerInterface {
    DaoAuthors daoAuthors;

    public AuthorsControllerImpl() {
        daoAuthors = new DaoAuthors();
    }

    @Override
    public List<Authors> getAuthors() {
        try {
            return daoAuthors.carregarTudoOrdenado( "name", Authors.class);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Authors getAuthorByName(String name) {
        try {
            return daoAuthors.getByName(name);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addAuthor(Authors author) {
        try {
            daoAuthors.gravar(author);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAuthor(Authors author) {
        try {
            daoAuthors.alterar(author);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAuthor(Authors author) {
        try {
            daoAuthors.excluir(author);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }
}
