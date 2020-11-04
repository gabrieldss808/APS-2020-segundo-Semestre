package com.aps.cc.unip;

import com.aps.cc.unip.controller.*;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.Publishers;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        try {

            AuthorsControllerInterface authorsController = new AuthorsControllerImpl();
            BooksControllerInterface booksController = new BooksControllerImpl();
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
