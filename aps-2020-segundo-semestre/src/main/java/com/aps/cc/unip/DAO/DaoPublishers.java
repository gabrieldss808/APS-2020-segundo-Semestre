package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.Publishers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoPublishers extends DaoAll{
    public void DaoPublishers(){}

    public Publishers getByName(String name){
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Publishers.class);
        criteria.add(Restrictions.eq("name", name));

        Object obj = criteria.uniqueResult();

        transaction.commit();
        session.close();

        return (Publishers) obj;
    }
}
