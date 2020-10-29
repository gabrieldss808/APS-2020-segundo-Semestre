/*package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Author;

import java.sql.*;

public class JDBCConnection {
    private String className, URL, user, password;
    private Connection connection;

    //Construtor da classe, setta todos os atributos necessários para a conexão com o BD
    public JDBCConnection(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.connection = null;
    }

    public void getConnection(){

        System.out.println("Starting connection to DataBase...");
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connected to DataBase Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        ResultSet resultSet = null;
        try {

            //executing query
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);

            //Get Number of columns
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnsNumber = metaData.getColumnCount();

            //Printing the results
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.printf("%-25s", (resultSet.getObject(i) != null) ? resultSet.getObject(i).toString() : "vaziooo");
                }

                System.out.println("\n");
            }
        } catch (SQLException ex) {
            System.out.println("Exception while executing statement. Terminating program... " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("General exception while executing query. Terminating the program..." + ex.getMessage());

        }
    }


    public long insertAuthor(Author author) {
        String SQL = "INSERT INTO authors(name,fname) " + "VALUES(?,?)";

        long id = 0;

        try (Connection conn = connection;
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, author.getName());
            pstmt.setString(2, author.getFname());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
*/