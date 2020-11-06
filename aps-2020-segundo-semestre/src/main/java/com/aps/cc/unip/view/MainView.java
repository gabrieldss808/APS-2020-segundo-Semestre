package com.aps.cc.unip.view;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private JButton visualizarLivrosButton;
    private JButton cadastrosButton;
    private JPanel ViewMain;

    public MainView() {
        visualizarLivrosButton.addActionListener(e -> new PublicationsView().ShowView());
        cadastrosButton.addActionListener(e -> new MainViewOfEntries().ShowView());
    }

    public static void main(String[] args) {
        JFrame ViewPrincipal = new JFrame("Livrária Amazonas");
        ViewPrincipal.setContentPane(new MainView().ViewMain);
        ViewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewPrincipal.setLocationRelativeTo(null);
        ViewPrincipal.setSize(new Dimension(438,500));
        ViewPrincipal.pack();
        ViewPrincipal.setVisible(true);
    }
}
