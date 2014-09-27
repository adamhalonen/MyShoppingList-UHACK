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
		
		getProductStock(694,"070-09-0141");

	}
	
	public static void getProductStock(int storeId, String productId)
	{
		URL portal;
		URLConnection portalConnection;
		String inputLine;
		BufferedReader input;
		int result;
		int hold;
		String sub;
		
		inputLine="";
		result=0;
		
		
		try
		{
			portal=new URL("http://api.target.com/v2/location?productId="+productId+"&storeId="+storeId+"&key=[J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF]");
			portalConnection=portal.openConnection();
			
			
			input= new BufferedReader(new InputStreamReader(portalConnection.getInputStream()));
			
			System.out.println("here");
			
			inputLine= input.readLine();
			while(inputLine!=null)
			{
				inputLine=inputLine + input.readLine();
			}
			input.close();
			
			hold= inputLine.indexOf("OnHandQuantity")+17;
			
			sub=inputLine.substring(hold);
			
			result=Integer.parseInt(sub.substring(0,sub.indexOf(",")));
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}

}
