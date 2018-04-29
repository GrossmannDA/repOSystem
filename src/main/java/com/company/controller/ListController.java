package com.company.controller;

import com.company.service.ListService;
import com.company.view.BoardListView;
import java.util.Optional;

public class ListController {

  private ListService listService = new ListService();
  private BoardListView listView;

  public Optional<BoardListView> createList(String listName, int listDestination) {
    listView = new BoardListView(listService.createBoardList(listName, listDestination));
    return Optional.of(listView);
  }
}
