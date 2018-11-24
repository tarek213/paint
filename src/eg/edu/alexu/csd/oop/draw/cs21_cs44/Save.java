package eg.edu.alexu.csd.oop.draw.cs21_cs44;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Save {
	
	public void saveXml(String path , ArrayList<Shape> arr)
	{
		System.out.println(arr.size());
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
			bufferedWriter.append("<paint>");
			bufferedWriter.newLine();
			for(int i = 0;i<arr.size();i++)
			{
				Map<String, Double> map = arr.get(i).getProperties();
				bufferedWriter.append("<"+arr.get(i).getClass().getSimpleName()+" id=\""+arr.get(i).getClass().getName()+"\">");
				int j = 0;
				if(map != null) {
				for(String key : map.keySet())
				{
					j++;
					if(j != map.size()+1)
					{
						bufferedWriter.newLine();
					} 
					bufferedWriter.append("<"+key+">"+map.get(key).toString()+"</"+key+">");
					
				}
				}
				bufferedWriter.newLine();
				bufferedWriter.append("</"+arr.get(i).getClass().getSimpleName()+">");
				if(i != arr.size()-1)
				{
					bufferedWriter.newLine();
				}

			}
			bufferedWriter.newLine();
			bufferedWriter.append("</paint>");
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveJson(String path , ArrayList<Shape>arr)
	{
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
			bufferedWriter.append("{");
			bufferedWriter.newLine();
			bufferedWriter.append("\"paint\" : {");
			bufferedWriter.newLine();
			for(int i = 0;i<arr.size();i++)
			{
				Map<String, Double> map = arr.get(i).getProperties();
				bufferedWriter.append("\""+arr.get(i).getClass().getSimpleName()+"\" : {");
				bufferedWriter.newLine();
				bufferedWriter.append("\"id\" : \""+arr.get(i).getClass().getName()+"\",");
				int j = 0;
				if(map != null) {
				for(String key : map.keySet())
				{
					j++;
					if(j != map.size()+1)
					{
						bufferedWriter.newLine();
					} 
					bufferedWriter.append("\""+key+"\" : "+map.get(key).toString());
					if(j != map.size())
					{
						bufferedWriter.append(",");
					}
					
				}
				}
				bufferedWriter.newLine();
				bufferedWriter.append("}");
				if(i != arr.size()-1)
				{
					bufferedWriter.append(",");
					bufferedWriter.newLine();
				}

			}
			bufferedWriter.newLine();
			bufferedWriter.append("}");
			bufferedWriter.newLine();
			bufferedWriter.append("}");
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
