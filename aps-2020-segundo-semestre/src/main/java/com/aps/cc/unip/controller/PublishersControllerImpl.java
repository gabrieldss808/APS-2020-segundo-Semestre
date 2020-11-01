package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoPublishers;
import com.aps.cc.unip.model.Publishers;
import org.hibernate.HibernateException;

import java.util.List;

public class PublishersControllerImpl implements PublishersControllerInterface {
    DaoPublishers daoPublishers;

    public PublishersControllerImpl(){
        daoPublishers = new DaoPublishers();
    }

    @Override
    public List<Publishers> getPublishers() {
        try {
            return daoPublishers.carregarTudoOrdenado("name", Publishers.class);
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Publishers getPublisherByName(String name) {
        try {
            return daoPublishers.getByName(name);
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addPublisher(Publishers publishers) {
        try {
            daoPublishers.gravar(publishers);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePublisher(Publishers publishers) {
        try {
            daoPublishers.alterar(publishers);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePublisher(Publishers publishers) {
        try {
            daoPublishers.excluir(publishers);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }
}
