package ru.stqa.javacourse.point;

/**
 * Created by kostoa on 4/28/2017.
 */
public class PointRun {

  public static void main(String[] args) {

    Point p1 = new Point(7.0, 2.0);
    Point p2 = new Point(1.0, -5.0);

    System.out.println("Расстояние между двумя точками равно " + " = " + p1.distance(p2));
  }


}
