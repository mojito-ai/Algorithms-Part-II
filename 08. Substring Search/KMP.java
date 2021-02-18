import edu.princeton.cs.algs4.In;

/**
* <h1> <b>Knuth-Morris-Pratt: </b> Ingenious way to do substring search without backup. </h1>
* 
* <li> Suppose that we are searching in text for pattern BAAAAAAAAA
* <li> Suppose we match 5 chars in pattern, with mismatch on 6th char
* <li> We know previous 6 chars are BAAAAB
* <li> Don't need to backup pointer completely.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   18-02-2021
* 
*/

public class KMP {
	
	/*
	 * Deterministic Finite State Automaton (DFA): DFA is abstract string searching machine
	 * 
	 * 1. Finite number of states (including start and halt)
	 * 2. Exactly one transition state for each char in alphabet.
	 * 3. Accept if sequence of transitions leads to halt state
	 * 
	 * 	Internal Representation: 
	 * 
	 * 			j		0	1	2	3	4	5				If in state j, reading the char c: 
	 * 	pat.charAt(j)	A	B	A	B	A	C				If j is 6 halt and accept
	 * 														else move to state dfa[c][j]
	 * 			A		1	1	3	1	5	1	
	 * 			B		0	2	0	4	0	4
	 * 			C		0	0	0	0	0	6
	 * 
	 */
	
	/*
	 * Interpretation of KMP DFA:
	 * 
	 * 1. What is interpretation of DFA state after reading in txt[i]
	 *	  State = Number of characters in pattern that have been matched.
	 *
	 * 2. State is the length of the longest prefix of pat[] that is a suffix of txt[0....i]
	 * 
	 * e.g. DFA in state 3 after reading in txt[0...6]
	 * 		
	 * 								i
	 * 		0	1	2	3	4	5	6	7	8					0	1	2	3	4	5
	 * txt	B	C	B	A	A	B	A	c	a		pattern		A	B	A	b	a	c
	 */
	
	/**
	 * Key differences from brute force implementation
	 * <li> Need to precompute dfa[][] from pattern
	 * <li> Text pointer i never decrements
	 * 
	 * @param txt
	 * @return
	 */
	public int search(String txt)
	{
		int N=txt.length();
		for(int i=0, j=0; i<N && j<M; i++)
			j=dfa[txt.charAt(i)][j];		//no backup
		if(j==M)	return i-M;
		else		return N;
	}
	
	/**
	 * Could use input stream (since there is no backup)
	 * 
	 * @param in
	 * @return
	 */
	public int search(In in)
	{
		for(int i=0, j=0; !in.isEmpty() && j<M; i++)
			j=dfa[in.readChar()][j];		//no backup
		if(j==M)	return i-M;
		else		return NOT_FOUND;
	}
	
	/*
	 * Running time: Simulate DFA on text: At most N character accesses
	 * Build DFA: How to do efficiently
	 * 
	 */

}
