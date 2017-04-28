package ru.stqa.javacourse.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kostoa on 4/28/2017.
 */
public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 25.0);
  }
}
