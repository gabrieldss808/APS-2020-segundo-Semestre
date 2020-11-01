package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Books;

import java.util.List;

public interface BooksControllerInterface {
    public List<Books> getBooks();

    public Books getBookByName(String name);

    public boolean addBook(Books books);

    public boolean updateBook(Books books);

    public boolean deleteBook(Books books);
}
