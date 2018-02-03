package com.company.presentation.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

  private String input;

  public String getInput() throws IOException {

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    return this.input = keyboard.readLine();
  }

  public String queryBoardName() throws IOException {
    System.out.println("Please input the name of the board");
    return getInput();
  }

  public String queryNameOfTheList() throws IOException {
    System.out.println("Please input the name of the List");

    return getInput();
  }

}
