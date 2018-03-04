package com.company.persistance;

import com.company.model.Screen;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistanceState {
// singelton. Nur service darf kommunizieren.

  private final static Screen screen = null;

  private static PersistanceState instance;
  private PersistanceState() {

  }

  public  Screen getScreen() {
    return screen;
  }

  public static PersistanceState getInstance() {

    if (instance == null) {
      instance = new PersistanceState();
    }
    return instance;

  }

  public void persist() throws IOException {

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream("objects.dat"));
    objectOutputStream.writeObject(PersistanceState.getInstance());
  }

  public void loadState() throws IOException, ClassNotFoundException {

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objects.dat"));
    Screen screen = (Screen) objectInputStream.readObject();

  }

}
