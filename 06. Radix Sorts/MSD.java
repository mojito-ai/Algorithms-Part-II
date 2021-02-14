/**
* <h1>MSD (Most-Significant-Digit first radix sort)</h1>
* 
* <li> Partition file into R pieces according to first character (use key indexed counting)
* <li> Recursively sort all strings that start with each character (key indexed counts delineate files to sort)
* <li> MSD is like a generalisation of QuickSort
* <li> MSD Performance: Potential for disastrous performance
* <li> Much too slow for small subarrays
* <li> Each function call needs its own count [] array
* <li> ASCII (256 counts) : 100x slower than copy pass for N-2
* <li> UNICODE (65536 counts) : 32000x slower for N-2
* <li> Huge number of small subarrays because of recursion
* 
* @author  Mohit Sharma
* @version 2.0
* @since   14-02-2021
* 
*/

public class MSD {
	private static int R = 256; // radix
	private static final int M = 15; // cutoff for small subarrays
	private static String[] aux; // auxiliary array for distribution
	
	public static void sort (String [] a)
	{
		aux=new String[a.length];
		sort(a,aux,0,a.length-1,0);
	}
	
	//can recycle aux [] array but not count [] array 
	private static void sort(String [] a, String [] aux, int lo, int hi, int d)
	{
		if (hi <= lo + M)
		 { 
			Insertion(a, lo, hi, d); 
			return; 
		 }
		
		int [] count = new int[R+2];	//extra -1 at the end of each string
		
		for(int i=lo; i<=hi; i++)
			count[charAt(a[i],d) + 2]++;
		
		for(int r=0; r<R+1; r++)
			count[r+1]+=count[r];
		
		for(int i=lo; i<=hi; i++)
			aux[count[charAt(a[i],d)+1]++]=a[i];
		
		for(int i=lo; i<=hi; i++)
			a[i]=aux[i-lo];
		
		//sorting R sub-arrays recursively
		for(int r=0; r<R; r++)
			sort(a, aux, lo+count[r], lo+count[r+1]-1, d+1);

	}
	
	/**
	 * Cutoff to insertion sort for smaller subarrays
	 * <li> Insertion sort but start at dth character
	 * <li> Implement less() so that it compares starting at dth character
	 * @param a
	 * @param lo
	 * @param hi
	 * @param d
	 */
	private static void Insertion(String [] a, int lo, int hi, int d)
	{
		for(int i=lo; i<=hi; i++)
			for(int j=i; j>=0 && less(a[j],a[j-1],d); j--)
				exch(a,j,j-1);
	}
	
	private static void exch(String [] a, int i, int j)
	{
		String swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	
	//In java, forming and comparing subarrays is faster than directly comparing with charAt()
	private static boolean less(String v, String w, int d)
	{
		return v.substring(d).compareTo(w.substring(d))<0;
	}
	
	/**
	 * Variable length strings: Treat strings as if they had an extra char at the end (smaller than any char)
	 * 
	 * <li> C strings have an extra char \0 at the end so no extra -1 needed.
	 * @param s
	 * @param d
	 * @return
	 */
	private static int charAt(String s, int d)
	{
		if(d<s.length())	return s.charAt(d);
		else				return -1;
	}
	
	/*
	 * Performance: Dependent on data
	 * Number of characters examined
	 * 1. MSD examines just enough characters to sort the keys
	 * 2. Number of characters examined depends on the keys.
	 * 3. Can be sublinear in input size!
	 * 
	 * Algorithm		guarantee			random			extraspace			stable?			operation on keys
	 * MSD*				 2NW				 NlogᵣN				N+DR			  yes				charAt()		* average length W keys
	 * 
	 * MSD String sort vs MSD Quick sort
	 * 
	 * 1. Disadvantadge of MSD Quick sort
	 * 
	 * 	- Access memory "randomly" (insufficient cache)
	 * 	- Inner loop has a lot of characters
	 * 	- Extra space for count []
	 * 	- Extra space for aux []
	 * 
	 * 2. Disadvantadge of Quick sort
	 * 	
	 * 	- Linearithemetic number of string compares (not linear)
	 * 	- Has to reason many characters in keys with long prefix matches
	 */

}
