package com.company.controller;

import com.company.model.Board;
import com.company.model.Boardlist;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

    public boolean isInputStringValid(String input, String input_menu) {
        boolean isValid = false;

        String regex = input_menu;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches() || input.equals("999")) {

            isValid= true;
        }


      //  if (input.matches("^[0-9]*$")) {
        //    isValid = true;
        //}
        return isValid;
    }

    public boolean isBoardAvalable(List<Board> allboardlist) {
        boolean isAvalible = false;

        if (!allboardlist.isEmpty()) {
            isAvalible = true;
        }

        return isAvalible;
    }

    public boolean isListAvalable(List<Boardlist> boardlists) {
        boolean isListAvalible = false;

        if (!boardlists.isEmpty()) {
            isListAvalible = true;
        }

        return isListAvalible;
    }

    public boolean fileIsEmpty(File file) {

        boolean fileIsEmpty = false;

        if(file.length() == 0){
            fileIsEmpty = true;
        }
        return fileIsEmpty;
    }
}
