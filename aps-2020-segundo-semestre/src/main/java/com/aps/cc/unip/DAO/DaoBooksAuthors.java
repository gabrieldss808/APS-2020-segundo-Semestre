package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.BooksAuthors;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoBooksAuthors extends DaoAll {
    public void DaoBooksAuthors() {}

    public BooksAuthors getByName(String name) throws HibernateException {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(BooksAuthors.class);
        criteria.add(Restrictions.eq("name", name));

        Object obj = criteria.uniqueResult();

        transaction.commit();
        session.close();

        return (BooksAuthors) obj;
    }
}
