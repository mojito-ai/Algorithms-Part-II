import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

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
* @version 2.0
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
	private static final int R = 256;	//maximum run length count
	private static final int lgR = 8;	//no of bits per count
	
	/**
	 * An application: Compress a bitmap
	 * <li> Typical black-and-white-scanned image.
	 * <li> 300 pixels/inch.
	 * <li> 8.5-by-11 inches.
	 * <li> 300 × 8.5 × 300 × 11 = 8.415 million bits.
	 * 
	 * <li> Observation. Bits are mostly white.
	 * <li> Typical amount of text on a page.
	 * <li> 40 lines × 75 chars per line = 3,000 chars.
	 */
	public static void compress()
	{
		char cnt=0;
		boolean b, old = false;
		while(!BinaryStdIn.isEmpty())
		{
			b=BinaryStdIn.readBoolean();
			if(b!=old)
			{
				BinaryStdOut.write(cnt);
				old=!old;
				cnt=0;
			}
			
			if(cnt==R-1)
			{
				BinaryStdOut.write(cnt);
				cnt=0;
				BinaryStdOut.write(cnt);
			}
			cnt++;
		}
		BinaryStdOut.write(cnt);
		BinaryStdOut.close();
	}
	
	/**
	 * Q. What is the smallest compression ratio using run length coding with 8 bit run length
	 * <li> A. 8/255
	 */
	public static void expand()
	{
		boolean bit=false;
		while(!BinaryStdIn.isEmpty())
		{
			char run = BinaryStdIn.readChar(lgR);	//read 8 bit count from standard input
			for(int i=0; i<run; i++)
				BinaryStdOut.write(bit);	//write 1 bit to standard output
			bit=!bit;
		}
		BinaryStdOut.close();	//pad 0s for byte alignment
	}
}
