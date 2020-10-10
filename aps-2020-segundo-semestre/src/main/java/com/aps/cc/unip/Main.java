package com.aps.cc.unip;

import com.aps.cc.unip.DAO.BDAuthorsFunctions;
import com.aps.cc.unip.DAO.JDBCConnection;
import com.aps.cc.unip.model.Author;

public class Main {

    public static void main(String[] args) {

        Author author = new Author("Gabriel ", "Da Silva Souza");

        BDAuthorsFunctions BDFunctions = new BDAuthorsFunctions();

        BDFunctions.gravar(author);

        System.out.println("Finish");
    }

}
