package com.aps.cc.unip;

import com.aps.cc.unip.DAO.JDBCConnection;
import com.aps.cc.unip.model.Author;

public class Main {

    public static void main(String[] args) {
        String URL = "jdbc:postgresql://<host>:<port>/<database-name>";
        String user="<user>";
        String password="<password>";

        JDBCConnection jdbcConnection = new JDBCConnection(URL, user, password);
        System.out.println("Getting connection");
        jdbcConnection.getConnection();

        Author author = new Author("Name", "F. Name");
        System.out.println("Author ID: " + jdbcConnection.insertAuthor(author));

        jdbcConnection.executeQuery("select * from Authors");

        System.out.println("Finish");
    }

}
