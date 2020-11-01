package com.aps.cc.unip;

import com.aps.cc.unip.controller.AuthorsControllerImpl;
import com.aps.cc.unip.controller.AuthorsControllerInterface;
import com.aps.cc.unip.model.Authors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        try {
            System.out.println("Authors Controller");
            AuthorsControllerInterface authorsController = new AuthorsControllerImpl();

            System.out.println("Get all");
            for (Authors author : authorsController.getAuthors()){
                System.out.println(author);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Finish");
    }

}
