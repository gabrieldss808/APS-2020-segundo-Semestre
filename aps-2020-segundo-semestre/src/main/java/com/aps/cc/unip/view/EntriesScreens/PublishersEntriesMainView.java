package com.aps.cc.unip.view.EntriesScreens;

import javax.swing.*;
import java.awt.*;

public class PublishersEntriesMainView {
    private JPanel PublishersEntriesMainView;
    private JTextField textField1;
    private JList PublishersList;
    private JButton btSearchPublishers;
    private JButton btShowPublisher;
    private JButton btAddPublisher;
    private JButton btAlterPublisher;
    private JButton btDeletePublisher;
    private JPanel FormPanelContainer;
    private JTextField NamePublisherInput;
    private JTextField SitePublisherInput;
    private JButton btOkFormPublisher;
    private JLabel lbTaskDescripition;
    private JButton btCancelTask;

    public void ShowView() {

        JFrame PublishersEntriesView = new JFrame("Cadastro de Publishers");
        PublishersEntriesView.setContentPane(new PublishersEntriesMainView().PublishersEntriesMainView);
        PublishersEntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        PublishersEntriesView.setLocationRelativeTo(null);
        PublishersEntriesView.setSize(new Dimension(275,209));
        PublishersEntriesView.pack();
        PublishersEntriesView.setVisible(true);
    }
}