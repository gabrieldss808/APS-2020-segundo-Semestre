package com.aps.cc.unip;

import com.aps.cc.unip.DAO.BDAuthorsFunctions;
import com.aps.cc.unip.model.Authors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        BDAuthorsFunctions authorsFunctions = new BDAuthorsFunctions();
        Authors authors = (Authors) authorsFunctions.carregarUm(1, Authors.class);

        System.out.println("author: ");
        System.out.println(authors);

        System.out.println("Finish");
    }

}
