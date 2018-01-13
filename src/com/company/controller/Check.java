package com.company.controller;

import com.company.model.Board;

import java.util.List;

public class Check {

    public boolean isInputStringValid(String input){
        boolean isValid = false;
        if(input.matches("^[0-9]*$")) {
            isValid = true;
        }
        return isValid;
    }

    public boolean isBoardAvalable(List <Board> allboardlist){
        boolean isAvalible = false;

        if(!allboardlist.isEmpty()){
            isAvalible = true;
        }

        return isAvalible;
    }

    public boolean isListAvalable(List <Board> allboardlist){
        boolean isListAvalible = false;

        if(!allboardlist.isEmpty()){
            isListAvalible = true;
        }

        return isListAvalible;
    }
}
