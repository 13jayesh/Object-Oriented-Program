import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockShare {
	static Scanner scanner=new Scanner(System.in );
	static int totalStock;
	static String shareName;
	public static void main(String[] args) throws IOException {
		stockReport();
	}
	
		public static void stockReport() throws IOException {

			File file = new File("/home/bridgeit/Desktop/stockReport.json");
			JSONObject object = new JSONObject();
			FileWriter filewriter = new FileWriter("/home/bridgeit/Desktop/stockReport.json");

			System.out.println("number of stock?");
			
			totalStock = scanner.nextInt();
			int i = 1;
			int totalValue = 0;
			while(i<=totalStock){
				JSONArray array = new JSONArray();
				System.out.println(" name of share is");
				shareName = scanner.next();
				System.out.println(" number of shares is");
				int numberOfShares = scanner.nextInt();
				System.out.println("enter share price is");
				int sharePrice = scanner.nextInt();
				
				object.put("nameOfShare",shareName);
				object.put("number_of_shares", numberOfShares);
				object.put("share price", sharePrice);
				array.add(object);
		
				stockEntries(array,filewriter);
				i++;
				int perStockValue = sharePrice*numberOfShares;
				System.out.println("total value of "+shareName+" is "+perStockValue);
				totalValue = totalValue+perStockValue;
				object.remove("nameOfShare");
				object.remove("number_of_shares");
				object.remove("share price");
				}		
			System.out.println(" total value of all stock is "+totalValue);	
		}
		
		public static void stockEntries(JSONArray array,FileWriter filewriter) throws IOException{
			System.out.println(array);
			filewriter.write(array.toJSONString());
			filewriter.flush();

	}

}
