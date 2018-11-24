package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Load {
	
	public void loadXml(String path , ArrayList<Shape> arr){
		arr.clear();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				if(s.contains("paint")){
				} else if(s.contains("id"))
				{
					Map<String, Double> data = new HashMap<>();
					String temp = s.substring(1, s.length()-1);
					String [] split1 = temp.split("\"");
					String className = split1[1];
					String shapeName = split1[0].split(" ")[0];
					while (!(s = bufferedReader.readLine()).contains(shapeName)) {
						String [] split2 = s.split("<");
						String [] split3 = split2[1].split(">");
						//System.out.println(s);
						data.put(split3[0], Double.valueOf(split3[1]));
					}
					Class<?> clas = Class.forName(className);
					Constructor<?> con = clas.getConstructor();
					Shape shape = (Shape) con.newInstance();
					shape.setProperties(data);
					arr.add(shape);
				}
			}
			bufferedReader.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void loadJson (String path , ArrayList<Shape> arr)
	{
		arr.clear();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
			String s,temp;
			String className = "";
			while ((s = bufferedReader.readLine()) != null) {
				if(s.contains(" : {") && !s.contains("paint"))
				{
					Map<String, Double> data = new HashMap<>();
					int f = 0;
					while (!((s = bufferedReader.readLine()).contains("}"))) {
						//System.out.println("line&"+s +"&f&"+f+"&");
						f++;
						if(s.charAt(s.length()-1) == ',')
						{
							 temp = s.substring(0,s.length()-1);
							 //System.out.println("temp&"+temp+"&");
							//s = s.substring(0, s.length()-1);
						} else {
							temp = s;
						}
						String [] split2 = temp.split(" : ");
						//System.out.println("part1&"+split2[0]);
						//System.out.println("part2&"+split2[1]);
						if(split2[0].contains("\"id\""))
						{
							//System.out.println("f&"+f+"&");
							//System.out.println("temp&"+temp+"&");
							className = split2[1].substring(1, split2[1].length()-1);
							//System.out.println("classname&"+className+"&");
						} else {
							String key;
							double value;
							key = split2[0].substring(1, split2[0].length()-1);
							//System.out.println(key);
							//System.out.println(split2[1]);
							value = Double.valueOf(split2[1]);
							data.put(key, value);
							
						}
					}
					//System.out.println("classname("+className+")");
					Class<?> clas = Class.forName(className);
					Constructor<?> con = clas.getConstructor();
					Shape shape = (Shape) con.newInstance();
					shape.setProperties(data);
					arr.add(shape);
				}
			}
			bufferedReader.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
