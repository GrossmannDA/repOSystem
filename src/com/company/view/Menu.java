package com.company.view;

import com.company.model.Board;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Menu {
    String input;

    public Menu() throws IOException {

        System.out.println("Please choose the point.");

        Menupoints createNewBoard = Menupoints.CREATE_NEW_BOARD;
        System.out.println(createNewBoard.getMenupoint());

        Menupoints createNewList = Menupoints.CREATE_NEW_LIST;
        System.out.println(createNewList.getMenupoint());

        Menupoints createNewCard = Menupoints.CREATE_NEW_CARD;
        System.out.println(createNewCard.getMenupoint());

        Menupoints end = Menupoints.END;
        System.out.println(end.getMenupoint());
    }

    public void serializeObjeckt(Object object, File file) throws IOException {

        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);

        so.writeObject(object);
        so.flush();
        so.close();
    }

    public Object deserializeObjeckt(File file) throws IOException, ClassNotFoundException {
        Object object;

        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);
        object = (Board)si.readObject();

        si.close();
        return object;
    }

}
