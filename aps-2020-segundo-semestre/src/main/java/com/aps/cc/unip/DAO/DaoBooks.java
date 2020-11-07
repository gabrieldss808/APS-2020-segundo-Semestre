package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.BooksAuthors;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DaoBooks extends DaoAll {
    public DaoBooks(){}

    public Books getByName(String name) throws HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Books.class);
        criteria.add(Restrictions.eq("title", name));

        Object obj = criteria.uniqueResult();

        transaction.commit();
        session.close();

        return (Books) obj;
    }

    public Integer countByPublisherId(Integer publisherId) throws HibernateException{

        return byPublisherId(publisherId).size();
    }

    public List byPublisherId(Integer publisherId) throws HibernateException{
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Books.class);
        criteria.add(Restrictions.eq("publisher_id", publisherId));

        List objList = criteria.list();

        transaction.commit();
        session.close();

        return objList;
    }

}
