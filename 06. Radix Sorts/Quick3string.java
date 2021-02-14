/**
* <h1>3-Way Radix Quicksort: Bentley and Sedgewick 1997</h1>
* 
* <li> Do 3-way partitioning on the dth character
* <li> Less overhead than R-way partitioning in MSD String sort
* <li> Does not re-examine characters equal to the partitioning char (but does re-examine characters not equal to the partitioning char)
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   14-02-2021
* 
*/
public class Quick3string {

	public static void sort(String [] a)
	{
		sort(a, 0, a.length-1, 0);
	}
	
	private static void sort(String [] a, int lo, int hi, int d)
	{
		if(hi<=lo)	return;
		
		int lt=lo, gt=hi;
		int i=lo+1;
		int v=charAt(a[lo],d);		//3 way partitioning using the dth character
		
		while(i<=gt)
		{
			int t=charAt(a[i],d);			// to handle variable length strings
			if(t<v)			exch(a,lt++, i++);
			else if(t>v)	exch(a,i, gt--);
			else 			i++;
		}
		
		sort(a,lo,lt-1,d);
		if(v>=0)	sort(a,lt,gt,d+1);		// sort 3 subarrays recursively
		sort(a,gt+1,hi,d);
	}
	
	private static int charAt(String s, int d)
	{
		if(d<s.length())	return s.charAt(d);
		else				return -1;
	}
	
	private static void exch(String [] a, int i, int j)
	{
		String swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	
	/*
	 * 3 way string quicksort vs Standard quicksort
	 * 
	 * 1. Standard Quicksort
	 * 		- Uses 2NlnN string compares on average
	 * 		- Costly for keys with long common prefix 
	 * 
	 * 2. 3 way string (radix) quick sort
	 * 		- Uses ~2NlnN character compares on average for random string
	 * 		- Avoiding recomparing long common prefixes
	 * 
	 */
}
