package com.aps.cc.unip;

import com.aps.cc.unip.DAO.HibernateConfig;
import com.aps.cc.unip.controller.*;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.Publishers;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        try {

            AuthorsControllerInterface authorsController = new AuthorsControllerImpl();

            System.out.println("Get all");
            for (Authors author : authorsController.getAuthors()){
                System.out.println(author);
            }

            System.out.println("Books Controller");
            BooksControllerInterface booksController = new BooksControllerImpl();

            System.out.println("Get all");
            for (Books books : booksController.getBooks()){
                System.out.println(books);
            }

            System.out.println("Publisher Controller");
            PublishersControllerInterface publishersController = new PublishersControllerImpl();

            //System.out.println("Get all Authors");
            //for (Authors authors : authorsController.getAuthors()){
            //    System.out.println(authors);
            //}

            System.out.println("Get all Books");
            for (Books book : booksController.getBooks()){
                System.out.println(book);
            }

            System.out.println("Get all Publishers");
            for (Publishers publishers : publishersController.getPublishers()){
                System.out.println(publishers);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Finish");
    }

}
