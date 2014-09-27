package MyShoppingList.Driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class ProductAvailibilityTester 
{
	
	public static void main(String args[])
	{
		File file;
		BufferedReader br;
		String record;
		String result;
		int count;
		
		count=0;
		file=new File("preferences.txt");
		result="";
		
		try
		{
			br=new BufferedReader(new FileReader(file));
			
			record=br.readLine();
			
			while(record!=null)
			{
				result=result+record.substring(record.indexOf(" "))+",+";
				record=br.readLine();
			}
			
			System.out.println(result.substring(0,result.length()-2));
		}
		catch(Exception ioe)
		{
			ioe.printStackTrace();
		}
		
	}
	
	

}
