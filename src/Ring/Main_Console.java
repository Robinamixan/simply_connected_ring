package Ring;

import java.util.Scanner;

public class Main_Console {

	@SuppressWarnings("resource")
	public static void main(String arg[]) throws Exception
	{
		//Scanner input = new Scanner(System.in);
		//int n = input.nextInt();
		Ring_Contain<String> ring = new Ring_Contain<String>();
		System.out.println("-------------");
		
		ring.AddInTop("345");
		ring.AddInEnd("111");
		ring.AddInEnd("yyy");
		ring.AddInEnd("ppp");
		ring.AddInTop("ggg");
		ring.PrintRing();
		
		ring.Sort();
		
		ring.PrintRing();
		
		System.out.println("--------------");
		
		Ring_Contain<Double> ring1 = new Ring_Contain<Double>();
		System.out.println("-------------");
		
		ring1.AddInTop(1.);
		ring1.AddInEnd(2.);
		ring1.AddInEnd(3.);
		ring1.AddInEnd(4.);
		ring1.AddInTop(5.);
		ring1.PrintRing();
		
		ring1.Sort();
		
		ring1.PrintRing();
		
		System.out.println("--------------");
		
	}
}
