package com.company;

import java.io.File;

public class Util {

  private File file;

  public File getFile() {
    return file;
  }

  public void createFile() {
    file = new File("SerTest.bin");

  }
}
