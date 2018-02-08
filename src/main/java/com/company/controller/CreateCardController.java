package com.company.controller;

import com.company.model.Card;
import com.company.model.Screen;

public class CreateCardController {

    private Screen screen;

    /**
     * @return
     */
    public Card createCard(String cardName, String boardlistName) {
        Card card = new Card(cardName);
        // todo: screen.getBoardlistByName(boaardlistName).addCard(card);
    }
}
