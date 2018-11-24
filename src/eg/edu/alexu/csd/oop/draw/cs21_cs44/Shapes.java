package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import java.util.HashMap;

public abstract class Shapes implements Shape{
	
private Map<String, Double> properties = new HashMap<>();
	
	  
	

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		properties.put("cX",(double) position.x);
		properties.put("cY",(double) position.y);
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		Point p=new Point(properties.get("cX").intValue(),properties.get("cY").intValue() );
		return  p;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		this.properties=properties;
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return this.properties;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		properties.put("borderColor", (double)color.getRGB());	
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub'
		
		Color color=new Color(properties.get("borderColor").intValue());
		return color;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		properties.put("fillInColor", (double)color.getRGB());	
		
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		Color color=new Color(properties.get("fillInColor").intValue());
		return color;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		
	}
	
	public Object clone() throws CloneNotSupportedException{		
		return this;
	}
	
	

}
