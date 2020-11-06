package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Publishers;
import org.hibernate.HibernateException;

import java.util.List;

public interface PublishersControllerInterface {
    List<Publishers> getPublishers() throws HibernateException;

    Publishers getPublisherByName(String name) throws HibernateException;

    Publishers getPublisherById(Integer IdPubli) throws HibernateException;

    boolean addPublisher(Publishers publishers) throws HibernateException;

    boolean updatePublisher(Publishers publishers) throws HibernateException;

    boolean deletePublisher(Publishers publishers) throws HibernateException;

    List<Publishers> getPublishersPesq(String namePublishersPesq) throws HibernateException;
}
