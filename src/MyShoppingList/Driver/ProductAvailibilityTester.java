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
		// TODO Auto-generated method stub

	}
	
	public void getProductAvailibility(int storeId, String productId)
	{
		URL portal;
		URLConnection portalConnection;
		String inputLine;
		BufferedReader input;
		
		try
		{
			portal=new URL("http://api.target.com/v2/location?productId="+productId+"&storeId="+storeId+"&key=[J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF]");
			portalConnection=portal.openConnection();
			
			input= new BufferedReader(new InputStreamReader(portalConnection.getInputStream()));
			
			inputLine= input.readLine();
			while(inputLine!=null)
			{
				System.out.println(inputLine);
				inputLine=input.readLine();
			}
			
			input.close();
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}

}
