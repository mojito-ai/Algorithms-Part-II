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
* @version 3.0
* @since   24-02-2021
* 
*/

/*
 * Non determinism: 
 * 
 * One view: Machine can guess the proper sequence of state transitions
 * Alternate view: Sequence is a proof that the machine accepts the text.
 * 
 * 		   /---\	   /-----------\
 * 0-->1-->2-->3-->4-->5-->6-->7-->8-->9-->10-->11			NFA corresponding to pattern ((A*B|AC)D)
 * (   (   A   *   B   |   A   C   )   D    )	
 * 	    \   \---/         /
 *       \---------------/
 * 
 * Q. How to to determine whether a string is matched by automaton?
 * A. DFA-Deterministic: Easy because exactly one transition state applicable.
 * 	  NFA-Nondeterministic: Can be several applicable transitions; need to select right one.
 */
public class NFA {
	private final int M;	//match transitions
	private Digraph G;		//epsilon transitions digraph
	private final char [] re;	//number of states
	
	/**
	 * State names: Integers from 0 to M
	 * <li> Match Transitions: Keep regular expression in array re[] (implicit)
	 * <li> Epsilon transitions: Store in a digraph G
	 * <li> Maintain set of all possible states that NFA could be in after reading in the first i text characters
	 * @param regex
	 */
	NFA(String regex)
	{
		M=regex.length();
		re=regex.toCharArray();
		G=buildEpsilonTransitionDigraph();
	}
	
	/**
	 * Goal: Check whether input matches pattern
	 * <li> Read states reachable by match transitions 
	 * <li> Find states reachable by epsilon transitions
	 * <li> When no input characters
	 * <li> Accept if any state reachable is an accept state.
	 * <li> Reject otherwise
	 * @param txt
	 * @return
	 */
	
	/*
	 * NFA Simulation : Analysis
	 * 
	 *  Proposition: Determining whether an N-character text is recognised by the NFA corresponding to an M-character pattern
	 *  			 takes time proportional to MN in the worst case
	 *  
	 *  Proof: For each of the N-text characters, we iterate through a set of states of size no more than M and run DFS on
	 *  	   the graph of epsilon transitions. [The NFA construction we will consider ensures the number of edges on each node
	 *  	   <=3]
	 * 
	 */
	public boolean recognizes(String txt)
	{
		Bag<Integer> pc = new Bag<>();		//program counter
		DirectedDFS dfs = new DirectedDFS(G,0);	//Runs proportional to E+V
		for(int v=0; v<G.V(); v++)		//states reachable from start by epsilon transitions
			if(dfs.hasPathTo(v))
				pc.add(v);
		
		for(int i=0; i<txt.length(); i++)
		{
			Bag<Integer> match = new Bag<>();
			for(int v : pc)			// states reachable after scanning past txt.charAt(i)
			{
				if(v==M)	continue;
				if(re[v]==txt.charAt(i) || re[v]=='.')	//wildcard
					match.add(v+1);
			}
			
			dfs=new DirectedDFS(G, match);
			pc=new Bag<>();
			for(int v=0; v<G.V(); v++)		//follow epsilon transitions
				if(dfs.hasPathTo(v))
					pc.add(v);
		}
		
		for(int v : pc)
			if(v==M)	return true;		//accept if can end in state M
		return false;
	}
	
	/**
	 * Goal: Write a program to build epsilon transition edges
	 * <li> Challenges : Remember left parenthesis to implement closure and or; remember | to implement or.
	 * <li> Concatenation: Add match transition edge from state corresponding to characters in the alphabet to next state.
	 * <li> Closure: Add three epsilon transition edges for each * operator.
	 * <li> Parenthesis: Add epsilon transition edges from parenthesis to next state.
	 * <li> OR: Add two epsilon transition edges for each | operator
	 * @return
	 */
	private Digraph buildEpsilonTransitionDigraph()
	{
		Digraph G = new Digraph(M+1);
		/*
		 *Maintain a stack
		 *1. ( symbol : push ( onto stack
		 *2. | symbol : push | onto stack
		 *3. ) symbol : pop corresponding ( and possibly intervening |
		 *Add epsilon transition edges for closure/or
		 */
		Stack<Integer> ops = new Stack<>();
		for(int i=0; i<M; i++)
		{
			int lp=i;
			
			//left parenthesis and |
			if(re[i]=='(' || re[i]=='|')
				ops.push(i);
			
			else 
				if(re[i]==')')
			{
				int or=ops.pop();
				if(or=='|')			//or
				{
					lp=ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				}
				else	lp=or;
			}
			
			//Closure (needs 1 character lookout)
			if(i<M-1 && re[i+1]=='*')
			{
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			
			//metasymbols
			if(re[i]=='(' || re[i]=='*' || re[i]==')')
				G.addEdge(i, i+1);
		}
		
		return G;
	}
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
