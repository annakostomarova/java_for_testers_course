package ru.stqa.javacourse.point;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.javacourse.point.Point.distance;

/**
 * Created by kostoa on 4/28/2017.
 */

public class PointTest {

  @Test
  public void testDistance1() {
    Point p1 = new Point(-3, 1);
    Point p2 = new Point(3, 9);
    Assert.assertEquals(distance(p1, p2), 10.0);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(8.99, -38.0);
    Point p2 = new Point(11.99, -34.0);
    Assert.assertEquals(distance(p1, p2), 5.0);
  }

  /* negative test */
  @Test
  public void testDistanceNegative1() {
    Point p1 = new Point(0, -38.0);
    Point p2 = new Point(2.8, -34.0);
    Assert.assertNotEquals(distance(p1, p2), 5.0);
  }
}
