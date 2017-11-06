import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockReport {

	public static void stock()
	{
		JSONArray Array=new JSONArray();
		JSONObject object=new JSONObject();
		JSONObject object1=new JSONObject();
		JSONObject object3=new JSONObject();
		JSONObject object4=new JSONObject();
		JSONObject obj=new JSONObject();
		
		object.put("name", "SBI");
		System.out.println(object);
		object1.put("symbol", "@");
		System.out.println(object1);
		Array.add("100");
		object3.put("share",Array);
		System.out.println(object3);
		
		object4.put(object,object1);
		System.out.println(object4);
		obj.put(object4,object3);
		
		System.out.println(obj);
		
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {

			stock();
	}

}
