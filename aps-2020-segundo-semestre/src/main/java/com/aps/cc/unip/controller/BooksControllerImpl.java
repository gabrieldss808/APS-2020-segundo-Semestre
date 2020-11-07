package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoBooks;
import com.aps.cc.unip.exception.ReadValuesFailException;
import com.aps.cc.unip.exception.SaveOrUpdateFailException;
import com.aps.cc.unip.model.Books;
import org.hibernate.HibernateException;

import java.util.List;

public class BooksControllerImpl implements BooksControllerInterface {
    DaoBooks daoBooks;

    public BooksControllerImpl() {
        daoBooks = new DaoBooks();
    }

    @Override
    public List<Books> getBooks() throws HibernateException{
        try {
            return daoBooks.carregarTudoOrdenado("title", Books.class);
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura dos Livros.");
        }

    }

    @Override
    public List<Books> getBooksPesq(String namePesq) throws HibernateException{
        try {
            return daoBooks.getByNamePesq("title",Books.class,namePesq,"title");
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura dos Livros.");
        }

    }

    @Override
    public Books getBookByName(String name) throws HibernateException{
        try {
            return daoBooks.getByName(name);
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura do Livro: "+ name+".");
        }
    }

    @Override
    public Integer getBooksCountByPublisherId(Integer publisherId) throws HibernateException {
        try {
            return daoBooks.countByPublisherId(publisherId);
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na contagens de Livros pelo Id de Editora: "+ publisherId+".");
        }
    }

    @Override
    public List<Books> getBooksByPublisherId(Integer publisherId) throws HibernateException {
        try {
            return daoBooks.byPublisherId(publisherId);
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura de Livros pelo Id de Editora: "+ publisherId+".");
        }
    }

    @Override
    public boolean addBook(Books books) throws HibernateException{
        try{
            daoBooks.gravar(books);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao adicionar o Livro: \n"+books);
        }
    }

    @Override
    public boolean updateBook(Books books) throws HibernateException{
        try{
            daoBooks.alterar(books);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao alterar o Autor: \n"+books);
        }
    }

    @Override
    public boolean deleteBook(Books books) throws HibernateException{
        try{
            daoBooks.excluir(books);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao deletar o Autor: \n"+books);
        }
    }
}
