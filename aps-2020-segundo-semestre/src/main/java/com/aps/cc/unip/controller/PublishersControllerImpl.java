package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoPublishers;
import com.aps.cc.unip.exception.ReadValuesFailException;
import com.aps.cc.unip.exception.SaveOrUpdateFailException;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Publishers;
import org.hibernate.HibernateException;

import java.util.List;

public class PublishersControllerImpl implements PublishersControllerInterface {
    DaoPublishers daoPublishers;

    public PublishersControllerImpl(){
        daoPublishers = new DaoPublishers();
    }

    @Override
    public List<Publishers> getPublishers() throws HibernateException{
        try {
            return daoPublishers.carregarTudoOrdenado("name", Publishers.class);
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha na leitura das editoras");
        }
    }

    @Override
    public Publishers getPublisherByName(String name) throws HibernateException{
        try {
            return daoPublishers.getByName(name);
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha na leitura da editora: \n"+name);
        }
    }

    @Override
    public Publishers getPublisherById(Integer IdPubli) throws HibernateException{
        try {
            return daoPublishers.getById(IdPubli);
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha na leitura da editora");
        }
    }

    @Override
    public boolean addPublisher(Publishers publishers) throws HibernateException{
        try {
            daoPublishers.gravar(publishers);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao adicionar a editora: \n"+publishers);
        }
    }

    @Override
    public boolean updatePublisher(Publishers publishers) throws HibernateException{
        try {
            daoPublishers.alterar(publishers);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao alterar a editora: \n"+publishers);
        }
    }

    @Override
    public boolean deletePublisher(Publishers publishers) throws HibernateException{
        try {
            daoPublishers.excluir(publishers);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao deletar a editora: \n"+publishers);
        }
    }

    @Override
    public List<Publishers> getPublishersPesq(String namePublishersPesq) throws HibernateException {
        try {
            return daoPublishers.getByNamePesq("name", Publishers.class,namePublishersPesq,"name");
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura da Editora.");
        }
    }
}
