package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;


public abstract class Polygon extends Shapes{
@Override
public void draw(Graphics canvas) {
	// TODO Auto-generated method stub
	Map<String,Double>temp;
	temp=getProperties();
	
	Color color=new Color(temp.get("borderColor").intValue());
	canvas.setColor(color);
	canvas.drawRect(temp.get("cX").intValue(), temp.get("cY").intValue(),temp.get("width").intValue(),temp.get("height").intValue());
	
	Color color1=new Color(temp.get("fillInColor").intValue());
	canvas.setColor(color1);
	canvas.fillRect(temp.get("cX").intValue(), temp.get("cY").intValue(),temp.get("width").intValue(),temp.get("height").intValue());
}
}
