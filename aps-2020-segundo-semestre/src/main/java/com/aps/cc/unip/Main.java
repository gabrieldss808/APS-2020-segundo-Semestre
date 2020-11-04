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









        /*authors funcionando*/
        /*AuthorsControllerImpl ctrAuthors;
        Authors authors;

        ctrAuthors = new AuthorsControllerImpl();
        authors = new Authors();

        authors.setName("TesteName7");
        authors.setFname("TesteFname7");
        ctrAuthors.addAuthor(authors);*/









        /*publisher funcionando*/

        /*PublishersControllerImpl ctrPublishers;
        Publishers publishers;

        ctrPublishers = new PublishersControllerImpl();
        publishers = new Publishers();

        publishers.setName("Publi11");
        publishers.setUrl("www.publi11.com");

        ctrPublishers.addPublisher(publishers);*/








        /*BooksControllerImpl ctrBooks = new BooksControllerImpl();
        Books books = new Books();
        PublishersControllerImpl ctrPublishers = new PublishersControllerImpl();


        books.setTitle("BOOK3");
        books.setIsbn("ISBN3TESTE");
        books.setPublisher_id(ctrPublishers.getPublisherByName("Publi11"));
        books.setPrice((float) 88.4);

        ctrBooks.addBook(books);


        System.out.println("Finish");*/
    }



}
