package com.aps.cc.unip.view.EntriesScreens;

import com.aps.cc.unip.controller.*;
import com.aps.cc.unip.model.Authors;
import com.aps.cc.unip.model.Books;
import com.aps.cc.unip.model.BooksAuthors;
import com.aps.cc.unip.model.Publishers;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class BooksEntriesMainView {
                    private JPanel BooksEntriesMainView;
                    private JTextField SearchBooks;
                    private JList BooksList;
                    private JButton btSerachBooks;
                    private JButton btShowBooks;
                    private JButton btAlterBooks;
                    private JButton btAddBooks;
                    private JButton btDeleteBooks;
                    private JPanel FormPanelContainer;
                    private JTextField TitleBooksInput;
                    private JTextField ISBNBooksInput;
                    private JFormattedTextField PriceBooksInput;
                    private JComboBox AutorBooksInput;
                    private JComboBox PublisherBooksInput;
                    private JButton btOkFormBook;
                    private JButton btCancelTask;
                    private JLabel lbTaskDescripition;
                    private DefaultListModel listOfBooks;
                    private String SelectedValue;
                    private String editionType;


    public BooksEntriesMainView() {

        this.listOfBooks = new DefaultListModel();
        this.LoadingItensList();
        this.BooksList.setModel(this.listOfBooks);

        PriceBooksInput.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));

        btSerachBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listOfBooks.clear();

                try {

                    BooksControllerInterface booksController = new BooksControllerImpl();

                    for (Books books : booksController.getBooksPesq(SearchBooks.getText().trim())) {

                        listOfBooks.addElement(books.getTitle().trim());
                    }
                } catch (Exception error) {
                    error.printStackTrace();
                }

            }
        });
        btShowBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String BooksDataText;

                try {
                    SelectedValue = BooksList.getSelectedValue().toString();

                    BooksControllerInterface booksController = new BooksControllerImpl();
                    Books book = booksController.getBookByName(SelectedValue);

                    BooksDataText = "Dados da Livro:\n";
                    BooksDataText += "Titulo: " + book.getTitle().trim() + "\n";
                    BooksDataText += "Codigo ISBN: " + book.getIsbn().trim() + "\n";
                    BooksDataText += "Preço: " + book.getPrice() + "\n";
                } catch (Exception notSelectedItem) {

                    BooksDataText = "Selecione um registro para visualizar";
                }

                JOptionPane.showMessageDialog(null, BooksDataText);
            }
        });
        btCancelTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormPanelContainer.setVisible(false);

                listOfBooks.clear();
                LoadingItensList();

                TitleBooksInput.setText("");
                ISBNBooksInput.setText("");
                PriceBooksInput.setText("");
                AutorBooksInput.removeAllItems();
                PublisherBooksInput.removeAllItems();
            }
        });
        btAlterBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    SelectedValue = BooksList.getSelectedValue().toString();

                    FormPanelContainer.setVisible(true);
                    editionType = "Alter";

                    BooksControllerInterface booksController = new BooksControllerImpl();
                    Books BookObj = booksController.getBookByName(SelectedValue);

                    TitleBooksInput.setText(BookObj.getTitle().trim());
                    ISBNBooksInput.setText(BookObj.getIsbn().trim());
                    ISBNBooksInput.setEnabled(false);
                    PriceBooksInput.setText(BookObj.getPrice().toString());

                    //Pega o nome de todos os autores e deixa selecionado o Autor do livro.
                    AutorBooksInput.removeAllItems();
                    AuthorsControllerInterface AuthorsController = new AuthorsControllerImpl();
                    for (Authors authors : AuthorsController.getAuthors()) {

                        AutorBooksInput.addItem(authors.getName().trim());
                    }
                    BooksAuthorsControllerInterface booksAuthorsController = new BooksAuthorsControllerImpl();
                    BooksAuthors BooksAuthorsObj = booksAuthorsController.getBookAuthorByIsbn(BookObj);
                    AutorBooksInput.setSelectedItem(BooksAuthorsObj.getAuthor_id().getName().trim());

                    PublisherBooksInput.removeAllItems();
                    PublishersControllerInterface publishersController = new PublishersControllerImpl();
                    for (Publishers publishers : publishersController.getPublishers()) {

                        PublisherBooksInput.addItem(publishers.getName().trim());
                    }
                    PublisherBooksInput.setSelectedItem(BookObj.getPublisher_id().getName().trim());
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Selecione um Livro para alterar");
                }
            }
        });
        btOkFormBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BooksControllerInterface booksController = new BooksControllerImpl();
                PublishersControllerInterface publishersController = new PublishersControllerImpl();
                BooksAuthorsControllerInterface booksAuthorsController = new BooksAuthorsControllerImpl();

                if (editionType == "Alter") {

                    Books bookObj = booksController.getBookByName(SelectedValue);

                    bookObj.setTitle(TitleBooksInput.getText().trim());
                    bookObj.setIsbn(ISBNBooksInput.getText().trim());
                    bookObj.setPrice(NormalizedString(PriceBooksInput.getText()));

                    Publishers publishers = publishersController.getPublisherByName(PublisherBooksInput.getSelectedItem().toString());

                    bookObj.setPublisher_id(publishers);
                    booksController.updateBook(bookObj);

                    BooksAuthors booksAuthors = booksAuthorsController.getBookAuthorByIsbn(bookObj);

                    AuthorsControllerInterface AuthorsController = new AuthorsControllerImpl();
                    Authors authors = AuthorsController.getAuthorByName(AutorBooksInput.getSelectedItem().toString());

                    booksAuthors.setAuthor_id(authors);
                    booksAuthorsController.updateBookAuthor(booksAuthors);
                }
                if(editionType == "Add"){

                    if(TitleBooksInput.getText() != "" && ISBNBooksInput.getText() != "" && AutorBooksInput.getSelectedItem().toString() != "" && PublisherBooksInput.getSelectedItem().toString() != "" && PriceBooksInput.getText() != ""){

                        Books bookObj = new Books();

                        bookObj.setTitle(TitleBooksInput.getText().trim());
                        bookObj.setIsbn(ISBNBooksInput.getText().trim());
                        bookObj.setPrice(NormalizedString(PriceBooksInput.getText()));

                        Publishers publishers = publishersController.getPublisherByName(PublisherBooksInput.getSelectedItem().toString());

                        bookObj.setPublisher_id(publishers);
                        booksController.addBook(bookObj);

                        BooksAuthors booksAuthors = new BooksAuthors();

                        AuthorsControllerInterface AuthorsController = new AuthorsControllerImpl();
                        Authors authors = AuthorsController.getAuthorByName(AutorBooksInput.getSelectedItem().toString());

                        booksAuthors.setAuthor_id(authors);
                        booksAuthors.setIsbn(bookObj);

                        booksAuthorsController.addBooksAuthor(booksAuthors);

                    }
                }

                if(editionType == "Delete"){

                    Books bookObj = booksController.getBookByName(SelectedValue);

                    BooksAuthors booksAuthor = booksAuthorsController.getBookAuthorByIsbn(bookObj);

                    booksAuthorsController.deleteBookAuthor(booksAuthor);

                    booksController.deleteBook(bookObj);
                }

                FormPanelContainer.setVisible(false);

                TitleBooksInput.setText("");
                ISBNBooksInput.setText("");
                PriceBooksInput.setText("");
                AutorBooksInput.removeAllItems();
                PublisherBooksInput.removeAllItems();
                TitleBooksInput.setEnabled(true);
                ISBNBooksInput.setEnabled(true);
                PriceBooksInput.setEnabled(true);
                AutorBooksInput.setEnabled(true);
                PublisherBooksInput.setEnabled(true);

                listOfBooks.clear();
                LoadingItensList();

            }
        });
        btAddBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                FormPanelContainer.setVisible(true);
                editionType = "Add";

                lbTaskDescripition.setText("Confirmar Inclusão?");

                //Pega o nome de todos os autores e deixa selecionado o Autor do livro.
                AutorBooksInput.removeAllItems();
                AuthorsControllerInterface AuthorsController = new AuthorsControllerImpl();
                for (Authors authors : AuthorsController.getAuthors()) {

                    AutorBooksInput.addItem(authors.getName().trim());
                }

                PublisherBooksInput.removeAllItems();
                PublishersControllerInterface publishersController = new PublishersControllerImpl();
                for (Publishers publishers : publishersController.getPublishers()) {

                    PublisherBooksInput.addItem(publishers.getName().trim());
                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Selecione um Livro para alterar");
            }

            }
        });
        btDeleteBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    SelectedValue = BooksList.getSelectedValue().toString();

                    FormPanelContainer.setVisible(true);
                    editionType = "Delete";

                    BooksControllerInterface booksController = new BooksControllerImpl();
                    Books BookObj = booksController.getBookByName(SelectedValue);

                    TitleBooksInput.setEnabled(false);
                    ISBNBooksInput.setEnabled(false);
                    PriceBooksInput.setEnabled(false);
                    AutorBooksInput.setEnabled(false);
                    PublisherBooksInput.setEnabled(false);

                    TitleBooksInput.setText(BookObj.getTitle().trim());
                    ISBNBooksInput.setText(BookObj.getIsbn().trim());
                    ISBNBooksInput.setEnabled(false);
                    PriceBooksInput.setText(BookObj.getPrice().toString());

                    //Pega o nome de todos os autores e deixa selecionado o Autor do livro.
                    AutorBooksInput.removeAllItems();
                    AuthorsControllerInterface AuthorsController = new AuthorsControllerImpl();
                    for (Authors authors : AuthorsController.getAuthors()) {

                        AutorBooksInput.addItem(authors.getName().trim());
                    }
                    BooksAuthorsControllerInterface booksAuthorsController = new BooksAuthorsControllerImpl();
                    BooksAuthors BooksAuthorsObj = booksAuthorsController.getBookAuthorByIsbn(BookObj);
                    AutorBooksInput.setSelectedItem(BooksAuthorsObj.getAuthor_id().getName().trim());

                    PublisherBooksInput.removeAllItems();
                    PublishersControllerInterface publishersController = new PublishersControllerImpl();
                    for (Publishers publishers : publishersController.getPublishers()) {

                        PublisherBooksInput.addItem(publishers.getName().trim());
                    }
                    PublisherBooksInput.setSelectedItem(BookObj.getPublisher_id().getName().trim());

                    lbTaskDescripition.setText("Confirmar Exclusão?");
                }
                catch (Exception notSelectedItem){

                    JOptionPane.showMessageDialog(null, "Selecione um registro para alterar");
                }
            }
        });
        ISBNBooksInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int k = e.getKeyChar();
                if (ISBNBooksInput.getText().length() <= 13 - 1) {
                    //deixe passar
                } else {
                    e.setKeyChar((char) KeyEvent.VK_CLEAR);
                }
            }
        });
    }

    public void ShowView() {

        JFrame BooksEntriesView = new JFrame("Cadastro de Livros");
        BooksEntriesView.setContentPane(new BooksEntriesMainView().BooksEntriesMainView);
        BooksEntriesView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        BooksEntriesView.setLocationRelativeTo(null);
        BooksEntriesView.pack();
        BooksEntriesView.setVisible(true);
    }

    public float NormalizedString(String stringToNormalized){

        float returnValue;

        returnValue = Float.parseFloat(stringToNormalized.replace(".", "").replace(",","."));

        return returnValue;

    }

    public void LoadingItensList() {

        try {
            BooksControllerInterface booksController = new BooksControllerImpl();

            for (Books books : booksController.getBooks()) {

                this.listOfBooks.addElement(books.getTitle().trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
