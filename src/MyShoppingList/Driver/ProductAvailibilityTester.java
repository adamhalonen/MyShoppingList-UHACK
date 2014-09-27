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
		getProductStock("694","070-09-0141");

	}
	
	public static void getProductStock(String storeId, String productId)
	{
		URL portal;
		URLConnection portalConnection;
		String inputLine;
		BufferedReader input;
		int result;
		int hold;
		String sub;
		
		try
		{
			portal=new URL("http://api.target.com/v2/location?productId="+productId+"&storeId="+storeId+"&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF");
			portalConnection=portal.openConnection();
			
			input= new BufferedReader(new InputStreamReader(portalConnection.getInputStream()));
			
			inputLine= input.readLine();
			while(inputLine!=null)
			{
				System.out.println(inputLine);
				inputLine=inputLine + input.readLine();
			}
			input.close();
			
			hold= inputLine.indexOf("OnHandQuantity")+17;
			
			sub=inputLine.substring(hold);
			
			result=Integer.parseInt(sub.substring(0,sub.indexOf(",")));
			
			System.out.println(result);
			
			
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}

}
