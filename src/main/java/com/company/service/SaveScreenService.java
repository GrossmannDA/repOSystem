package com.company.service;

import com.company.model.Screen;
import com.company.view.ScreenView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveScreenService {
  Screen screen;
  public void saveScreen() throws IOException {

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream("objects.dat"));
    objectOutputStream.writeObject(Screen.getInstance());
  }

  public Screen readFile() throws IOException, ClassNotFoundException {

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objects.dat"));
    Screen screen = (Screen) objectInputStream.readObject();

    return screen;
  }
}
