/**
* <h1> <b>Run-Length Coding</b> Removing simple type of redundancy in bitstream.</h1>
* 
* <li> Run length encoding: Simple type of redundancy in bitstream = Long runs of repeated bits.
* <li> Representation: 4 bit counts to represent alternating runs of 0s and 1s:
* 
* <li> 0000000000000001111111000000011111111111 (16 bits instead of 40)
* <li> 15 0s, then 7 1s, then 7 0s, then 11 1s.
* 
* <li> 1111 0111 0111 1011		(16 bits instead of 40)
* <li>  15	  7    7    11
* 
* @author  Mohit Sharma
* @version 1.0
* @since   26-02-2021
* 
*/

public class RunLength {

	/*
	 * Q. How many bits to store the counts?
	 * A. We will use 8 bits (but 4 in the example above)
	 * 
	 * Q. What to do when run length exceeds max count?
	 * A. If longer than 255, intersperse run of length 0.
	 */
	private static final int R = 256;
	private static final int lgR = 8;
	
	public static void compress()
	{
		
	}
	
	public static void expand()
	{
		
	}
}
