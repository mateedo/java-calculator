import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.util.*;
public class Main extends methods{

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		
		String txtContents;
		File helpCommand = new File("helpcommand.txt");
		LinkedList<String>helpList = new LinkedList<String>();
		
		
		try {
			Scanner temp = new Scanner(new File("helpcommand.txt"));
			while(temp.hasNext())
			{
				txtContents = temp.nextLine();
				helpList.add(txtContents);
			}
		}catch(Exception e)
		{
			
		}
		
		System.out.println("Calculator app v2 by Mateo. Enter in equation your equation or type ''Help'' for formatting info");
		
		while(true) {
			
		
		String input = sc.nextLine();
		if(input.toLowerCase().equals("help"))
				{
					for(int i  = 0; i < helpList.size();i++)
					{
						System.out.println(helpList.get(i));
					}
				}
		
		else {
			System.out.println(calculate(input));
		}
		
		
		}
	}

}
