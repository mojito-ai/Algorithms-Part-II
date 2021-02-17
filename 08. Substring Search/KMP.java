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
* @since   17-02-2021
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
	 */

}
