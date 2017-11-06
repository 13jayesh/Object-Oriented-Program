import java.util.Scanner;

public class Regularex {

	public static void main(String[] args) 
	{
		GetterSetter obj2=new GetterSetter();
		String str="Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016. ";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name");
		String name=sc.nextLine();
		System.out.println("Enter fullname");
		String fillname=sc.nextLine();
		System.out.println("Enter no");
		String no=sc.nextLine();
		
		obj2.set(name);
		obj2.setf(fillname);
		obj2.setn(no);
		name=obj2.get();
		fillname=obj2.getf();
		no=obj2.getno();
				
		str=str.replace("<<name>>",name).replace("<<full name>>", fillname).replace("xxxxxxxxxx.", no);

		System.out.println(str);
	}
}
		
		

		
	