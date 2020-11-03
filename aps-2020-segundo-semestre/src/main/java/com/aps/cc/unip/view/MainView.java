package com.aps.cc.unip.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private JButton visualizarPublicacoesButton;
    private JButton gerenciarPublicacoesButton;
    private JPanel ViewMain;

    public MainView() {
        visualizarPublicacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PublicationsView().ShowView();
            }
        });
    }

    public static void main(String[] args) {
        JFrame ViewPrincipal = new JFrame("Livrária Amazonas");
        ViewPrincipal.setContentPane(new MainView().ViewMain);
        ViewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewPrincipal.setLocationRelativeTo(null);
        ViewPrincipal.setSize(new Dimension(500,500));
        ViewPrincipal.pack();
        ViewPrincipal.setVisible(true);
    }
}
