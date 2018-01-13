package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {

    private String board_name;

    private List<Boardlist> boardlist= new ArrayList<>();

    public Board(String board_name) {
        this.board_name = board_name;
    }

    public void addBoardlist(Boardlist board_list) {

        boardlist.add(board_list);
    }
    public List<Boardlist> getBoardlist() {
        return boardlist;
    }
    @Override
    public String toString() {
        return "Board{" +
                "board_name='" + board_name + '\'' +

                '}';
    }
}
