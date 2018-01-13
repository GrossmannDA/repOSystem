package com.company;

import com.company.controller.Check;
import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.model.Card;
import com.company.view.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       /*
     Menu menu = new Menu();
     File file = new File("SerTest.bin");
     Check check = new Check();
     if(check.isBoardAvalable(board) == false){
     System.out.println("Any board doesnt exist!");
     }else {
     System.out.println("Folowing boards are avalible: " );
     TODO }
     */

        View view = new View();

       /* Board board = new Board("Board 1");

        Boardlist boardlist = new Boardlist("List 1 in Board 1");
        board.addBoardlist(boardlist);

        Card card = new Card("Card 1 in List 1");
        card.setCardDescription("ToDo");

        boardlist.addListCard(card);

        System.out.println(board.toString());
        System.out.println(card.toString());*/
    }
    // Konsole eingaben realisieren
    // anzeigen alle listen die vergügbar sind
    // Menü erstellen
}
