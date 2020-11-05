package com.aps.cc.unip.view;

import com.aps.cc.unip.view.EntriesScreens.AuthorsEntriesMainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewOfEntries {
    private JButton BtBooksEntries;
    private JPanel MainViewOfEntries;
    private JButton BtPublisherEntries;
    private JButton BtAuthorsEntries;

    public MainViewOfEntries() {
        BtAuthorsEntries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AuthorsEntriesMainView().ShowView();
            }
        });
    }

    public void ShowView() {

        JFrame EntriesView = new JFrame("Cadastros");
        EntriesView.setContentPane(new MainViewOfEntries().MainViewOfEntries);
        EntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        EntriesView.setLocationRelativeTo(null);
        EntriesView.setSize(new Dimension(275,209));
        EntriesView.pack();
        EntriesView.setVisible(true);
    }
}
