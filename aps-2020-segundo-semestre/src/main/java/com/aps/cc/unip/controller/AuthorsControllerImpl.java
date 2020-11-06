package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoAuthors;
import com.aps.cc.unip.exception.DeleteFailException;
import com.aps.cc.unip.exception.ReadValuesFailException;
import com.aps.cc.unip.exception.SaveOrUpdateFailException;
import com.aps.cc.unip.model.Authors;
import org.hibernate.HibernateException;

import java.util.List;

public class AuthorsControllerImpl implements AuthorsControllerInterface {
    DaoAuthors daoAuthors;

    public AuthorsControllerImpl() {
        daoAuthors = new DaoAuthors();
    }

    @Override
    public List<Authors> getAuthors() throws HibernateException {
        try {
            return daoAuthors.carregarTudoOrdenado("name", Authors.class);
        } catch (HibernateException e) {
            throw new ReadValuesFailException("Falha na leitura dos Autores.");
        }
    }

    @Override
    public List<Authors> getAuthorsPesq(String nameAuthorPesq) throws HibernateException {
        try {
            return daoAuthors.getByNamePesq("name", Authors.class,nameAuthorPesq,"name");
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura dos Livros.");
        }
    }

    @Override
    public Authors getAuthorByName(String name) throws HibernateException{
        try {
            return daoAuthors.getByName(name);
        } catch (HibernateException e) {
            throw new ReadValuesFailException("Falha na leitura do Autor: "+ name+".");
        }
    }

    @Override
    public boolean addAuthor(Authors author) throws HibernateException{
        try {
            daoAuthors.gravar(author);
            return true;
        } catch (HibernateException e) {
            throw new SaveOrUpdateFailException("Falha ao adicionar o Autor: \n"+author);
        }
    }

    @Override
    public boolean updateAuthor(Authors author) throws HibernateException{
        try {
            daoAuthors.alterar(author);
            return true;
        } catch (HibernateException e) {
            throw new SaveOrUpdateFailException("Falha ao alterar o Autor: \n"+author);
        }
    }

    @Override
    public boolean deleteAuthor(Authors author) throws HibernateException{
        try {
            daoAuthors.excluir(author);
            return true;
        } catch (HibernateException e) {
            throw new DeleteFailException("Falha ao deletar o Autor: \n"+author);
        }

    }
}
