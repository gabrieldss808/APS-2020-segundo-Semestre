package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Publishers;
import org.hibernate.HibernateException;

import java.util.List;

public interface PublishersControllerInterface {
    public List<Publishers> getPublishers() throws HibernateException;

    public Publishers getPublisherByName(String name) throws HibernateException;

    public Publishers getPublisherById(Integer IdPubli) throws HibernateException;

    public boolean addPublisher(Publishers publishers) throws HibernateException;

    public boolean updatePublisher(Publishers publishers) throws HibernateException;

    public boolean deletePublisher(Publishers publishers) throws HibernateException;
}
