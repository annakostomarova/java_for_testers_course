package ru.stqa.javacourse.sandbox;

import org.w3c.dom.css.Rect;

public class HelloWorld {

	public static void main(String[] args) {
		hello("user");
    hello("Anna");
    hello("world");

    Square s = new Square(5);
    System.out.println("Площадь квардрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }



}