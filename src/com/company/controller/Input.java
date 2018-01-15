package com.company.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private String input;

    public String getInput() throws IOException {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        return this.input = keyboard.readLine();
    }
}
