package MyShoppingList.Driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestMainForUtil {
	public static void main(String[] args)
	{
		String address;
		String bigString ="";
		address = "2115+Summit+Ave,+St.+Paul,+MN";
    	try
    	{
            URL oracle = new URL("https://maps.googleapis.com/maps/api/geocode/json?address="+ address +"&key=AIzaSyC1WYPjAlZtv5cjzWmHkc2nq3s0odsAJuo");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
                bigString = bigString + (inputLine);
            in.close();	
            
            System.out.println(bigString.indexOf("lat"));
            System.out.println(bigString.substring(bigString.indexOf("lat")+3, ));
            
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

	}
}
