package com.aps.cc.unip.control;

import java.util.List;

import com.aps.cc.unip.model.Books;
import org.hibernate.HibernateException;
import com.aps.cc.unip.DAO.DaoBooks;


public class CtrBooks {
    DaoBooks acessohibernateauthors;

    public CtrBooks() {
        acessohibernateauthors = new DaoBooks();
    }
    public int gravarPublishers(Books publishers) {
        try {
            acessohibernateauthors.gravar(publishers);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            return 2;
        }
    }
    public List carregarPublishers() {
        try {
            return acessohibernateauthors.carregarTudoOrdenado(Books.class,
                    "nome");
        } catch (HibernateException e) {
            return null;
        }
    }
    public boolean excluirPublishers(Books books) {
        try {
            acessohibernateauthors.excluir(books);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarPublishers(Books books) {
        try {
            acessohibernateauthors.alterar(books);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }
}