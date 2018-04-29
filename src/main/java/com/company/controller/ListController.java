package com.company.controller;

import com.company.service.ListService;
import com.company.view.BoardListView;
import java.io.IOException;
import java.util.Optional;


public class ListController {

  ListService listService = new ListService();
  BoardListView listView;

  public ListController() throws IOException, ClassNotFoundException {
  }

  public Optional<BoardListView> createList(String listName, int listDestination) {
    listView = new BoardListView(listService.createBoardList(listName, listDestination));
    return Optional.ofNullable(listView);
  }
}
