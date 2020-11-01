package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Authors;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DaoAuthors extends DaoAll {
    public void DaoAuthors() {
        super.clasz = Authors.class;
        System.out.println("Class: "+super.clasz);
    }

    public Authors getByName(String name) {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(super.clasz);
        criteria.add(Restrictions.eq("name", name));

        Object obj = criteria.uniqueResult();

        transaction.commit();
        session.close();

        return (Authors) obj;
    }
}
