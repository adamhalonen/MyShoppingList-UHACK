package MyShoppingList.Driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestMainForUtil {
	public static void main(String[] args)
	{
    	try
    	{
            URL oracle = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyC1WYPjAlZtv5cjzWmHkc2nq3s0odsAJuo");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
                System.out.println(inputLine);
            in.close();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

	}
}
