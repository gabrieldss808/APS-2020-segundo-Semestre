package com.aps.cc.unip.view;

import javax.swing.*;
import java.awt.*;

public class MainViewOfEntries {
    private JButton BtBooksEntries;
    private JPanel MainViewOfEntries;
    private JButton BtPublisherEntries;
    private JButton BtAuthorsEntries;

    public void ShowView() {

        JFrame EntriesView = new JFrame("Livrária Amazonas");
        EntriesView.setContentPane(new MainViewOfEntries().MainViewOfEntries);
        EntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        EntriesView.setLocationRelativeTo(null);
        EntriesView.setSize(new Dimension(275,209));
        EntriesView.pack();
        EntriesView.setVisible(true);
    }
}
