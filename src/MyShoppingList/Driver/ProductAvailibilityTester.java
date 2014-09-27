package MyShoppingList.Driver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ProductAvailibilityTester 
{

	public static void main(String[] args) 
	{
		
		System.out.println(getProductStock(694,"070-09-0141"));

	}
	
	public static double getProductStock(int storeId, String productId)
	{
		URL portal;
		URLConnection portalConnection;
		String inputLine;
		BufferedReader input;
		double result;
		int hold;
		String sub;
		String holdString;
		
		inputLine="";
		result=0;
		holdString="";
		
		
		try
		{
			portal=new URL("http://api.target.com/v2/products/availability?productId="+productId+"&storeId="+storeId+"&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF");
			System.out.println(portal);
			portalConnection=portal.openConnection();
			
			input= new BufferedReader(new InputStreamReader(portalConnection.getInputStream()));
			
			
			
			
			inputLine= input.readLine();
			
			while(inputLine!=null)
			{
				holdString=holdString+inputLine;
				inputLine= input.readLine();
			}
			input.close();
			

			hold= holdString.indexOf("OnHandQuantity")+15;
			
			
			sub=holdString.substring(hold);
			
			
			
			result=Double.parseDouble(sub.substring(0,sub.indexOf("<")));		
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
		return result;
		
	}

}
