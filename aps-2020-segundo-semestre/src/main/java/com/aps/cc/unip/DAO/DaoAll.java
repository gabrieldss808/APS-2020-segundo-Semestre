package com.aps.cc.unip.DAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DaoAll {
    protected HibernateConfig hibernateConfiguracao;

    public DaoAll() {
        hibernateConfiguracao = new HibernateConfig();
    }

    public void gravar(Object obj) throws HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    public void alterar(Object obj) throws HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    public void excluir(Object obj) throws HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    public List carregarTudoOrdenado(String ordem, Class<?> clas) throws
            HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Criteria criteria = session.createCriteria(clas);
        criteria.addOrder(Order.asc(ordem));
        List lista = criteria.list();
        session.close();
        return lista;
    }

    public List getByNamePesq(String ordem, Class<?> clas,String NamePesq, String Field) throws
            HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Criteria criteria = session.createCriteria(clas);
        criteria.add(Restrictions.like(Field, '%'+NamePesq+'%'));
        criteria.addOrder(Order.asc(ordem));
        List lista = criteria.list();
        session.close();
        return lista;
    }

    public Object carregarUm(int id, Class<?> clas) throws HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(clas);
        criteria.add(Restrictions.eq("id", id));
        Object obj = criteria.uniqueResult();
        transaction.commit();
        session.close();
        return obj;
    }
}