package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Draw {
Shape CreateSquare(double x1,double y1,Color borderColor,Color fillColor) {
	Shape square=new Square();
	 Map<String, Double> m = new HashMap<>();
     m.put("width", Double.parseDouble(String.valueOf(0)));
     m.put("height", Double.parseDouble(String.valueOf(0)));
     m.put("cX", Double.parseDouble(String.valueOf(x1)));
     m.put("cY", Double.parseDouble(String.valueOf(y1)));
     m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
     m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
     square.setProperties(m);
     return square;
}
Shape CreateRectangle(double x1,double y1,Color borderColor,Color fillColor) {
	Shape rectangle=new Rectangle();
	Map<String, Double> m = new HashMap<>();
    m.put("width", Double.parseDouble(String.valueOf(0)));
    m.put("height", Double.parseDouble(String.valueOf(0)));
    m.put("cX", Double.parseDouble(String.valueOf(x1)));
    m.put("cY", Double.parseDouble(String.valueOf(y1)));
    m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    rectangle.setProperties(m);
    return rectangle;
	
}
Shape CreateLine(double x1,double y1,Color borderColor) {
	Shape line=new Line();
	Map<String, Double> m = new HashMap<>();
	m.put("pointAX", x1);
	m.put("pointAY",y1);
	m.put("pointBX", x1);
	m.put("pointBY",y1);
	m.put("borderColor",  Double.parseDouble(String.valueOf((borderColor).getRGB())));
	m.put("cX", x1);
	m.put("cY", y1);
	line.setProperties(m);
	return line;
}
Shape CreateTriangle(double x1,double y1,Color borderColor,Color fillColor) {
	Shape triangle=new Triangle();
	Map<String, Double> m = new HashMap<>();
	m.put("pointAX", x1);
	m.put("pointAY",y1);
	m.put("pointBX", x1);
	m.put("pointBY",y1);
	m.put("pointCX", x1);
	m.put("pointCY",y1);
	m.put("cX",( m.get("pointAX")+m.get("pointBX")+m.get("pointCX"))/3);
	m.put("cY",( m.get("pointAY")+m.get("pointBY")+m.get("pointCY"))/3);
	m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    triangle.setProperties(m);
    return triangle;
}
Shape CreateCircle(double x1,double y1,Color borderColor,Color fillColor) {
	Shape circle=new Circle();
	 Map<String, Double> m = new HashMap<>();
 	m.put("width", Double.parseDouble(String.valueOf(0)));
     m.put("height", Double.parseDouble(String.valueOf(0)));
     m.put("cX", Double.parseDouble(String.valueOf(x1)));
     m.put("cY", Double.parseDouble(String.valueOf(y1)));
     m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
     m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
     circle.setProperties(m);
     return circle;
}
Shape CreateEllipse(double x1,double y1,Color borderColor,Color fillColor) {
		Shape ellipse=new Ellipse();
	  Map<String, Double> m = new HashMap<>();
      m.put("width", Double.parseDouble(String.valueOf(0)));
      m.put("height", Double.parseDouble(String.valueOf(0)));
      m.put("cX", Double.parseDouble(String.valueOf(x1)));
      m.put("cY", Double.parseDouble(String.valueOf(y1)));
      m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
      m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
      ellipse.setProperties(m);
      return ellipse;
}
void paintSquare(Shape s,double x1,double y1,double x2,double y2,Color borderColor,Color fillColor ) {
	Map<String, Double> m = new HashMap<>();
	double diff;
	if(y2<y1 && x2<x1) {
		double mini=Math.min(Math.abs(x2-x1),Math.abs(y2-y1));
		m.put("cX", x1-mini);
        m.put("cY", y1-mini);
        diff=mini;
	}
	else if(y2<y1) {
		diff=Math.abs(y2-y1);
		 m.put("cX", Math.min(x1, x2));
         m.put("cY", Math.min(y1, y2));
	}else {
		diff=Math.abs(x2-x1);
		 m.put("cX", Math.min(x1, x2));
         m.put("cY", Math.min(y1, y2));
	}
	m.put("width",diff);
    m.put("height",diff);      
    m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    s.setProperties(m);
}
void paintRectangle(Shape s,double x1,double y1,double x2,double y2,Color borderColor,Color fillColor ) {
	Map<String, Double> m = new HashMap<>();
    m.put("width", Math.abs(x2-x1));
    m.put("height",Math.abs(y2-y1));
    m.put("cX", Math.min(x1, x2));
    m.put("cY", Math.min(y1, y2));
    m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    s.setProperties(m);
}
void paintLine(Shape s,double x1,double y1,double x2,double y2,Color borderColor) {
	Map<String, Double> m = new HashMap<>();
	m.put("pointAX", x1);
	m.put("pointAY",y1);
	m.put("pointBX", x2);
	m.put("pointBY",y2);
	m.put("borderColor",  Double.parseDouble(String.valueOf((borderColor).getRGB())));
	m.put("cX", (x2+x1)/2);
	m.put("cY", (y2+y1)/2);
	s.setProperties(m); 
}
void paintTriangle(Shape s,double x1,double y1,double x2,double y2,Color borderColor,Color fillColor ) {
	Map<String, Double> m = new HashMap<>();
	m.put("pointAX", x1);
	m.put("pointAY",y1);
	m.put("pointBX", x2);
	m.put("pointBY",y1);
	m.put("pointCX", (x1+x2)/2);
	m.put("pointCY",y2);
	m.put("cX",( m.get("pointAX")+m.get("pointBX")+m.get("pointCX"))/3);
	m.put("cY",( m.get("pointAY")+m.get("pointBY")+m.get("pointCY"))/3);
	m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    s.setProperties(m);
}
void paintEllipse(Shape s,double x1,double y1,double x2,double y2,Color borderColor,Color fillColor ) {
	Map<String, Double> m = new HashMap<>();
    m.put("width", Math.abs(x2-x1));
    m.put("height",Math.abs(y2-y1));
    m.put("cX", Math.min(x1, x2));
    m.put("cY", Math.min(y1, y2));
    m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    s.setProperties(m);
}
void paintCircle(Shape s,double x1,double y1,double x2,double y2,Color borderColor,Color fillColor ) {
	Map<String, Double> m = new HashMap<>();
	double diff;
	if(y2<y1 && x2<x1) {
		double mini=Math.min(Math.abs(x2-x1),Math.abs(y2-y1));
		m.put("cX", x1-mini);
        m.put("cY", y1-mini);
        diff=mini;
	}
	else if(y2<y1) {
		diff=Math.abs(y2-y1);
		 m.put("cX", Math.min(x1, x2));
         m.put("cY", Math.min(y1, y2));
	}else {
		diff=Math.abs(x2-x1);
		 m.put("cX", Math.min(x1, x2));
         m.put("cY", Math.min(y1, y2));
	}
	m.put("width",diff);
    m.put("height",diff);      
    m.put("borderColor", Double.parseDouble(String.valueOf((borderColor).getRGB())));
    m.put("fillInColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
    s.setProperties(m);
}
}
