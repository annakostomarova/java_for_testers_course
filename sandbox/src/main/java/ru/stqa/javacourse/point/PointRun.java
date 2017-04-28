package ru.stqa.javacourse.point;

import ru.stqa.javacourse.point.Point;

/**
 * Created by kostoa on 4/28/2017.
 */
public class PointRun {

  public static void main(String[] args) {

    Point p1 = new Point(7.0, 2.0);
    Point p2 = new Point(1.0, -5.0);

    System.out.println("Расстояние между двумя точками равно " + " = " + distance(p1,p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}
