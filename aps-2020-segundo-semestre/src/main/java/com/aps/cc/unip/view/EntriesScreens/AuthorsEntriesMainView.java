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
    private JButton btCancelTask;
    private DefaultListModel listOfAuthors;
    private String editionType;
    private String SelectedValue;

    public AuthorsEntriesMainView() {

        this.listOfAuthors = new DefaultListModel();

        this.LoadingItensList();

        this.AuthorsList.setModel(this.listOfAuthors);

        btShowAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String AuthorDataText;

                try{
                    SelectedValue = AuthorsList.getSelectedValue().toString();

                    AuthorsControllerInterface authorsController = new AuthorsControllerImpl();
                    Authors author = authorsController.getAuthorByName(SelectedValue);

                    AuthorDataText = "Dados do autor:\n";
                    AuthorDataText += "Nome Completo : " + author.getName().trim() + " " + author.getFname().trim() + "\n";
                    AuthorDataText += "Id do Autor: " + author.getAuthor_id() + "\n";
                }
                catch (Exception notSelectedItem){

                    AuthorDataText = "Selecione um registro para visualizar";
                }

                JOptionPane.showMessageDialog(null,AuthorDataText);

            }
        });
        btSearchAuthors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listOfAuthors.clear();
                String textToSearch;

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
        btAlterAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    SelectedValue = AuthorsList.getSelectedValue().toString();

                    FormPanelContainer.setVisible(true);
                    editionType = "Alter";

                    AuthorsControllerInterface authorsController = new AuthorsControllerImpl();
                    Authors author = authorsController.getAuthorByName(SelectedValue);

                    NameAuthorInput.setText(author.getName().trim());
                    SurnameAuthorInput.setText(author.getFname().trim());

                    lbTaskDescripition.setText("Confirmar Alteração?");
                }
                catch (Exception notSelectedItem){

                    JOptionPane.showMessageDialog(null, "Selecione um registro para alterar");
                }

            }
        });
        btOkFormAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AuthorsControllerInterface authorsController = new AuthorsControllerImpl();

                if(editionType == "Alter"){

                    Authors author = authorsController.getAuthorByName(SelectedValue);

                    author.setName(NameAuthorInput.getText());
                    author.setFname(SurnameAuthorInput.getText());

                    authorsController.updateAuthor(author);
                }

                if(editionType == "Add"){

                    if(NameAuthorInput.getText() != "" && SurnameAuthorInput.getText() != ""){

                        Authors author = new Authors();

                        author.setName(NameAuthorInput.getText());
                        author.setFname(SurnameAuthorInput.getText());

                        authorsController.addAuthor(author);
                    }

                }

                if(editionType == "Delete"){

                    Authors author = authorsController.getAuthorByName(SelectedValue);

                    authorsController.deleteAuthor(author);

                    NameAuthorInput.setEnabled(true);
                    SurnameAuthorInput.setEnabled(true);
                }

                FormPanelContainer.setVisible(false);

                listOfAuthors.clear();
                LoadingItensList();

                NameAuthorInput.setText("");
                SurnameAuthorInput.setText("");

            }
        });
        btAddAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FormPanelContainer.setVisible(true);
                editionType = "Add";

                lbTaskDescripition.setText("Confirmar Inclusão?");
            }
        });
        btDeleteAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    SelectedValue = AuthorsList.getSelectedValue().toString();

                    FormPanelContainer.setVisible(true);
                    editionType = "Delete";

                    AuthorsControllerInterface authorsController = new AuthorsControllerImpl();
                    Authors author = authorsController.getAuthorByName(SelectedValue);

                    NameAuthorInput.setText(author.getName().trim());
                    SurnameAuthorInput.setText(author.getFname().trim());

                    NameAuthorInput.setEnabled(false);
                    SurnameAuthorInput.setEnabled(false);

                    lbTaskDescripition.setText("Confirmar Exclusão?");
                }
                catch (Exception notSelectedItem){

                    JOptionPane.showMessageDialog(null, "Selecione um registro para alterar");
                }
            }
        });
        btCancelTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPanelContainer.setVisible(false);

                listOfAuthors.clear();
                LoadingItensList();

                NameAuthorInput.setText("");
                SurnameAuthorInput.setText("");
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
