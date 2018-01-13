package com.company.view;

import com.company.controller.Action;
import com.company.controller.Check;
import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.model.Card;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class View implements Action {

    private String input;
    private Menu menu;
    private File file;
    private Check check;

    private Board board;
    private Card card;
    private List<Board> allBoards;

    public View() throws IOException, ClassNotFoundException {

        file = new File("SerTest.bin");
        menu = new Menu();
        check = new Check();
        allBoards = new ArrayList<>();

        while (!String.valueOf(Menupoints.END.getAction()).equals(input)) {

            input = getInput();
            validateUserInput(input);
        }

        System.out.println("Programm was aboarded");
    }

    public String getInput() throws IOException {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        return this.input = keyboard.readLine();
    }

    @Override
    public void create(Object object) throws IOException {
        menu.serializeObjeckt(object, file);
    }

    public void update() throws IOException, ClassNotFoundException {

        Board board = (Board) menu.deserializeObjeckt(file);
        // board.addBoardlist(boardlist);
        System.out.println(board.toString());
    }

    public void delete(Object object) {

    }

    public void validateUserInput(String input) throws IOException, ClassNotFoundException {

        while (check.isInputStringValid(input) == false) {

            System.out.println("Your input is not valid! Please repeat");
        }

        if (String.valueOf(Menupoints.CREATE_NEW_BOARD.getAction()).equals(input)) {

            System.out.println("Please input the name of the board");
            String boardname = getInput();
            board = new Board(boardname);

            //   create(new Board(getInput()));
            System.out.println("Board was created  " + board.toString());

            allBoards.add(board);
            // update();
        }

        if (String.valueOf(Menupoints.CREATE_NEW_LIST.getAction()).equals(input)) {

            if (check.isBoardAvalable(allBoards) == true) {

                System.out.println("Please input the name of the List");

                String boardlistname = getInput();
                Boardlist boarl = new Boardlist(boardlistname);

                System.out.println("To wich Board do you want add this List?: ");
                int i = 0;

                for (Board board_1 : allBoards) {

                    System.out.println("Choose " + (char) i + " " + board_1.toString());
                    i++;
                }
                i = Integer.valueOf(getInput());

                if (i <= allBoards.size()) {
                    allBoards.get(i).addBoardlist(boarl);

                    System.out.println("The List was assingt to Board: " + allBoards.get(i).toString() + " " + boarl.toString());
                }
                //create(new Boardlist(input));
                //   update();

            } else {
                System.out.println("There are no boards avalable. Please create the board befor list");
            }

        }
        if (String.valueOf(Menupoints.CREATE_NEW_CARD.getAction()).equals(input)) {

            System.out.println("Please choose the boardlist from the board");

            for(Board board: allBoards){
                System.out.println(board.toString());
                for(Boardlist boardlist: board.getBoardlist()){
                    System.out.println(  boardlist.toString());
                }
               // System.out.println(  allBoards.get(1).getBoardlist().get(0).toString());

            }
            System.out.println("Please input the name of the Card");
            String cardname = getInput();

            card = new Card(cardname);

            //create(new Boardlist(input));
            //   update();
        }
    }

}
