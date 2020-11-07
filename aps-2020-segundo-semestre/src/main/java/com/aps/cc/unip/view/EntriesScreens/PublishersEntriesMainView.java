package com.aps.cc.unip.view.EntriesScreens;

import com.aps.cc.unip.controller.AuthorsControllerImpl;
import com.aps.cc.unip.controller.AuthorsControllerInterface;
import com.aps.cc.unip.controller.PublishersControllerImpl;
import com.aps.cc.unip.controller.PublishersControllerInterface;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Publishers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublishersEntriesMainView {
    private JPanel PublishersEntriesMainView;
    private JTextField SearchPublisher;
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
    private JLabel NomeEditora;
    private JLabel Site;
    private DefaultListModel listOfPublishers;
    private String SelectedValue;
    private String editionType;

    public PublishersEntriesMainView() {
        this.listOfPublishers = new DefaultListModel();

        this.LoadingItensList();

        this.PublishersList.setModel(this.listOfPublishers);

        btShowPublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String PublisherDataText;

                try{
                    SelectedValue = PublishersList.getSelectedValue().toString();

                    PublishersControllerInterface publishersController = new PublishersControllerImpl();
                    Publishers publisher = publishersController.getPublisherByName(SelectedValue);

                    PublisherDataText = "Dados da Editora:\n";
                    PublisherDataText += "Editora : " + publisher.getName().trim() + "\n";
                    PublisherDataText += "Site : " + publisher.getUrl().trim() + "\n";
                    PublisherDataText += "Id da Editora: " + publisher.getPublisher_id() + "\n";
                }
                catch (Exception notSelectedItem){

                    PublisherDataText = "Selecione um registro para visualizar";
                }

                JOptionPane.showMessageDialog(null,PublisherDataText);
            }
        });

        btSearchPublishers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listOfPublishers.clear();

                try {

                    PublishersControllerInterface publisherController = new PublishersControllerImpl();

                    for (Publishers publishers : publisherController.getPublishersPesq(SearchPublisher.getText().trim())) {

                        listOfPublishers.addElement(publishers.getName().trim());
                    }
                }catch (Exception error){
                    error.printStackTrace();
                }
            }
        });

        btAlterPublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SelectedValue = PublishersList.getSelectedValue().toString();

                    FormPanelContainer.setVisible(true);
                    editionType = "Alter";

                    PublishersControllerInterface publishersController = new PublishersControllerImpl();
                    Publishers publisher = publishersController.getPublisherByName(SelectedValue);

                    NamePublisherInput.setText(publisher.getName().trim());
                    SitePublisherInput.setText(publisher.getUrl().trim());

                    lbTaskDescripition.setText("Confirmar Alteração?");
                }
                catch (Exception notSelectedItem){

                    JOptionPane.showMessageDialog(null, "Selecione um registro para alterar");
                }
            }
        });

        btOkFormPublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PublishersControllerInterface publishersController = new PublishersControllerImpl();

                if(editionType == "Alter"){

                    Publishers publisher = publishersController.getPublisherByName(SelectedValue);

                    publisher.setName(NamePublisherInput.getText());
                    publisher.setUrl(SitePublisherInput.getText());

                    publishersController.updatePublisher(publisher);
                }

                if(editionType == "Add"){

                    if(NamePublisherInput.getText() != "" && SitePublisherInput.getText() != ""){

                        Publishers publisher = new Publishers();

                        publisher.setName(NamePublisherInput.getText());
                        publisher.setUrl(SitePublisherInput.getText());

                        publishersController.addPublisher(publisher);
                    }

                }

                if(editionType == "Delete"){

                    Publishers publisher = publishersController.getPublisherByName(SelectedValue);

                    publishersController.deletePublisher(publisher);

                    NamePublisherInput.setEnabled(true);
                    SitePublisherInput.setEnabled(true);
                }

                FormPanelContainer.setVisible(false);

                listOfPublishers.clear();
                LoadingItensList();

                NamePublisherInput.setText("");
                SitePublisherInput.setText("");

            }
        });

        btCancelTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPanelContainer.setVisible(false);

                listOfPublishers.clear();
                LoadingItensList();

                NamePublisherInput.setText("");
                SitePublisherInput.setText("");
            }
        });

        btAddPublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPanelContainer.setVisible(true);
                editionType = "Add";

                lbTaskDescripition.setText("Confirmar Inclusão?");
            }
        });

        btDeletePublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    SelectedValue = PublishersList.getSelectedValue().toString();

                    FormPanelContainer.setVisible(true);
                    editionType = "Delete";

                    PublishersControllerInterface publishersController = new PublishersControllerImpl();
                    Publishers publisher = publishersController.getPublisherByName(SelectedValue);

                    NamePublisherInput.setText(publisher.getName().trim());
                    SitePublisherInput.setText(publisher.getUrl().trim());

                    NamePublisherInput.setEnabled(false);
                    SitePublisherInput.setEnabled(false);

                    lbTaskDescripition.setText("Confirmar Exclusão?");
                }
                catch (Exception notSelectedItem){

                    JOptionPane.showMessageDialog(null, "Selecione um registro para alterar");
                }
            }
        });
    }


    public void ShowView() {

        JFrame PublishersEntriesView = new JFrame("Cadastro de Publishers");
        PublishersEntriesView.setContentPane(new PublishersEntriesMainView().PublishersEntriesMainView);
        PublishersEntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        PublishersEntriesView.setLocationRelativeTo(null);
        PublishersEntriesView.setSize(new Dimension(275, 209));
        PublishersEntriesView.pack();
        PublishersEntriesView.setVisible(true);
    }

    public void LoadingItensList() {

        try {
            PublishersControllerInterface PublishersController = new PublishersControllerImpl();
            System.out.println("Get all");
            for (Publishers publishers : PublishersController.getPublishers()) {
                this.listOfPublishers.addElement(publishers.getName().trim());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}