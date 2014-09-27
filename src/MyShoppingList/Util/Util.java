package MyShoppingList.Util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//import org.json.JSONString;

public class Util {


    private int array[];
    private int length;
    
    public int sort(int[] inputArray) throws IllegalArgumentException
    {
         
        if (inputArray == null ) 
        {
        	throw new IllegalArgumentException("inputArray is equal to null");
        }
        if(inputArray.length == 0)
        {
        	return -1;
        }
        
        this.array = inputArray;
        length = inputArray.length;
        quickSort(0, length - 1);
        return 0;
    }
   

    private void quickSort(int lowerIndex, int higherIndex) 
    {
         
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j)
        {
           
            while (array[i] < pivot)
            {
                i++;
            }
            while (array[j] > pivot)
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
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private int sortAlphabetically(String[] inputArray)
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
        
        return 0;
    }
    
    
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
    
    private void geoCoding()
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
