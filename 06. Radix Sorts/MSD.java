/**
* <h1>MSD (Most-Significant-Digit first radix sort)</h1>
* 
* <li> Partition file into R pieces according to first character (use key indexed counting)
* <li> Recursively sort all strings that start with each character (key indexed counts delineate files to sort)
* <li> MSD is like a generalisation of QuickSort
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
		
		int [] count = new int[R+2];
		
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
	
	private static void Insertion(String [] a, int lo, int hi, int d)
	{
		
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

}
