package com.company.view;
// https://github.com/GrossmannDA/repOSystem

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
    private int board_pos;
    private int list_pos;
    private String klammer_auf = "[";
    private String klammer_zu = "]";
    private String minus = "-";


    public View() throws IOException, ClassNotFoundException {

        file = new File("SerTest.bin");
        menu = new Menu();
        check = new Check();
        allBoards = new ArrayList<>();

        if (!check.fileIsEmpty(file)) {
            allBoards = (List) menu.deserializeObjeckt(file);
        }

        while (!String.valueOf(Menupoints.END.getAction()).equals(input)) {

            input = getInput();
            validateUserInput(input);
        }

        if (allBoards != null) {
            menu.serializeObjeckt(allBoards, file);
            System.out.println("Boardes are saved");
        }

        System.out.println("Programm was aboarded");
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
        String str_menu = klammer_auf + "1" + minus + "3" + klammer_zu;

        if (!check.isInputStringValid(input, str_menu)) {

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
                String size = String.valueOf(allBoards.size()-1);
                String regex_size = klammer_auf + "0" + minus + size + klammer_zu;

                for (Board board_1 : allBoards) {

                    System.out.println("Choose " + i + " " + board_1.toString());
                    i++;
                }
                board_pos = Integer.valueOf(getInput());

                if (check.isInputStringValid(String.valueOf(board_pos), regex_size)) {

                    boarl.setAssignt_to_board(board_pos);

                    if (boarl.getAssignt_to_board() <= allBoards.size()) {

                        allBoards.get(board_pos).addBoardlist(boarl);

                        System.out.println("The List was assingt to Board: " + allBoards.get(board_pos).toString() + " " + boarl.toString());
                    }
                } else {
                    System.out.println("Wrong Input. Please repeat.");
                }

                //create(new Boardlist(input));
                //   update();

            } else {
                System.out.println("There are no boards avalable. Please create the board befor list");
            }

        }
        if (String.valueOf(Menupoints.CREATE_NEW_CARD.getAction()).equals(input)) {
            int count = 0;
           ArrayList <Boolean> value = new ArrayList<>();

            System.out.println("Please choose the boardlist from the board");

            for (Board board : allBoards) {
                System.out.println(board.toString());
                if(check.isListAvalable(board.getBoardlist())){
                    value.add(check.isListAvalable(board.getBoardlist()));
                }
                for (Boardlist boardlist : board.getBoardlist()) {

                    System.out.println("Input " + count + " to choose " + boardlist.toString());
                    if (boardlist.getListCard() != null) {

                        for (Card card : boardlist.getListCard()) {
                            System.out.println(" " + card.toString());
                        }
                    }

                    boardlist.setAssignt_to_board(allBoards.indexOf(board));
                    count++;
                }
                // System.out.println(  allBoards.get(1).getBoardlist().get(0).toString());
            }

            if(value.contains(true) ) {
                list_pos = Integer.valueOf(getInput());

                System.out.println("Please input the name of the Card");
                String cardname = getInput();

                card = new Card(cardname);
                card.setAssignt_to_list(list_pos);


                allBoards.get(board_pos).getBoardlist().get(card.getAssignt_to_list()).addListCard(card);

                System.out.println("Card " + card.toString() + " was added to " + allBoards.get(board_pos).getBoardlist().get(card.getAssignt_to_list()));
            }else{
                System.out.println("No List exists. Please create the List befor Card");
            }
        }
    }

    public String getInput() throws IOException {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        return this.input = keyboard.readLine();
    }

}
