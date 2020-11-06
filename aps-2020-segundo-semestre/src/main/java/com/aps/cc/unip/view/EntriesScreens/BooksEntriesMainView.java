package com.aps.cc.unip.view.EntriesScreens;

import javax.swing.*;
import java.awt.*;

public class BooksEntriesMainView {
    private JPanel BooksEntriesMainView;

    public void ShowView() {

        JFrame BooksEntriesView = new JFrame("Cadastro de Livros");
        BooksEntriesView.setContentPane(new BooksEntriesMainView().BooksEntriesMainView);
        BooksEntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        BooksEntriesView.setLocationRelativeTo(null);
        BooksEntriesView.pack();
        BooksEntriesView.setVisible(true);
    }
}
