package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Books;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoBooks extends DaoAll{
    public DaoBooks(){
        super.clasz = Books.class;
    }

    public Books getByName(String name){
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(super.clasz);
        criteria.add(Restrictions.eq("title", name));

        Object obj = criteria.uniqueResult();

        transaction.commit();
        session.close();

        return (Books) obj;
    }
}
