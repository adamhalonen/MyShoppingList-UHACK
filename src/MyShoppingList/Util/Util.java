package MyShoppingList.Util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import MyShoppingList.Driver.Driver;

//import org.json.JSONString;

public class Util {

	private int[] intArray;
    private String[] stringArray;
    private int length;
    private String storeAddress;
    private Driver driver;
    
    public Util(){}
    public Util(Driver driver)
    {
    	this.driver = driver;
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

    public String[][] closestStores(String address,int range)
    {
    	double[] geoCord = new double[2];
    	int i = 0;
    	int j = 0;
    	String[][] stores = new String[10][6];
    	
    	
    	geoCord = findLatLng(address);
    	//System.out.println(geoCord[0] + " " + geoCord[1]);
    	this.storeAddress = closestStoreString(geoCord,range);
    	
    	for(i = 0; i < 10; i++)
    	{
    		for(j = 0; j <6;j++)
    		{
    			stores[i][j] = "";
    		}
    		j = 0;
    	}
    	//System.out.println(this.storeAddress.indexOf("ID>"));
    	for(i =0;this.storeAddress.indexOf("ID>")>0 && i < 10 && j < 5;)
    	{	
    		stores[i][j] = getStoreId();
    		j++;
    		stores[i][j] = getStoreName();
    		j++;
    		stores[i][j] = getStoreAddress();
    		j++;
    		stores[i][j] = getTelephone();
    		j++;
    		stores[i][j] = getDistance();
    		j++;
    		stores[i][j] = getTotalProducts(Integer.parseInt(stores[i][0]), driver.getListPanel().getProducts());
    		i++;	
    		j = 0;
    	}
    	
    	return stores;
    }
    
    public String[][] getProductInfo(String[] products,String storeID)
    {
    	String[][] productInfo = new String[products.length][3];
    	
    	for(int i = 0;i < products.length;i++)
    	{
    		String productID = getProductID(products[i]);
    		int j = 0;
    		productInfo[i][j] = getProductName(productID);
    		j++;
    		productInfo[i][j] = getPrice(productID);
    		j++;
    		productInfo[i][j] = ((Double)getProductStock(Integer.parseInt(storeID), productID)).toString();
    	}
    	
    	return productInfo;
    	
    	
    }

    
    private String closestStoreString(double[] latlng, int range)
    {
    	String result = "";
    	try
    	{
            URL oracle = new URL("http://api.target.com/v2/store?nearby="+latlng[0]+","+latlng[1]+"&range="+range+"&limit=100&locale=en-US&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		//URL oracle = new URL("http://api.target.com/v2/store?nearby=44.976034,-93.270196&range=10&limit=100&locale=en-US&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
            {
                result = result + inputLine;
            }
            in.close();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    }
    
    private String getProductName(String productID)
    {
    	String result = "";
    	try
    	{
            URL oracle = new URL("https://api.target.com/v2/products/search?searchTerm="+productID+"&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		//URL oracle = new URL("http://api.target.com/v2/store?nearby=44.976034,-93.270196&range=10&limit=100&locale=en-US&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
            {
                result = result + inputLine;
            }
            in.close();	

    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        	
    	result = result.substring(result.indexOf("description")+15);
    	result = result.substring(0,result.indexOf('"'));
    	
    	return result;
    }
    private String getPrice(String productID)
    {
    	String result = "";
    	
    	try
    	{
            URL oracle = new URL("https://api.target.com/v2/products/search?searchTerm="+productID+"&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		//URL oracle = new URL("http://api.target.com/v2/store?nearby=44.976034,-93.270196&range=10&limit=100&locale=en-US&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
            {
                result = result + inputLine;
            }
            in.close();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	result = result.substring(result.indexOf("formattedPriceValue")+8);
    	result = result.substring(result.indexOf("formattedPriceValue")+23);
    	result = result.substring(0,result.indexOf('"'));
    	
    	return result;
    }
    private String getStoreId()
    {
    	String id;
    
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("ID")+3);
    	
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    	
    }
    private String getStoreId(String address)
    {
    	String id;
    
    	address = address.substring(address.indexOf("ID")+3);
    	
    	return address.substring(0,address.indexOf('<'));
    	
    }
    private String getStoreName()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("Name")+5);
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getStoreAddress()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("FormattedAddress")+17);
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getTelephone()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("PhoneNumber>(")+12);
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getDistance()
    {
    	String id;
    	
    	this.storeAddress = this.storeAddress.substring(this.storeAddress.indexOf("Distance")+26);
    	return this.storeAddress.substring(0,this.storeAddress.indexOf('<'));
    }
    private String getTotalProducts(int storeID,String[] products)
    {
    	int counter = 0;
    	
    	for(int i = 0; i < products.length;i++)
    	{
    		if(getProductStock(storeID,products[i])>0){counter++;}
    	}
    	return counter+"";
    }

 

    private String getProductID(String input)
    {
    	String result = "";
    	
    	try
    	{
            URL oracle = new URL("https://api.target.com/v2/products/search?searchTerm="+input+"&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		//URL oracle = new URL("http://api.target.com/v2/store?nearby=44.976034,-93.270196&range=10&limit=100&locale=en-US&key=J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF&Header=application/json");
    		URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
            {
                result = result + inputLine;
            }
            in.close();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	result = result.substring(result.indexOf("DPCI")+8);
    	result = result.substring(0,result.indexOf('"'));
    	
    	return result;
    }
	private double getProductStock(int storeId, String productId)
	{
		/*
		 * This method returns the amount of product in stock at a specified store
		 * 
		 * need proper store code and product code
		 */
		
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
			//System.out.println(portal);
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

