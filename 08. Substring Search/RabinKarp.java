/**
* <h1> <b>Rabin-Karp Fingerprint Search:</b> Basic idea of modular hashing. Easiest to think in context of numbers although
* 											 it works in all kinds of situations as everything is encoded as a bit which can
* 											 be treated as binary numbers.</h1>
* 
* <li> Michael Rabin, Turing Award '76
* <li> Dick Karp, Turing Award '85
* <li> Compute a hash of pattern characters 0 to M-1.
* <li> For each i, compute a hash of text characters i to M+i-1
* <li> If pattern hash = text substring hash, check for a match
* 
* @author  Mohit Sharma
* @version 1.0
* @since   19-02-2021
* 
*/

public class RabinKarp {

	private final int M;	//pattern length
	private long RM;		//R^(M-1) % Q
	private final long Q;	//modulus
	private long patHash;	//pattern hash value
	private final int R;	//Radix
	
	/**
	 * How to efficiently compute xi+1 given that we know xi
	 * 
	 * 		xi=ti * R^(M-1) + ti+1 * R^(M-2) + -------- + ti+M-1 * R^0	(mod Q)
	 * 	 xi+1=ti+1 *R^(M-1) + ti+2 * R^(M-2) + -------- + ti+M * R^0	(mod Q)
	 * 
	 * Key property: Can update hash function in constant time
	 * 
	 * 		xi+1=(xi-ti*R^(M-1))R + ti+M
	 * 
	 * pattern		0	1	2	3	4	5	6	7	8	9	10	11	12	13		R=10	Q=997
	 * 				3	1	4	1	5	9	2	6	5	3	5	8	7	9
	 * 
	 * 		0		3-->3%997=3
	 * 		1		3	1-->(3*10+1)%997=31
	 * 		2		3	1	4-->(31*10+4)%997=314
	 * 		3		3	1	4	1-->(314*10+1)%997=150
	 * 		4		3	1	4	1	5-->(150*10+5)%997=508
	 * 		5			1	4	1	5	9-->((508+3(997-30))10+9)%997=201
	 * 		6				4	1	5	9	2-->((201+1(997-30))10+2)%997=715
	 * 		7					1	5	9	2	6-->((715+4(997-30))10+6)%997=971
	 * 		8						5	9	2	6	5-->((971+1(997-30))10+5)%997=442
	 * 		9							9	2	6	5	3-->((442+5(997-30))10+3)%997=929
	 * 		10								2	6	5	3	5-->((929+9(997-30))10+5)%997=613
	 * 
	 * return i-M+1=6
	 * @param pat
	 */
	RabinKarp(String pat)
	{
		
	}
	
	/*
	 * 1. Efficiently computing the hash function
	 * 
	 * - Modular hash function: Use the notation of ti for txt.charAt(i), we wish to compute
	 * 	
	 * 							xi=ti * R^(M-1) + ti+1 * R^(M-2) + -------- + ti+M-1 * R^0	(mod Q)
	 * 
	 * - Intuition: M-digit, base-R, modulo Q
	 * 
	 * - Horner's Method: Linear time method to evaluate M degree polynomial
	 * 
	 * E.g. 		pattern		0	1	2	3	4		R=10	Q=997
	 * 							2	6	5	3	5
	 * 
	 * 					0		2%997=2
	 * 					1		(2*10+6)%997=26
	 * 					2		(26*10+5)%997=265
	 * 					3		(265*10+3)%997=659				Basically we throw away multiples of 997 that we dont care about
	 * 					4		(659*10+5)%997=613
	 */
	
	//Compute hash for M digit key
	private long hash(String key, int M)
	{
		long h=0;
		for(int i=0; i<M; i++)
			h = (R * h + key.charAt(i)) % Q;
		return h;
	}
	
	public int search(String txt)
	{
		
	}
}
