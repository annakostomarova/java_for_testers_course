package ru.stqa.javacourse.point;

/**
 * Created by kostoa on 4/27/2017.
 */
public class Point {

  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) {
    return Math.sqrt((x - p2.x) * (x - p2.x) + (y - p2.y) * (y - p2.y));
  }

}
