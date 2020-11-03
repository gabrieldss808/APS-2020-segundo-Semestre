package com.aps.cc.unip.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicationsView {

    private JPanel PublicationsViewMain;
    private JTextField SearchInput;
    private JButton BtnSearchNow;
    private JList PublicationsList;
    private JTextField InputIdToView;
    private JButton btnVisualizar;

    public PublicationsView() {
        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

}
