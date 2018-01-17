package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Boardlist implements Serializable {
    private String boardlistName;

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


}
