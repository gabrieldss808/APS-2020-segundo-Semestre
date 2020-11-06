package com.aps.cc.unip.view;

import com.aps.cc.unip.controller.*;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.BooksAuthors;
import com.aps.cc.unip.model.Publishers;

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

                String bookInformationText = "";

                BooksControllerInterface booksController = new BooksControllerImpl();
                Books BookObj = booksController.getBookByName(PublicationsList.getSelectedValue().toString());

                PublishersControllerImpl publishersController = new PublishersControllerImpl();
                Publishers PublisherObj = publishersController.getPublisherById(BookObj.getPublisher_id().getPublisher_id());

                BooksAuthorsControllerInterface booksAuthorsController = new BooksAuthorsControllerImpl();
                BooksAuthors BooksAuthorsObj = booksAuthorsController.getBookAuthorByIsbn(BookObj);

                bookInformationText += "Abaixo as Informações do Livro\n\n";
                bookInformationText += "Titulo: " + BookObj.getTitle() + "\n";
                bookInformationText += "Autor: " + BooksAuthorsObj.getAuthor_id().getName().trim() + ' ' + BooksAuthorsObj.getAuthor_id().getFname().trim() + "\n";
                bookInformationText += "Codigo ISBN: " + BookObj.getIsbn() + "\n";
                bookInformationText += "Valor: R$" + BookObj.getPrice().toString() + "\n";
                bookInformationText += "Editora: " + PublisherObj.getName() + "\n";
                bookInformationText += "Site Editora: " + PublisherObj.getUrl() + "\n";



                JOptionPane.showMessageDialog(null,bookInformationText);
            }
        });
        BtnSearchNow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listOfBooks.clear();

                try {

                    BooksControllerInterface booksController = new BooksControllerImpl();

                    for (Books books : booksController.getBooksPesq(SearchInput.getText().trim())) {

                        listOfBooks.addElement(books.getTitle().trim());
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
        PublicationsView.setSize(new Dimension(275,209));
        PublicationsView.pack();
        PublicationsView.setVisible(true);
    }

    public void LoadingItensList(){

        try {
            System.out.println("Books Controller");
            BooksControllerInterface booksController = new BooksControllerImpl();

            System.out.println("Get all");
            for (Books books : booksController.getBooks()) {

                this.listOfBooks.addElement(books.getTitle().trim());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
