package com.company.persistance;

import com.company.model.Screen;

import java.io.*;

public class PersistanceState {

  private Screen screen;
  private static final PersistanceState INSTANCE = new PersistanceState();

  private PersistanceState() {
    try {
      this.screen = loadState();
    } catch (Exception e) {
      // LOG.info(..)
      this.screen = new Screen();
    }
  }

  public static PersistanceState getInstance() {
    return INSTANCE;
  }

  private static Screen loadState() throws IOException, ClassNotFoundException {
    FileInputStream fileInputStream = new FileInputStream("objects.dat");

    try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
      return (Screen) objectInputStream.readObject();
    }
  }

  public Screen getScreen() {
    return screen;
  }

  public void persist() throws IOException {
    ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new FileOutputStream("objects.dat"));
    objectOutputStream.writeObject(PersistanceState.getInstance().getScreen());
  }
}
