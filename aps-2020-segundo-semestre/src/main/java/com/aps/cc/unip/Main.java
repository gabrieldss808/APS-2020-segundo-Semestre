package com.aps.cc.unip;

import com.aps.cc.unip.DAO.HibernateConfig;
import com.aps.cc.unip.controller.*;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.BooksAuthors;
import com.aps.cc.unip.model.Publishers;

import javax.swing.*;
import java.awt.print.Book;

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

        authors.setName("TesteName3");
        authors.setFname("TesteFname3");
        ctrAuthors.addAuthor(authors);*/









        /*publisher funcionando*/

        /*PublishersControllerImpl ctrPublishers = new PublishersControllerImpl();
        Publishers publishers = new Publishers();

        publishers.setName("Publi4");
        publishers.setUrl("www.publi4.com");

        ctrPublishers.addPublisher(publishers);*/







        /*Books funcionando*/
        /*BooksControllerImpl ctrBooks = new BooksControllerImpl();
        Books books = new Books();
        PublishersControllerImpl ctrPublishers = new PublishersControllerImpl();


        books.setTitle("BOOK4");
        books.setIsbn("ISBN4TESTE");
        books.setPublisher_id(ctrPublishers.getPublisherByName("Publi3"));
        books.setPrice((float) 88.4);

        ctrBooks.addBook(books);*/






        /*BooksAuthors*/
        /*BooksAuthorsControllerImpl ctrBooksAuthors = new BooksAuthorsControllerImpl();
        BooksAuthors booksAuthors = new BooksAuthors();
        BooksControllerImpl ctrBooks = new BooksControllerImpl();
        AuthorsControllerImpl ctrAuthors = new AuthorsControllerImpl();

        booksAuthors.setIsbn(ctrBooks.getBookByName("BOOK1"));
        booksAuthors.setAuthor_id(ctrAuthors.getAuthorByName("TesteName1"));

        ctrBooksAuthors.addBooksAuthor(booksAuthors);*/




        System.out.println("Finish");
    }



}
