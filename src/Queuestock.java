

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;

	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;
	public class Queuestock 
	
	{	static QueueLinkedList<Integer> list=new QueueLinkedList<Integer>();
		static String word;
		public static void main(String[] args) throws IOException, ParseException 
		{
			JSONObject object0=new JSONObject();
			JSONObject object1=new JSONObject();
			JSONObject object2=new JSONObject();
			JSONObject object3=new JSONObject();
			JSONObject obj=new JSONObject();
			JSONArray Array=new JSONArray();
			JSONObject obj1=new JSONObject();
			
			object0.put("Compony", "HTC");
			object0.put("noOfshare",50);
			object0.put("share",3000);
			Array.add(object0);
			
			object1.put("Compony", "L&T");
			object1.put("noOfshare",30);
			object1.put("share",6000);
			Array.add(object1);
			
			object2.put("Compony", "TCS");
			object2.put("noOfshare",40);
			object2.put("share",4000);
			Array.add(object2);
			
			object3.put("Company",Array);
			//System.out.println(object3);
		
			
			File file=new File("/home/bridgeit/Desktop/obj2.json");
			if(file.exists())
				{
					System.out.println("file already exist");
				}
			else
				{
					System.out.println("file created");
				}
					FileWriter filewriter=new FileWriter("/home/bridgeit/Desktop/obj2.json");    
					filewriter.write(object3.toJSONString());    
					filewriter.flush();
			
					String line=null;
					FileReader filereader = new FileReader("/home/bridgeit/Desktop/obj2.json");
					BufferedReader bufferedreader = new BufferedReader(filereader);
					while ((line = bufferedreader.readLine()) != null) {
					System.out.println(line);
					System.out.println(   " press 1 for buy;press 2 for cell");
				}	Scanner sc=new Scanner(System.in);System.out.println("Enter choice ");
					int chioce=sc.nextInt();
				
					switch(chioce)
					{
					case 1:
					{
					buy(object3);
					}
					case 2:
					{
					sell(object3);
			}
					
					
					
		}
		}
			private static void buy(JSONObject inventory) throws FileNotFoundException, IOException, ParseException 
			{

				int Shares = 0,val=0;
				JSONParser parser = new JSONParser();
				JSONObject fileData=(JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/obj2.json"));
				JSONArray array=(JSONArray)fileData.get("Company");
				JSONObject obj=new JSONObject();
				Scanner sc=new Scanner(System.in);
				do
					{
						System.out.println("compony name");
						String name=sc.next();
						for(int i=0;i<array.size();i++)
							{
							JSONObject comobject=(JSONObject) array.get(i);
				
								if(comobject.get("Compony").equals(name))
									{
										long share=(long)comobject.get("share");
										long noOfshare=(long)comobject.get("noOfshare");
										System.out.println("how share u want");
										int no=sc.nextInt();
										System.out.println("total amount to purches (shares value*no of share)");
										int totalAmount=(int) (share*no);;
										System.out.println(totalAmount);
											if(noOfshare>=no)
											{
												val=val+no;
												System.out.println("u have" +val);
												list.enQueue(val);
												System.out.println("The shares in queue is");
												System.out.println(val);
												obj.put("NOSHARES",val);
												Reader(obj);
												noOfshare=noOfshare-no;	
//												new comcept
												comobject.put("noOfshare",noOfshare);
												System.out.println();
												System.out.println("remaining share in compony is"+noOfshare);
											}	
											else
											{
												System.out.println("your have less no of share");				
											}
									}
							}
											System.out.println("press yes to buy the shares");
											word=sc.next();
								
				}		
				while(word.equals("yes"));
			}
						private static void Reader(JSONObject obj) throws IOException
						{
							File file=new File("/home/bridgeit/Desktop/myshare.json");
							if(file.exists())
							{
								System.out.println();
							}
							else
							{
								System.out.println("file created");
							}
								FileWriter filewriter=new FileWriter("/home/bridgeit/Desktop/myshare.json");    
								filewriter.write(obj.toJSONString());    
								filewriter.flush();
				
								String line=null;
								FileReader filereader = new FileReader("/home/bridgeit/Desktop/myshare.json");
								BufferedReader bufferedreader = new BufferedReader(filereader);
								while ((line = bufferedreader.readLine()) != null) {

			    	 
									System.out.println(line);
								}
						}
		


						public static void sell(JSONObject object3) throws FileNotFoundException, IOException, ParseException
						{	Scanner sc=new Scanner(System.in);
							File file=new File("/home/bridgeit/Desktop/myshare.json");
						if(file.exists())
						{
							System.out.println("file already exist");
						}
						else
						{
							System.out.println("file created");
						}	int var;
							do
							{
							
							JSONParser parser = new JSONParser();
							JSONObject fileData=(JSONObject)parser.parse(new FileReader("/home/bridgeit/Desktop/myshare.json"));
							
							
							System.out.println(fileData);
							long finalmyshare=(long)fileData.get("NOSHARES");
							System.out.println(finalmyshare);
							System.out.println("I Want to sell my share");
							System.out.println("how many");
							int numb=sc.nextInt();
							if(numb<=finalmyshare)
							{
								finalmyshare=finalmyshare-numb;
								System.out.println(" Now i have "  + finalmyshare + "  shares  ");
								System.out.println("my share in queue is ");
								list.enQueue((int) finalmyshare);
								System.out.println(finalmyshare);
								fileData.put("NOSHARES", finalmyshare);
								ReadeR(fileData);
							}
							else
							{
								System.out.println("I have less Shares");
							} 
							System.out.println("press yes to SELL the share");
							
							String link=sc.next();
							}
							
							while(word.equals("yes"));	
							
	}
						private static void ReadeR(JSONObject fileData) throws IOException
						{
							File file=new File("/home/bridgeit/Desktop/sellshare.json");
							if(file.exists())
							{
								System.out.println();
							}
							else
							{
								System.out.println("file created");
							}
								FileWriter filewriter=new FileWriter("/home/bridgeit/Desktop/sellshare.json");    
								filewriter.write(fileData.toJSONString());    
								filewriter.flush();
				
								String line=null;
								FileReader filereader = new FileReader("/home/bridgeit/Desktop/sellshare.json");
								BufferedReader bufferedreader = new BufferedReader(filereader);
								while ((line = bufferedreader.readLine()) != null) {

			    	 
									System.out.println(line);
								}
						}
	}



		

