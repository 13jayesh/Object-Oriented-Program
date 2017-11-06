

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
public class test {

	public static void main(String[] args) throws IOException, ParseException
	{
	JSONObject obj=new JSONObject();
    JSONObject obj1 = new JSONObject();
    JSONObject obj2 = new JSONObject();
    JSONArray  array=new JSONArray();
    JSONObject Inventory = new JSONObject();

    obj.put("Name" ,"basmati");
    obj.put("waight",1);
    obj.put("price",100);
	
	
	array.add(obj);
	System.out.println(obj);
	
	obj1.put("Name" ,"Wheats");
	obj1.put("waight",2);
	obj1.put("price",200);
	array.add(obj1);
	System.out.println(obj1);
	
	
	obj2.put("Name" ,"pulse");
	obj2.put("waight",2);
	obj2.put("price",300);
	array.add(obj2);
	System.out.println(obj2);
	Inventory.put("Inventory", array);
	
	
	
	File file=new File("/home/bridgeit/Desktop/obje.json");
	if(file.exists())
	{
		System.out.println("file already exist");
	}
	else
	{
		System.out.println("file created");
	}
	FileWriter filewriter=new FileWriter("/home/bridgeit/Desktop/obj.json");    
	filewriter.write(Inventory.toJSONString());    
	filewriter.flush();
	
	String line=null;
	FileReader filereader = new FileReader("/home/bridgeit/Desktop/obj.json");
    BufferedReader bufferedreader = new BufferedReader(filereader);
    while ((line = bufferedreader.readLine()) != null) {

    	 
	System.out.println(line);
	
}
    Valueis(Inventory);
	}
	private static void Valueis(JSONObject inventory) throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser parser = new JSONParser();
		JSONObject fileData=(JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/obj.json"));
		JSONArray array=(JSONArray)fileData.get("Inventory");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value to be found");
		String value=sc.next();
		for(int i=0;i<=array.size();i++){
			JSONObject comobject=(JSONObject) array.get(i);
		if(comobject.get("Name").equals(value))
		{
			long price=(long) comobject.get("price");
			long waight=(long)comobject.get("waight");
			long totalval=(price*waight);
			System.out.println(totalval);
			break;
		}
	}
}
}