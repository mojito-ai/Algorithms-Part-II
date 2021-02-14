/**
* <h1>MSD (Most-Significant-Digit first radix sort)</h1>
* 
* <li> Partition file into R pieces according to first character (use key indexed counting)
* <li> Recursively sort all strings that start with each character (key indexed counts delineate files to sort)
* <li> MSD is like a generalisation of QuickSort
* 
* @author  Mohit Sharma
* @version 1.0
* @since   14-02-2021
* 
*/

public class MSD {
	
	public static void sort (String [] a)
	{
		
	}
	
	private static void sort(String [] a, String [] aux, int lo, int hi, int d)
	{
		
	}
	
	/**
	 * Variable length strings: Treat strings as if they had an extra char at the end (smaller than any char)
	 * 
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
