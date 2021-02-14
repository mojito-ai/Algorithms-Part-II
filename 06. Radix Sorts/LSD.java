/**
* <h1> LSD (Least-Significant-Digit first radix sort): LSD Radix sort </h1>
* 
* <li> Consider characters d from right to left
* <li> Stably sort using dth character as the key via key indexed sorting
* <li> Performance		Guarantee			Random			Extra Space			Stable? 			operation on keys
* <li>	LSD*				2WN				 2WN				N+R				 Yes					charAt()
* <li> For fixed length W keys
* 
* @author  Mohit Sharma
* @version 1.0
* @since   14-02-2021
* 
*/

public class LSD {

	/*
	 * Propositison: LSD sorts fixed length strings in ascending order
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
	
	/**
	 * 
	 * @param a - Array of strings
	 * @param W - fixed length strings
	 */
	public static void sort(String [] a, int W)
	{
		int R=256;		//Radix R
		int N=a.length;
		String [] aux=new String [N];
		int [] count = new int [R+1];
		
		//Do key indexed counting for each digit from right to left
		for(int d=W-1; d>=0; d--)
		{
			for(int i=0; i<N; i++)
				count[a[i].charAt(d)+1]++;
			
			for(int r=0; r<R; r++)
				count[r+1]+=count[r];
			
			for(int i=0; i<N; i++)
				aux[count[a[i].charAt(d)]++]=a[i];
			
			for(int i=0; i<N; i++)
				a[i]=aux[i];
		} //key indexed counting
	}
	
	/*
	 * This even works if keys are Binary numbers represented in a Binary word, we can break them up into groups of small
	 * number of bits, say 64 bit to 8-8bit characters or 4-16bit characters (W=4)
	 * 
	 * Sort one million 32-bit integers (Google/Presidential)
	 * LSD-String-Sort
	 * 
	 */
}
