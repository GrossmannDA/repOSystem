package com.company.persistance;

import com.company.model.Screen;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistanceState {
// singelton. Nur service darf kommunizieren.

  // when final > cannot assing nothing else. Does it make sence?
  private static Screen screen;

  private static PersistanceState instance;

  private PersistanceState() {

  }

  public static PersistanceState getInstance() throws IOException, ClassNotFoundException {

    if (instance == null) {
      instance = new PersistanceState();
      if (screen == null) {
        loadState();
      }
    }
    return instance;
  }

  public static Screen loadState() throws IOException, ClassNotFoundException {

    FileInputStream fileInputStream = new FileInputStream("objects.dat");
    ObjectInputStream objectInputStream = null;
    try {
      objectInputStream = new ObjectInputStream(fileInputStream);
    } catch (EOFException e) {
      e.printStackTrace();
    }finally {
     // objectInputStream.close();
    }

      screen = (Screen) objectInputStream.readObject();

    objectInputStream.close();
    return screen;
  }

  public Screen getScreen() {
    return screen;
  }

  public void persist() throws IOException, ClassNotFoundException {

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream("objects.dat"));
    objectOutputStream.writeObject(PersistanceState.getInstance().getScreen());
  }

}
