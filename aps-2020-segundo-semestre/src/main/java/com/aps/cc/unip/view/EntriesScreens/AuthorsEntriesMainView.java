package com.aps.cc.unip.view.EntriesScreens;

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
    private JTextField textField1;
    private JButton btSearchAuthors;
    private JList list1;
    private JPanel FormPanelContainer;
    private JTextField NameAuthorInput;
    private JTextField SurnameAuthorInput;
    private JButton btOkFormAuthor;
    private JLabel lbTaskDescripition;

    public AuthorsEntriesMainView() {
        btShowAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPanelContainer.setVisible(true);
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
}
