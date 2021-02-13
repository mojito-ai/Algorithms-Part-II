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

}
