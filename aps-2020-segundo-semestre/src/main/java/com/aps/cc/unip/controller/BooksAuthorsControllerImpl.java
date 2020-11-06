package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoBooksAuthors;
import com.aps.cc.unip.exception.ReadValuesFailException;
import com.aps.cc.unip.exception.SaveOrUpdateFailException;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.BooksAuthors;
import org.hibernate.HibernateException;

import java.util.List;

public class BooksAuthorsControllerImpl implements BooksAuthorsControllerInterface {
    DaoBooksAuthors daoBooksAuthors;

    public BooksAuthorsControllerImpl() {
        daoBooksAuthors = new DaoBooksAuthors();
    }

    @Override
    public List<BooksAuthors> getBooksAuthors() throws HibernateException{
        try {
            return daoBooksAuthors.carregarTudoOrdenado("title", BooksAuthors.class);
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura dos BooksAuthors.");
        }

    }

    @Override
    public BooksAuthors getBookAuthorByIsbn(Books Isbn) throws HibernateException{
        try {
            return daoBooksAuthors.getByIsbn(Isbn);
        }catch (HibernateException e){
            throw new ReadValuesFailException("Falha na leitura do BooksAuthors: "+ Isbn+".");
        }
    }

    @Override
    public boolean addBooksAuthor(BooksAuthors booksAuthors) throws HibernateException{
        try{
            daoBooksAuthors.gravar(booksAuthors);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao adicionar o BooksAuthors: \n"+booksAuthors);
        }
    }

    @Override
    public boolean updateBookAuthor(BooksAuthors booksAuthors) throws HibernateException{
        try{
            daoBooksAuthors.alterar(booksAuthors);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao alterar o BooksAuthors: \n"+booksAuthors);
        }
    }

    @Override
    public boolean deleteBookAuthor(BooksAuthors booksAuthors) throws HibernateException{
        try{
            daoBooksAuthors.excluir(booksAuthors);
            return true;
        }catch (HibernateException e){
            throw new SaveOrUpdateFailException("Falha ao deletar o BooksAuthors: \n"+booksAuthors);
        }
    }
}