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

        /*try {
            System.out.println("Authors Controller");
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

            System.out.println("Get all");
            for (Publishers publishers : publishersController.getPublishers()){
                System.out.println(publishers);
            }

            //System.out.println("Add");
            //Authors v = new Authors();
            //v.setAuthor_id(7);
            //v.setName("Veronica");
            //v.setFname("L.");

            //System.out.println(authorsController.getAuthorByName("Victoria"));
        }catch (Exception e){
            e.printStackTrace();
        }*/


        /*publisher funcionando*/
        /*
        PublishersControllerImpl ctrPublishers;
        Publishers publishers;

        ctrPublishers = new PublishersControllerImpl();
        publishers = new Publishers();

        publishers.setName("Publi4");
        publishers.setUrl("www.publi4.com");

        ctrPublishers.addPublisher(publishers);

        /*authors funcionando*/
        /*AuthorsControllerImpl ctrAuthors;
        Authors authors;

        ctrAuthors = new AuthorsControllerImpl();
        authors = new Authors();

        authors.setName("TesteName7");
        authors.setFname("TesteFname7");
        ctrAuthors.addAuthor(authors);*/

        /*BooksControllerImpl ctrBooks = new BooksControllerImpl();
        Books books = new Books();

        books.setTitle("BOOK2");
        books.setIsbn("ISBN2TESTE");
        books.setPublisher_id(1);
        books.setPrice((float) 50.4);

        ctrBooks.addBook(books);
        */

        System.out.println("Finish");
    }



}
