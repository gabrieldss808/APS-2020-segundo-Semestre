package com.aps.cc.unip.view;

import javax.swing.*;
import java.awt.*;

public class PublicationsView {

    private JPanel PublicationsViewMain;
    private JTextField SearchInput;
    private JButton BtnSearchNow;
    private JList PublicationsList;
    private JTextField InputIdToView;
    private JButton btnVisualizar;

    public static void main(String[] args) {
        JFrame PublicationsView = new JFrame("Amazonas APP");
        PublicationsView.setContentPane(new PublicationsView().PublicationsViewMain);
        PublicationsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PublicationsView.setLocationRelativeTo(null);
        PublicationsView.setSize(new Dimension(275,300));
        PublicationsView.pack();
        PublicationsView.setVisible(true);
    }

}
