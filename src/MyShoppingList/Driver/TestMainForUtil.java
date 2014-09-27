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
		int lat;
		int lng;
		String latString;
		String lngString;
		address = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";
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
            
            lat = bigString.indexOf("lat")+7;
            lng = bigString.indexOf("lng")+7;
            
            latString = bigString.substring(lat);
            lngString = bigString.substring(lng);   
            
            System.out.println(latString.substring(0,latString.indexOf(',')));
            System.out.println(lngString.substring(0,lngString.indexOf('}')));
            
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

	}
}
