package com.company.controller;

import com.company.service.ListService;
import com.company.view.BoardListView;
import java.io.IOException;


public class ListController {
ListService listService = new ListService();
BoardListView listView;
  public BoardListView createList(String listName, int listDestination)
      throws IOException, ClassNotFoundException {

    listView=listService.createList(listName,listDestination);

    return listView;
  }
}
