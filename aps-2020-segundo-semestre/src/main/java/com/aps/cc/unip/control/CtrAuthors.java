package com.aps.cc.unip.control;

import java.util.List;

import com.aps.cc.unip.model.Author;
import org.hibernate.HibernateException;
import com.aps.cc.unip.DAO.DaoAuthors;
import com.aps.cc.unip.model.Author;


public class CtrAuthors {
    DaoAuthors acessohibernateauthors;

    public CtrAuthors() {
        acessohibernateauthors = new DaoAuthors();
    }
    public int gravarAuthors(Author author) {
        try {
            acessohibernateauthors.gravar(author);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 2;
        }
    }
    public List carregarAuthors() {
        try {
            return acessohibernateauthors.carregarTudoOrdenado(Author.class,
                    "nome");
        } catch (HibernateException e) {
            return null;
        }
    }
    public boolean excluirAuthors(Author author) {
        try {
            acessohibernateauthors.excluir(author);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarAuthors(Author author) {
        try {
            acessohibernateauthors.alterar(author);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }
}