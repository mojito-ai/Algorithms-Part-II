/**
* <h1> <b>NFA:</b> Nondeterministic finite state automaton.</h1>
* 
* <li> 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   23-02-2021
* 
*/

public class NFA {
	
	/*
	 * Duality between REs and DFAs: 
	 * 
	 * RE: Concise way to describe a set of strings.
	 * DFA: Machine to recognise whether a given string is in a given set.
	 * 
	 * 1. Kleene's Theorem: [Stephen Kleene, Princeton]
	 * -For any DFA, there exists an RE that describes the same set of strings.
	 * -For any RE, there exists a DFA that recognises the same set of strings.
	 * 
	 * 2. Pattern matching implementation: Basic plan (first attempt) - Ken Thompson
	 * 
	 * Overview is the same as for KMP
	 * -No backup in text input stream
	 * -Linear time guarantee
	 * 
	 * Underlying implementation: Deterministic finite state automata
	 * 
	 * Basic plan [Apply Kleene's theorem]
	 * -Build DFA from RE
	 * -Simulate DFA with text as input
	 * 
	 * text 				DFA for pattern
	 * AAAABD				(A*B|AC)D					accept=pattern matches text
	 * 													reject=pattern does not match text
	 * 
	 * Bad news: Basic plan is infeasible [DFA may have exponential number of states]
	 */

}
