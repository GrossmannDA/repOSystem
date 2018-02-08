package com.company.controller;

import com.company.model.Boardlist;
import com.company.model.Card;

public class CardService {

    // state: cardDAO -> SQL DB

    public Card createNewCard() {
        return new Card("default");
    }

    public void updateName(Card card, String newName) {
        card.setCardName(newName);
    }
}
