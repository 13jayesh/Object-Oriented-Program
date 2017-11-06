import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressBook {

	static Scanner sc = new Scanner(System.in);

	public static boolean checkEmpty() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader("/home/bridgeit/Desktop/book.json"));
			return reader.readLine() == null;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return false;
	}

	public static void book() throws IOException {

		try {
			JSONObject object = new JSONObject();
			JSONObject object1 = new JSONObject();
			
			System.out.println("Enter name of name");
			String name = sc.next();
			System.out.println("Enter last name");
			String lastname = sc.next();
			System.out.println("Enter address");
			String address = sc.next();
			System.out.println("Enter pin code");
			int pin = sc.nextInt();
			System.out.println("Enter city");
			String city = sc.next();
			System.out.println("Enter phone number");
			int phone = sc.nextInt();

			object.put("name", name);
			object.put("lastname", lastname);
			object.put("city", city);
			object.put("phone", phone);
			object.put("address", address);
			object.put("pin", pin);
			
			object1.put(name, object);
			System.out.println(object1);
			bookadd(object1);
			object.clear();
			object1.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}

	}

	public static void bookadd(JSONObject object) throws IOException {
		// File file=new File(filepath);
		/*
		 * if(file.exists()) { System.out.println(); } else {
		 * System.out.println("file created"); }
		 */
		FileWriter filewriter = new FileWriter("/home/bridgeit/Desktop/book.json");
		filewriter.write(object.toJSONString());
		filewriter.flush();
		filewriter.close();

	}

	@SuppressWarnings("unchecked")
	public static void bookfile() throws FileNotFoundException, IOException, ParseException {
		try {
			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(new FileReader("/home/bridgeit/Desktop/book.json"));

			System.out.println("Enter name of name");
			String name = sc.next();
			System.out.println("Enter last name");
			String lastname = sc.next();
			System.out.println("Enter address");
			String address = sc.next();
			System.out.println("Enter pin code");
			int pin = sc.nextInt();
			System.out.println("Enter city");
			String city = sc.next();
			System.out.println("Enter phone number");
			int phone = sc.nextInt();

			/*JSONObject object2 = (JSONObject) array1.get(0);
			JSONObject obj1=new JSONObject();
			obj1.put("name1", name); 
			obj1.put("lastname1", lastname);
			obj1.put("city1", city); 
			obj1.put("phone", phone);
			obj1.put("address1", address); 
			obj1.put("pin1", pin);
			array1.add(object2);
			array1.add(obj1);
			bookadd(object2);*/
			JSONObject object2=new JSONObject();
			  object2.put("name", name); 
			  object2.put("lastname", lastname);
			  object2.put("city", city); 
			  object2.put("phone", phone);
			  object2.put("address", address); 
			  object2.put("pin", pin);
	
			 fileData.put(name, object2);
			 bookadd(fileData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void remove() throws FileNotFoundException, IOException, ParseException 
	{
		JSONObject 	remove=new JSONObject();	
		JSONParser parser = new JSONParser();
		JSONObject fileData = (JSONObject) parser.parse(new FileReader("/home/bridgeit/Desktop/book.json"));
		JSONArray AAray=new JSONArray();
		AAray.add(fileData);
		System.out.println("Enter name to remove");
		String namaekey=sc.next();
		for(int i = 0;i<AAray.size();i++)
		{
			remove=(JSONObject)AAray.get(i);
			if(remove.get("name").equals(namaekey)){
				fileData. remove("name");
			}
		}
		
	}

	public static void main(String args[]) throws IOException, ParseException {
		String ch;
		String filepath = "home/bridgeit/Desktop/book.json";
		do {
			System.out.println("Enter  1 for add & 2 for remove ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println(checkEmpty());
				if (checkEmpty()) {
					book();
				} else {
					bookfile();
				}

			}
				break;
			case 2: {
				remove();
			}
				break;
			}
			sc.nextLine();
			System.out.println("for add the entry press yes");

			ch = sc.nextLine();

		} while (ch.equals("yes"));

	}

}