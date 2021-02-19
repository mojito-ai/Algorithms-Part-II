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

	private final int M;
	private long RM;
	private final long Q;
	private long patHash;
	private final int R;
	
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
	 * 					3		(265*10+3)%997=659
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
