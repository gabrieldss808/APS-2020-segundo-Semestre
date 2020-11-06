package com.aps.cc.unip.view.EntriesScreens;

import com.aps.cc.unip.controller.AuthorsControllerImpl;
import com.aps.cc.unip.controller.AuthorsControllerInterface;
import com.aps.cc.unip.controller.BooksControllerImpl;
import com.aps.cc.unip.controller.BooksControllerInterface;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.view.MainViewOfEntries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorsEntriesMainView {
    private JPanel AuthorsEntriesMainView;
    private JButton btAddAuthor;
    private JButton btAlterAuthor;
    private JButton btShowAuthor;
    private JButton btDeleteAuthor;
    private JTextField SearchAuthor;
    private JButton btSearchAuthors;
    private JList AuthorsList;
    private JPanel FormPanelContainer;
    private JTextField NameAuthorInput;
    private JTextField SurnameAuthorInput;
    private JButton btOkFormAuthor;
    private JLabel lbTaskDescripition;
    private DefaultListModel listOfAuthors;

    public AuthorsEntriesMainView() {

        this.listOfAuthors = new DefaultListModel();

        this.LoadingItensList();

        this.AuthorsList.setModel(this.listOfAuthors);

        btShowAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPanelContainer.setVisible(true);
            }
        });
        btSearchAuthors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listOfAuthors.clear();

                try {

                    AuthorsControllerInterface authorsController = new AuthorsControllerImpl();

                    for (Authors authors : authorsController.getAuthorsPesq(SearchAuthor.getText().trim())) {

                        listOfAuthors.addElement(authors.getName().trim());
                    }
                }catch (Exception error){
                    error.printStackTrace();
                }

            }
        });
    }

    public void ShowView() {

        JFrame AuthorsEntriesView = new JFrame("Cadastro de Autores");
        AuthorsEntriesView.setContentPane(new AuthorsEntriesMainView().AuthorsEntriesMainView);
        AuthorsEntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        AuthorsEntriesView.setLocationRelativeTo(null);
        AuthorsEntriesView.setSize(new Dimension(275,209));
        AuthorsEntriesView.pack();
        AuthorsEntriesView.setVisible(true);
    }

    public void LoadingItensList(){

        try {
            AuthorsControllerInterface AuthorsController = new AuthorsControllerImpl();

            System.out.println("Get all");
            for (Authors authors : AuthorsController.getAuthors()) {

                this.listOfAuthors.addElement(authors.getName().trim());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
