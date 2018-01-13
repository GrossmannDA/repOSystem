package com.company.controller;

import java.io.IOException;

public interface Action {

    public void create(Object object) throws IOException;
    public void update() throws IOException, ClassNotFoundException;
    public void delete(Object object);
}
