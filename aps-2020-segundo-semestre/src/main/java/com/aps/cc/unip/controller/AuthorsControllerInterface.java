package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Authors;
import java.util.List;

public interface AuthorsControllerInterface {

    public List<Authors> getAuthors() throws Exception;

    public Authors getAuthorByName(String name);

    public boolean addAuthor(Authors author);

    public boolean updateAuthor(Authors author);

    public boolean deleteAuthor(Authors author);
}
