package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.DaoBooks;
import com.aps.cc.unip.model.Books;
import org.hibernate.HibernateException;

import java.util.List;

public class BooksControllerImpl implements BooksControllerInterface {
    DaoBooks daoBooks;

    public BooksControllerImpl() {
        daoBooks = new DaoBooks();
    }

    @Override
    public List<Books> getBooks() {
        try {
            return daoBooks.carregarTudoOrdenado("title", Books.class);
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Books getBookByName(String name) {
        try {
            return daoBooks.getByName(name);
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addBook(Books books) {
        try{
            daoBooks.gravar(books);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Books books) {
        try{
            daoBooks.alterar(books);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(Books books) {
        try{
            daoBooks.excluir(books);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }
}
