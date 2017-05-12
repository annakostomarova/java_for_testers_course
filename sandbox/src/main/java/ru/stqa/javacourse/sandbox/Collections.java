package ru.stqa.javacourse.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kostoa on 5/12/2017.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java","C#","Python","PHP"};

    List<String> languages = Arrays.asList("Java","C#","Python","PHP");

    for(String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }

    for(String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

    /* Счетчиком тоже можно пробегать, но это не так удобно и красиво
    for(int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
    */
  }
}

