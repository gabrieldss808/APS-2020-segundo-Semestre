package com.aps.cc.unip.view;

import com.aps.cc.unip.controller.BooksControllerImpl;
import com.aps.cc.unip.controller.BooksControllerInterface;
import com.aps.cc.unip.model.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicationsView {

    private JPanel PublicationsViewMain;
    private JTextField SearchInput;
    private JButton BtnSearchNow;
    private JList PublicationsList;
    private JButton btnVisualizar;
    private DefaultListModel listOfBooks;

    public PublicationsView() {

        this.listOfBooks = new DefaultListModel();

        this.LoadingItensList();

        this.PublicationsList.setModel(this.listOfBooks);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnSearchNow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listOfBooks.clear();

                try {

                    BooksControllerInterface booksController = new BooksControllerImpl();

                    for (Books books : booksController.getBooksPesq(SearchInput.getText().trim())) {

                        listOfBooks.addElement("Titulo: " + books.getTitle().trim());
                    }
                }catch (Exception error){
                    error.printStackTrace();
                }
            }
        });
    }

    public void ShowView() {

        JFrame PublicationsView = new JFrame("Livrária Amazonas");
        PublicationsView.setContentPane(new PublicationsView().PublicationsViewMain);
        PublicationsView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        PublicationsView.setLocationRelativeTo(null);
        PublicationsView.setSize(new Dimension(275,450));
        PublicationsView.pack();
        PublicationsView.setVisible(true);
    }

    public void LoadingItensList(){

        try {
            System.out.println("Books Controller");
            BooksControllerInterface booksController = new BooksControllerImpl();

            System.out.println("Get all");
            for (Books books : booksController.getBooks()) {

                this.listOfBooks.addElement("Titulo: " + books.getTitle().trim());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
