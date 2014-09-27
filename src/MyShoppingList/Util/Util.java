package MyShoppingList.Util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//import org.json.JSONString;

public class Util {

	private int[] intArray;
    private String[] stringArray;
    private int length;
    private String storeAddress;
    
    
    public Util()
    {
    	
    }
    public int sortIntegers(int[] inputArray) throws IllegalArgumentException
    {
         
        if (inputArray == null ) 
        {
        	throw new IllegalArgumentException("inputArray is equal to null");
        }
        if(inputArray.length == 0)
        {
        	return -1;
        }
        
        this.intArray = inputArray;
        length = inputArray.length;
        quickSort(0, length - 1);
        return 0;
    }
    
    
   

    private void quickSort(int lowerIndex, int higherIndex) 
    {
         
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = intArray[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j)
        {
           
            while (intArray[i] < pivot)
            {
                i++;
            }
            while (intArray[j] > pivot)
            {
                j--;
            }
            if (i <= j)
            {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
        {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex)
        {
            quickSort(i, higherIndex);
    
        }
    } 
    private void exchangeNumbers(int i, int j) 
    {
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }
    
    public int sortAlphabetically(String[] inputArray)
    {
        if (inputArray == null ) 
        {
        	throw new IllegalArgumentException("inputArray is equal to null");
        }
        if(inputArray.length == 0)
        {
        	return -1;
        }
        
    	String temp = "";
    	
        for ( int j = 0;  j < inputArray.length - 1;  j++ )
        {
                if ( inputArray [ j ].compareToIgnoreCase( inputArray [ j+1 ] ) > 0 )
                {                                            
                            temp = inputArray [ j ];
                            inputArray [ j ] = inputArray [ j+1];    
                            inputArray [ j+1] = temp; 
                 } 
         } 
        this.stringArray = inputArray;
        return 0;
    }
    public int[] getIntArray()
    {
    	return this.intArray;
    }
    
    public String[] getStringArray()
    {
    	return this.stringArray;
    }
    
    private double[] findLatLng(String address)
    {
    	double[] result = new double[2];
		String bigString ="";
		int lat;
		int lng;
		String latString;
		String lngString;
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
            
            result[0] = Double.parseDouble(latString.substring(0,latString.indexOf(',')));
            result[1] = Double.parseDouble(lngString.substring(0,lngString.indexOf('}')));
            
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		
		return result;
    }
    
    public String[][] closestStores(String address)
    {
    	double[] geoCord = new double[2];
    	String hold = "";
    	
    	this.storeAddress = address;
    	geoCord = findLatLng(storeAddress);
    	hold = closestStoreString(geoCord,10);
    	
    	
    	return null;
    }
    private String closestStoreString(double[] latlng, int range)
    {
    	String result = "";
    	try
    	{
            URL oracle = new URL("http://api.target.com/v2/store?nearby="+latlng[0]+","+latlng[1]+"&range="+range+"&limit=100&locale=en-US&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
                result = result + inputLine;
            in.close();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    }
    private String getStoreId()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("ID"+2));
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    	
    }
    private String getStoreName()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("Name"+4));
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getStoreAddress()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("FormattedAddress"+16));
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getTelephone()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("TelephoneNumber"+15));
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getDistance()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("Distance"+8));
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }

    
/*    
    private void URLConnectionTest ()
    {
    	//JSONString jread;
    	try
    	{
            URL oracle = new URL("http://api.target.com/v2/products/availability?productId=070-09-0141&storeId=694&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
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
*/
}
