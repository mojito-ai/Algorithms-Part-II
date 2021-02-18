/**
* <h1> <b>Boyer-Moore:</b> Mismatched character heuristic  </h1>
* 
* <li> Robert Boyer & J. Strother Moore
* <li> Intuition: 
* <li> Scan characters in pattern from right to left.
* <li> Can skip as many as M text chars when finding one not in pattern
* 
* @author  Mohit Sharma
* @version 1.0
* @since   18-02-2021
* 
*/

public class BoyerMoore {
	
	/*
	 * E.g. i	j	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21
	 * txt->		F	I	N	D	I	N	A	H	A	Y	S	T	A	C	K	N	E	E	D	L	E	T
	 * 		0	5	N	E	E	D	L	E
	 * 		5	5						N	E	E	D	L	E
	 * 		11	4												N	E	E	D	L	E
	 * 		15	0																N	E	E	D	L	E	
	 * 
	 * 
	 * How much to skip?
	 * 
	 * Case 1: Mismatched character not in pattern: Increment i one character beyond the present txt character
	 * Case 2a: Mismatched character in pattern: Align txt char with rightmost pattern char
	 * Case 2b: Mismatched character in pattern (but heuristic no help) : If heuristic cause backup, just increment pointer by 1
	 *
	 */
	
	private final int [] right;
	private final int R=256;
	private final String pat;
	private final int M;
	
	/**
	 * Precompute index of rightmost occurance of character c in pattern (-1 if character not in pattern)
	 * @param pattern
	 */
	public BoyerMoore(String pattern)
	{
		this.pat=pattern;
		M=pat.length();
		right=new int[R];
		
		for(int c=0; c<R; c++)
			right[c]=-1;
		
		for(int i=0; i<M; i++)
			right[pat.charAt(i)]=i;	//storing rightmost occurance of char in pattern
		
	}
	
	/**
	 * 
	 * @param txt
	 * @return
	 */
	public int search(String txt)
	{
		int N=txt.length();
		int skip;
		
		for(int i=0; i<N; i+=skip)
		{
			skip=0;
			for(int j=M-1; j>=0; j--)
			{
				if(pat.charAt(j)!=txt.charAt(i+j)) //compute skip value
				{
					skip=Math.max(1, j-right[txt.charAt(i+j)]);	//incase other term is non-positive (backing up)
					break;
				}
			}
			if(skip==0)		return i;	//match
		}
		return N;
	}
}
