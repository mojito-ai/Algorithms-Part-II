/**
* <h1> LSD (Least-Significant-Digit first radix sort): LSD Radix sort </h1>
* 
* <li> Consider characters d from right to left
* <li> Stably sort using dth character as the key via key indexed sorting
* 
* @author  Mohit Sharma
* @version 1.0
* @since   14-02-2021
* 
*/

public class LSD {

	/*
	 * Proposition: LSD sorts fixed length strings in ascending order
	 * 
	 * Proof 1: [By induction on i]
	 * 	
	 * 		- After pass i, strings are sorted by last i characters
	 * 		- If two strings differ on sort key, key indexed sort puts them in proper relative order
	 * 		- If two strings agree on sort key, stability keeps them in proper relative order
	 * 
	 * Proof 2: [Thinking about the past]
	 * 
	 * 		- If two strings differ on first character, key indexed sort puts them in proper relative order
	 * 		- If two strings agree on first character, stability keeps them in proper relative order
	 * 
	 * Proof 3: [Thinking about the future]
	 * 
	 * 		- If the characters not yet examined differ, it doesen't matter what we do now.
	 * 		- If the characters not yet examined agree, stability ensures later pass won't affect order.
	 * 
	 */
	
	public static void sort(String [] a, int W)
	{
		
	}
}
