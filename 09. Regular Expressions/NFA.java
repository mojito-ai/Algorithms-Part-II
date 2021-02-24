/**
* <h1> <b>NFA:</b> Nondeterministic finite state automaton.</h1>
* 
* <li> Regular expression matching NFA
* <li> RE enclosed in parenthesis
* <li> One state per RE character (start=0, accept=M)
* <li> Red ε-transition (change state, but don't scan text)
* <li> Black match transition (change state and scan to next text char)
* <li> Accept if any sequence of transitions ends in accept state (after scanning all text characters)
* 
* @author  Mohit Sharma
* @version 1.0
* @since   24-02-2021
* 
*/

/*
 * Non determinism: 
 * 
 * One view: Machine can guess the proper sequence of state transitions
 * Alternate view: Sequence is a proof that the machine accepts the text.
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
	 * 
	 * 
	 * 3. Pattern matching implementation: Basic plan (revised attempt)
	 * 
	 * Overview is the same as for KMP
	 * -No backup in text input stream
	 * -Quadratic time guarantee (linear time typical)
	 * 
	 * Underlying implementation: NonDeterministic finite state automata
	 * 
	 * Basic plan [Apply Kleene's theorem]
	 * -Build NFA from RE
	 * -Simulate NFA with text as input
	 * 
	 * text 				NFA for pattern
	 * AAAABD				(A*B|AC)D					accept=pattern matches text
	 * 													reject=pattern does not match text
	 * 
	 */

}
