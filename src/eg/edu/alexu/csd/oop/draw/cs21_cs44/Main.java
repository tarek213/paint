package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.awt.Color;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.test.DummyShape;

public class Main {

	public static void main(String[] args) {
		
		Controller c = new  Controller();
		Shape s = new Circle();
		s.setColor(Color.BLACK);
		System.out.println("hhhhhhhhhhhhhhhhh");
		c.addShape(s);
		c.save("baba.XmL");
		
		c.load("baba.XmL");
	}

}
