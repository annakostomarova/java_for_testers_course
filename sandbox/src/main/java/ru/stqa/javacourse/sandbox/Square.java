package ru.stqa.javacourse.sandbox;

/**
 * Created by kostoa on 4/27/2017.
 */
public class Square {

  public double l;

  public Square(double l) {
    this.l = l;
  }

  public double area() {
    return this.l * this.l;
  }
}
