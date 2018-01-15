package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Boardlist implements Serializable {
    private String boardlistName;
    private int assignt_to_board;

    private List<Card> listCard = new ArrayList<>();

    public Boardlist(String boardlistName) {
        this.boardlistName = boardlistName;
    }

    public List<Card> getListCard() {
        return listCard;
    }

    public void addListCard(Card card) {
        listCard.add(card);
    }

    public String getBoardlistName() {
        return boardlistName;
    }

    public void setBoardlistName(String boardlistName) {
        this.boardlistName = boardlistName;
    }

    @Override
    public String toString() {
        return "Boardlist{" +
                "boardlistName='" + boardlistName + '\'' +
                '}';
    }

    public int getAssignt_to_board() {
        return assignt_to_board;
    }

    public void setAssignt_to_board(int assignt_to_board) {
        this.assignt_to_board = assignt_to_board;
    }
}
