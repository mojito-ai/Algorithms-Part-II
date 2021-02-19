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
	 */
}
