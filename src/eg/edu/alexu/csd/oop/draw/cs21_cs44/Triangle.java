package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Triangle extends Shapes{
@Override
public void setPosition(Point position) {
	int diffX=position.x-getProperties().get("cX").intValue();
	int diffY=position.y-getProperties().get("cY").intValue();
	
	getProperties().put("cX",(double) position.x);
	getProperties().put("cY",(double) position.y);
	
	getProperties().put("pointAX", getProperties().get("pointAX")+diffX);
	getProperties().put("pointAY", getProperties().get("pointAY")+diffY);
	
	getProperties().put("pointBX", getProperties().get("pointBX")+diffX);
	getProperties().put("pointBY", getProperties().get("pointBY")+diffY);
	
	getProperties().put("pointCX", getProperties().get("pointCX")+diffX);
	getProperties().put("pointCY", getProperties().get("pointCY")+diffY);
}

@Override
	public void draw(Graphics canvas) {
		int arrX[]= {getProperties().get("pointAX").intValue(),getProperties().get("pointBX").intValue(),getProperties().get("pointCX").intValue()};
		int arrY[]= {getProperties().get("pointAY").intValue(),getProperties().get("pointBY").intValue(),getProperties().get("pointCY").intValue()};	
		
		Map<String,Double>temp;
		temp=getProperties();
		
		Color color=new Color(temp.get("borderColor").intValue());
		canvas.setColor(color);
		canvas.drawPolygon(arrX,arrY,3);
		
		Color color1=new Color(temp.get("fillInColor").intValue());
		canvas.setColor(color1);
		canvas.fillPolygon(arrX,arrY,3);
}


}
