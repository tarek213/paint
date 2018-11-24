package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.util.ArrayList;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class SellectionDetector {
	//select square and rectangle
	private boolean selectedSquare(int x1,int y1,Shape s) {
		Map<String,Double>temp;
		temp=s.getProperties();
		int topLeftX,topLeftY,bottomRightX,bottomRightY;
		topLeftX=temp.get("cX").intValue();
		topLeftY=temp.get("cY").intValue();
		bottomRightX=temp.get("cX").intValue()+temp.get("width").intValue();
		bottomRightY=temp.get("cY").intValue()+temp.get("height").intValue();
		if(x1>=topLeftX&&x1<=bottomRightX&&y1>=topLeftY&&y1<=bottomRightY) {
			return true;
		}
		return false;
		}
	
	private boolean selectedRectangle(int x1,int y1,Shape s) {
		Map<String,Double>temp;
		temp=s.getProperties();
		int topLeftX,topLeftY,bottomRightX,bottomRightY;
		topLeftX=temp.get("cX").intValue();
		topLeftY=temp.get("cY").intValue();
		bottomRightX=temp.get("cX").intValue()+temp.get("width").intValue();
		bottomRightY=temp.get("cY").intValue()+temp.get("height").intValue();
		if(x1>=topLeftX&&x1<=bottomRightX&&y1>=topLeftY&&y1<=bottomRightY) {
			return true;
		}
		return false;
		}
	
	//selected triangle
	private boolean selectedTriangle(int x1,int y1,Shape s) {
		Map<String,Double>temp;
		temp=s.getProperties();
		int p1X,p1Y,p2X,p2Y,p3X,p3Y;
		p1X=temp.get("pointAX").intValue();
		p2X=temp.get("pointBX").intValue();
		p3X=temp.get("pointCX").intValue();
		p1Y=temp.get("pointAY").intValue();
		p2Y=temp.get("pointBY").intValue();
		p3Y=temp.get("pointCY").intValue();
		 if (isInside(p1X,p1Y,p2X,p2Y,p3X,p3Y, x1, y1)) {
			return true;
		}
		return false;
		}



	static private double area(int x1, int y1, int x2, int y2, 
	        int x3, int y3) 
	{ 
	return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ 
	    x3*(y1-y2))/2.0); 
	} 

	/* A function to check whether point P(x, y) lies 
	inside the triangle formed by A(x1, y1), 
	B(x2, y2) and C(x3, y3) */
	static private boolean isInside(int x1, int y1, int x2, 
	int y2, int x3, int y3, int x, int y) 
	{    
	/* Calculate area of triangle ABC */
	double A = area (x1, y1, x2, y2, x3, y3); 

	/* Calculate area of triangle PBC */  
	double A1 = area (x, y, x2, y2, x3, y3); 

	/* Calculate area of triangle PAC */  
	double A2 = area (x1, y1, x, y, x3, y3); 

	/* Calculate area of triangle PAB */   
	double A3 = area (x1, y1, x2, y2, x, y); 

	/* Check if sum of A1, A2 and A3 is same as A */
	return (A == A1 + A2 + A3); 
	}
	
	//
	//select circle
	private boolean selectedCircle(int x1,int y1,Shape s) {
		Map<String,Double>temp;
		temp=s.getProperties();
		int centerX,centerY;
		centerX=temp.get("cX").intValue()+(temp.get("width").intValue()/2);
		centerY=temp.get("cY").intValue()+(temp.get("height").intValue()/2);
		if(Math.sqrt((x1-centerX)*(x1-centerX)+(y1-centerY)*(y1-centerY))<=temp.get("width").intValue()/2) {
			return true;
		}
		return false;
		}
	//select ellipse
	
	private boolean selectedEllipse(int x1,int y1,Shape s) {
		Map<String,Double>temp;
		temp=s.getProperties();
		int centerX,centerY;
		centerX=temp.get("cX").intValue()+(temp.get("width").intValue()/2);
		centerY=temp.get("cY").intValue()+(temp.get("height").intValue()/2);
		int width=temp.get("width").intValue()/2;
		int height=temp.get("height").intValue()/2;
		int p=checkpoint(centerX, centerY, x1, y1, width, height);
		if(p<=1) {
			return true;
		}
		return false;
		}
	static private int checkpoint(int h, int k, int x, int y, int a, int b) 
	{ 
	  
	    // checking the equation of 
	    // ellipse with the given point 
	    int p = ((int)Math.pow((x - h), 2) / (int)Math.pow(a, 2)) 
	            + ((int)Math.pow((y - k), 2) / (int)Math.pow(b, 2)); 
	  
	    return p; 
	}
	//select line
	private boolean selectedLine(int x,int y,Shape s) {
		Map<String,Double>temp;
		temp=s.getProperties();
		int x1, y1, x2, y2;
		x1=temp.get("pointAX").intValue();
		y1=temp.get("pointAY").intValue();
		x2=temp.get("pointBX").intValue();
		y2=temp.get("pointBY").intValue();
		double mainSlope=Math.abs((double)(y2-y1)/(x2-x1));
		double slope=Math.abs((double)(y2-y)/(x2-x));
		return (Math.abs(mainSlope-slope)<=0.00001);	
	}
	
	public Shape detectSellection(int x,int y,Shape[]shapes) {
		for(int i=shapes.length-1;i>=0;i--) {
			String type=shapes[i].getClass().getName();
                        //Triangle.class.isAssignableFrom(shapes[i].getClass());
			if(Triangle.class.isAssignableFrom(shapes[i].getClass())) {
				if(selectedTriangle(x, y, shapes[i])){
                                    System.out.println("triangle");
					return shapes[i];
                                        
				}
			}else if(Square.class.isAssignableFrom(shapes[i].getClass())) {
				if(selectedSquare(x, y, shapes[i])) {
                                    System.out.println("square");
					return shapes[i];
				}
			}else if(Rectangle.class.isAssignableFrom(shapes[i].getClass())) {
				if(selectedRectangle(x, y, shapes[i])) {
                                    System.out.println("rectangle");
					return shapes[i];
				}
			}else if(Circle.class.isAssignableFrom(shapes[i].getClass())) {
				if(selectedCircle(x, y, shapes[i])) {
                                    System.out.println("circle");
					return shapes[i];
				}
			}else if(Ellipse.class.isAssignableFrom(shapes[i].getClass())) {
				if(selectedEllipse(x, y, shapes[i])) {
                                    System.out.println("ellipse");
					return shapes[i];
				}
				
			}else if(Line.class.isAssignableFrom(shapes[i].getClass())) {
				if(selectedLine(x, y, shapes[i])) {
                                    System.out.println("line");
					return shapes[i];
				}
			}
		}
		
	return null;	
	}
	
	
	
}
