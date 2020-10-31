package com.aps.cc.unip.control;

import java.util.List;

import com.aps.cc.unip.model.Publishers;
import org.hibernate.HibernateException;
import com.aps.cc.unip.DAO.DaoPublishers;


public class CtrPublishers {
    DaoPublishers acessohibernateauthors;

    public CtrPublishers() {
        acessohibernateauthors = new DaoPublishers();
    }
    public int gravarPublishers(Publishers publishers) {
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
            return acessohibernateauthors.carregarTudoOrdenado(Publishers.class,
                    "nome");
        } catch (HibernateException e) {
            return null;
        }
    }
    public boolean excluirPublishers(Publishers publishers) {
        try {
            acessohibernateauthors.excluir(publishers);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarPublishers(Publishers publishers) {
        try {
            acessohibernateauthors.alterar(publishers);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }
}