package com.aps.cc.unip.view;

import com.aps.cc.unip.controller.BooksControllerImpl;
import com.aps.cc.unip.controller.BooksControllerInterface;
import com.aps.cc.unip.model.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;

public class PublicationsView {

    private JPanel PublicationsViewMain;
    private JTextField SearchInput;
    private JButton BtnSearchNow;
    private JList PublicationsList;
    private JButton btnVisualizar;
    private Array listOfBooks;

    public PublicationsView() {
        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(PublicationsList.getSelectedValue());
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

        this.LoadingItensList();

        PublicationsView.setVisible(true);
    }

    public void LoadingItensList(){
        try {
            System.out.println("Books Controller");
            BooksControllerInterface booksController = new BooksControllerImpl();

            System.out.println("Get all");
            for (Books books : booksController.getBooks()) {
                System.out.println(books);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
