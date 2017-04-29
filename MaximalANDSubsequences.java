import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;

public class Solution {
  public static long[][] result = new long[15][15]; 
  static int flag,count=1;
  static long set=0,col=0,max=-1;
  
  
static void combinationUtil(long arr[], long data[], int start, int end, int index, int r)
	{
		// Current combination is ready to be printed, print it
		if (index == r)
		{
			
			for (int j=0; j<r; j++){
			    if(flag==0){
			        result[(int)(set)][(int)(col)]=data[j];
			        flag=1;
			    }
			    else{
			        result[(int)(set)][(int)(col)]&=data[j];  //=performAnd(data[j],result[set][col]);
			    }
			}
			
			if(result[(int)(set)][(int)(col)]>max)
			    max=result[(int)(set)][(int)(col)];
			else if(result[(int)(set)][(int)(col)]==max)
			    count+=1;
			    
			set+=1;
			flag=0;
		    return;
		}

		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(long arr[], int n, int r)
	{
		// A temporary array to store all combination one by one
		long data[]=new long[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n-1, 0, r);
	}
	
	

	/*Driver function to check for above function*/
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		long[] arr = new long[n];
		
		for(int k=0; k<n; k++)
		    arr[k]=sc.nextLong();
		printCombination(arr, n, r);
	
        
        System.out.println(max); 
        System.out.println((int)(count%(Math.pow(10,9)+7)));
	}

}
