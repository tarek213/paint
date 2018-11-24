package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.awt.Graphics;
import java.io.File;
import java.net.URI;
import java.rmi.server.ServerCloneException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.jar.JarFile;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.Servant;

//import eg.edu.alexu.csd.oop.calculator.Calculator;
import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import java.util.HashMap;
import java.util.Map;

public class Controller implements DrawingEngine{
	private ArrayList<ArrayList<Shape>>undo=new ArrayList<>();
	private ArrayList<ArrayList<Shape>>redo=new ArrayList<>();
	private ArrayList<Shape> arr=new ArrayList<>();
	private final Class<?> interfaceToTest = Shape.class ;
	
	List<Class<? extends Shape>> returnedClasses;
	
	int start =1;
	ArrayList<Shape> newList(ArrayList<Shape> x){
		ArrayList<Shape>z=new ArrayList<>();
		for(int i=0;i<x.size();i++) {
		z.add(x.get(i));
		}
		return z;
	}
		
	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.size();i++) {
			arr.get(i).draw(canvas);
		}
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		if(start==1) {
			start=0;
			ArrayList<Shape>temp=new ArrayList<>();
			for(int i=0;i<arr.size();i++) {
				temp.add(arr.get(i));
			}
			undo.add(temp);
		}
		if(undo.size()==21) {
			undo.remove(0);
		}
		arr.add(shape);
		ArrayList<Shape>temp=new ArrayList<>();
		for(int i=0;i<arr.size();i++) {
			temp.add(arr.get(i));
		}
		undo.add(temp);
		redo.clear();
		
	}

	@Override
	public void removeShape(Shape shape) {
		//if(arr.size()!=0) {
			if(undo.size()==21) {
				undo.remove(0);
			}
			arr.remove(shape);
			ArrayList<Shape>temp=new ArrayList<>();
			for(int i=0;i<arr.size();i++) {
				temp.add(arr.get(i));
			}
			undo.add(temp);
			redo.clear();
			
		//}
		
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		if(undo.size()==21) {
			undo.remove(0);
		}
		//if(arr.size()!=0) {
			arr.set(arr.indexOf(oldShape), newShape);
			ArrayList<Shape>temp=new ArrayList<>();
			for(int i=0;i<arr.size();i++) {
				temp.add(arr.get(i));
			}
			undo.add(temp);
			redo.clear();
		//}
		
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		
		Shape[] shape=new Shape[arr.size()];
		for(int i=0;i<arr.size();i++) {
			shape[i]=arr.get(i);
		}
		return shape;
	}
	@Override
	public void installPluginShape(String jarPath) {
		returnedClasses = new ArrayList<Class<? extends Shape>>();
		Help h=new Help();
		try {
			h.loadShapesFromJar("RoundRectangle.jar", returnedClasses);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//returnedClasses=Help.findClassesImpmenenting(interfaceToTest, interfaceToTest.getPackage());
		
	}
	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		installPluginShape("RoundRectangle.jar");
        return returnedClasses;
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if(undo.size()>1) {
		ArrayList<Shape>z=newList(undo.remove(undo.size()-1));
			redo.add(newList(z));
			arr=newList(undo.get(undo.size()-1));
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		if(redo.size()>=1) {
		arr=newList(redo.remove(redo.size()-1));
		
		undo.add(newList(arr));
		}
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		String st = path.toLowerCase();
		if(st.contains(".xml"))
		{
			Save s = new Save();
			s.saveXml(st, arr);
			
		} else if(st.contains(".json"))
		{
			Save s = new Save();
			s.saveJson(st, arr);
		}
                
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		String s = path.toLowerCase();
		if(s.contains(".xml"))
		{
			Load l = new Load();
			l.loadXml(s,arr);
			
		} else if(s.contains(".json")){
			Load l = new Load();
			l.loadJson(s, arr);
			
		}
		redo.clear();
		undo.clear();
                
               
	}
		
	

}
