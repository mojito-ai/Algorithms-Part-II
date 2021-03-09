/**
* <h1> Hamilton Path: Find a simple path that visits every vertex exactly once </h1> 
* 
* <li> Also called longest simple path in a graph
* <li> Proposition. [Shor 1994] Can factor an n-bit integer in n3 steps on a "quantum computer.”
* <li> Q. Do we still believe the extended Church-Turing thesis???
* 
* @author  Mohit Sharma
* @version 2.0
* @since   09-03-2021
* 
*/

public class HamiltonPath {

	/*
	 * Exploiting intractability
	 * Modern cryptography.
	 * 		Ex. Send your credit card to Amazon.
	 * 		Ex. Digitally sign an e-document.
	 * 			Enables freedom of privacy, speech, press, political association.
	 * 
	 * RSA cryptosystem.
	 * To use: multiply two n-bit integers. [poly-time]
	 * To break: factor a 2 n-bit integer. [unlikely poly-time]
	 * 
	 * 
	 * Challenge. Factor this number.
	 * 
	 * 740375634795617128280467960974295731425931888892312890849362
	 * 326389727650340282662768919964196251178439958943305021275853
	 * 701189680982867331732731089309005525051168770632990723963807
	 * 86710086096962537934650563796359
	 * RSA-704
	 * ($30,000 prize if you can factor)
	 * 
	 * Can't do it? Create a company based on the difficulty of factoring.
	 */
	
	private boolean [] marked;	//vertices on current path
	@SuppressWarnings("unused")
	private int count=0;		//number of Hamiltonian path
	
	public HamiltonPath(Graph G)
	{
		marked=new boolean[G.V()];
		for(int v=0; v<G.V(); v++)
			dfs(G,v,1);
	}
	
	private void dfs(Graph G, int v, int depth)	//length of current path (depth of recursion)
	{
		marked[v]=true;
		if(depth==G.V())
			count++; //found one
		
		for(int w: G.adj(v))
			if(!marked[w])
				dfs(G,w,depth+1);	//backtrack if w is already a part of path
		
		marked[v]=false;	//clean up (for all possible paths)
	}
	
	/*
	 * Coping with intractability
	 * 1. Relax one of desired features.
	 * 
	 *	  Special cases may be tractable.
	 *	  Ex: Linear time algorithm for 2-SAT.		--> at most two variables per equation
	 *	  Ex: Linear time algorithm for Horn-SAT.	--> at most one un-negated variable per equation
	 * 
	 * 2. Solve the problem to optimality
	 * 
	 * 	  Develop a heuristic, and hope it produces a good solution.
	 * 	  No guarantees on quality of solution.
	 * 	  Ex. TSP assignment heuristics.
	 * 	  Ex. Metropolis algorithm, simulating annealing, genetic algorithms.
	 * 
	 * 	  Approximation algorithm. Find solution of provably good quality.
	 * 	  Ex. MAX-3SAT: provably satisfy 87.5% as many clauses as possible.	
	 * 
	 * 3. Solve the problem in poly-time.
	 * 
	 * 	  Complexity theory deals with worst case behavior.
	 * 	  Instance(s) you want to solve may be "easy."
	 * 	  Chaff solves real-world SAT instances with ~ 10K variable.
	 */
}
