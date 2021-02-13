/**
* <h1>Key-Indexed Counting: Keys are integers between 0 & R-1 and can use them as array index</h1>
* 
* <li> Summary of the performance of sorting algorithms (frequency of operations = key compares)
* <li> Algorithm		Guarantee		Random		ExtraSpace		Stable? 		operation on keys
* 
* <li> Insertion		N^2/2			 N^2/4			1			 Yes				compareTo()
* <li> Mergesort		NlgN			NlgN			N			 Yes				compareTo()
* <li> Quicksort		1.39NlgN *		1.39NlgN		1			 No					compareTo()		* = probabilistic
* <li> HeapSort			2NlgN			2NlgN			1			 No					compareTo()
* 
* <li> Lower bound = ~NlgN compares required by any compare based algorithm
* @author  Mohit Sharma
* @version 1.0
* @since   13-02-2021
* 
*/

public class KeyIndexedCounting {
	
	/*
	 *1. Assumption: Keys are integers between 0 & R-1
	 *2. Implication: Can use key as an array index
	 *
	 *3. Applications: 
	 *					- Sort string by first letter
	 *					- Sort class roster by section
	 *					- Sort phone number by area code
	 *					- Subroutine in a sorting algorithm
	 *
	 *4. Remark: Keys may have associated data => Can't just count the number of keys of each value.
	 *
	 */
	
	/**
	 * Sort an array a[] of N integers between 0 & R-1
	 * @param a
	 * @param R
	 * @return
	 */
	public static int [] sort(int [] a, int R)
	{
		int N=a.length;
		int [] count = new int [R+1];
		int [] aux=new int [N];
		
		for(int i=0; i<N; i++)
			count[a[i]+1]++;
		
		for(int r=0; r<R; r++)
			count[r+1]+=count[r];
		
		for(int i=0; i<N; i++)
			aux[count[a[i]]++]=a[i];
		
		for(int i=0; i<N; i++)
			a[i]=aux[i];
		
		return a;
	}

}
