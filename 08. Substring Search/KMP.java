import edu.princeton.cs.algs4.In;

/**
* <h1> <b>Knuth-Morris-Pratt: </b> Ingenious way to do substring search without backup. </h1>
* 
* <li> Suppose that we are searching in text for pattern BAAAAAAAAA
* <li> Suppose we match 5 chars in pattern, with mismatch on 6th char
* <li> We know previous 6 chars are BAAAAB
* <li> Don't need to backup pointer completely.
* 
* <li> Running time: M character accesses (but space/time ~ RM)
* <li> Proposition: KMP Substring search accesses no more than M+N chars to search for a pattern of length M in a text of length N.
* <li> Proof: Each pattern character accessed once when constructing the DFA, each text char accessed once (in worst case) when simulating the DFA 
* 
* @author  Mohit Sharma
* @version 2.0
* @since   18-02-2021
* 
*/

public class KMP {
	
	private final int R=256;		//Radix
	private final int M;			//Length of pattern
	private final int NOT_FOUND=999999999;	//NOT_FOUND incase of input stream
	private final int [] [] dfa;		//Deterministic Finite State Automaton
	private final String pat;	//Pattern
	
	/**
	 * DFA Construction Demo: Include one state for each character in pattern (plus accept state)
	 * 
	 * 1. Match Transistion: If in state j (first j characters have already been matched) and next char==pat.charAt(j), goto j+1
	 * 2. Mismatch Transistion: Backup if c!=pat.charAt(j). It also means that the last j-1 characters of input are pat[1...j-1] followed by a c 
	 * 
	 * <li> To compute dfa[c][j]: Simulate pat[1.....j-1] on DFA and take transistion c
	 * <li> Running time: Seems to take j steps everytime
	 * <li> To overcome running time , we simulate pat[1....j-1] on DFA and take transistion c. And save state X.
	 * <li> Running time reduces to constant time on maintaining state X.
	 * 
	 * @param pattern
	 */
	public KMP(String pattern)
	{
		this.pat=pattern;
		M=pat.length();
		dfa=new int [R][M];
		
		dfa[pat.charAt(0)][0]=1;
		
		for(int X=0, j=1; j<M; j++)
		{
			for(char c=0; c<R; c++)
				dfa[c][j]=dfa[c][X];		//copy mismatch cases
			dfa[pat.charAt(j)][j]=j+1;		//set match case
			X=dfa[pat.charAt(j)][X];		//update restart state
		}
	}
	
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
		int i, j, N=txt.length();
		for(i=0, j=0; i<N && j<M; i++)
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
		int i, j;
		for(i=0, j=0; !in.isEmpty() && j<M; i++)
			j=dfa[in.readChar()][j];		//no backup
		if(j==M)	return i-M;
		else		return NOT_FOUND;
	}
	
	/*
	 * Running time: Simulate DFA on text: At most N character accesses
	 * Build DFA: How to do efficiently
	 * 
	 */

	/*
	 * 1. Non-deterministic finite state automaton (NFA) : Used when larger alphabets. Improved version of KMP constructs nfa[] in time and space ~ M
	 * Can have multiple hops and either success or failure states.
	 * 
	 * 2. History: Theory meets practise (Fast pattern matching in strings)
	 * Independently discovered by two theoreticians and a hacker
	 * 
	 * 		- Knuth: Inspired by esoteric theorem (by Steve Cook), discovered linear algorithm
	 * 		- Pratt: Made running time independent of alphabet size
	 * 		- Morris: Built a text editor for the CDC 6400 Computer
	 */
}
