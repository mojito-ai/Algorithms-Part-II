/**
* <h1> <b>Brute Force Substring Search:</b> Check for pattern starting at each position </h1>
* 
* <li> Pattern: A B R A
* 
* <li> i j i+j	0 1 2 3 4 5 6 7 8 9 10
* <li> 		    A B A C A D A B R A C
* <li> 0 2  2	A B R 
* <li> 1 0  2	  A	
* <li> 2 1  2	  	A B
* <li> 3 0  2	  	  A	
* <li> 4 1  2	  		A B
* <li> 5 0  2	  		  A
* <li> 6 4  2	  			A B R A
* 
* @author  Mohit Sharma
* @version 1.0
* @since   17-02-2021
* 
*/

public class SubstringBrute {
	/*
	 * 1. Performance Worst Case: Brute force algorithm can be slow if text and pattern are repetitive
	 * Worst case: ~MN char compares
	 * 
	 * 2. 
	 */
	
	/**
	 * Java's indexOf() uses this implementation
	 * <li> i=indexes into text
	 * <li> j=indexes into pattern
	 * <li> Mismatch happens at j & i+j index of pattern and text respectively.
	 * 
	 * @param pat
	 * @param txt
	 * @return
	 */
	public static int search(String pat, String txt)
	{
		int N=txt.length();
		int M=pat.length();
		for(int i=0; i<N-M; i++)
		{
			int j;
			for(j=0; j<M; j++)
			{
				if(txt.charAt(i+j)!=pat.charAt(j))
					break;
			}
			if(j==M)	return i;	// index in text where pattern starts
		}
		return N;	//not found
	}

}
