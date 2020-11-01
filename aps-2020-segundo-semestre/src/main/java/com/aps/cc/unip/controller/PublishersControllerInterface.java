package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Publishers;

import java.util.List;

public interface PublishersControllerInterface {
    public List<Publishers> getPublishers();

    public Publishers getPublisherByName(String name);

    public boolean addPublisher(Publishers publishers);

    public boolean updatePublisher(Publishers publishers);

    public boolean deletePublisher(Publishers publishers);
}
