package com.company.persistance;

import com.company.model.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class PersistanceState {

  private final static Logger LOGGER = LoggerFactory.getLogger(PersistanceState.class);

  private Screen screen;
  private static final PersistanceState INSTANCE = new PersistanceState();


  private PersistanceState() {
    try {
      this.screen = loadState();
      LOGGER.debug("State was successfully loaded");
    } catch (Exception e) {
      LOGGER.warn("Exception when loaded state", e);
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
