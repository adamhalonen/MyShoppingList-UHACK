package MyShoppingList.Util;

public class Util {


    private int array[];
    private int length;
    
    public static void main(String a[])
    {
         
        Util sorter = new Util();
        String[] input = {"Nick","Nack"};
        sorter.sortAlphabetically(input);
        for(int i = 0; i < input.length; i++)
        {
            System.out.println(input[i]);
        }
    }

 
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
}
