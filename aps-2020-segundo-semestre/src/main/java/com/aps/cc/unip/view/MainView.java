package com.aps.cc.unip.view;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private JButton visualizarPublicacoesButton;
    private JButton gerenciarPublicacoesButton;
    private JPanel ViewMain;
    private JLabel MainLabel;

    public static void main(String[] args) {
        JFrame ViewPrincipal = new JFrame("Amazonas APP");
        ViewPrincipal.setContentPane(new MainView().ViewMain);
        ViewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ViewPrincipal.setLocationRelativeTo(null);
        ViewPrincipal.setSize(new Dimension(500,500));
        ViewPrincipal.pack();
        ViewPrincipal.setVisible(true);
    }
}
