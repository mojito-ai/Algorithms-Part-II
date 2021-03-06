/**
* <h1>Strongly Connected Components: Vertices v & w are strongly connected components if there is a dedicated path
* 									 from v to w and a directed path from w to v. </h1>
* 
* <li> It is an equivalence relation: Reflexive, Transitive, Symmetric
* <li> A strong component is a maximal subset of strongly connected vertices.
* <li> A DAG with V vertices, E edges has V strongly connected components.
* <li> Kosaraju Sharir algorithm computes strong components of a digraph in time ~E+V
* 
* @author  Mohit Sharma
* @version 3.0
* @since   05-02-2021
* 
*/

public class KosarajuSharirSCC {
	/**
	 * Kosaraju Sharir Algorithm: 
	 * <li> Reverse Graph-Strong components in G are same as in G-reverse.
	 * <li> Kernel DAG-Contract each strong component into a single vertex.
	 * 
	 */
	private boolean [] marked;
	private int [] id;
	private int count;
	
	/**
	 * Idea: 
	 * <li> Phase 1: Compute reverse postorder in G-reverse. (Compute topological order in kernel DAG)
	 * <li> Phase 2: Run DFS in G, visiting unmarked vertices in reverse postorder of G-reverse
	 * @param G
	 */
	KosarajuSharirSCC(Digraph G)
	{
		marked=new boolean[G.V()];
		id=new int[G.V()];
		count=0;
		
		/*
		 * Working methods:
		 * 1. DFS in G-reverse, BFS in G
		 * 2. DFS in G, BFS in G-reverse
		 * 3. DFS in G, DFS in G-reverse
		 * 
		 */
		DepthFirstOrder dfs=new DepthFirstOrder(G.reverse());
		for(int v: dfs.reversePost())
		{
			if(!marked[v])
			{
				dfs(G,v);
				count++;
			}

		}
	}
	
	private void dfs(Digraph G, int v)
	{
		id[v]=count;
		marked[v]=true;
		for(int w:G.adj(v))
		{
			if(!marked[v])
				dfs(G,w);
		}
	}
	
	/**
	 * Are v & w in the same strong component?
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean stronglyconnected(int v, int w)
	{
		return id[v]==id[w];
	}
	
	/*
	 * Applications: 
	 * 
	 * 1. Ecological Food Webs: Vertex=Species, 
	 * 							Edge=From producer to consumer, 
	 * 							Strong Component=Subset of species with common energy flow.
	 * 
	 * 2. Software Modules: Vertex=Software Module
	 * 						Edge=From module to dependency
	 * 						Strong component=Subset of mutually interacting modules
	 * 
	 * 	- Approach 1: Package strong components together
	 * 	- Approach 2: Use to improve design
	 * 
	 */
	
	/*
	 *History:
	 *	
	 *1. 1960s: Core OR Problem
	 *			Widely studied-some practical applications, complexity not understood 
	 *
	 *2. 1972: Linear time DFS algorithm (Tarjan)
	 *		   Classic algorithm & moderately difficult. Demonstrated importance of DFS.
	 *
	 *3. 1980s: Easy two pass linear time algorithm (Kosaraju-Sharir)
	 *			Forgot notes for lecture; developed algorithm in order to teach it.
	 *
	 *4. 1990s: More easy linear time algorithms
	 *			Gabow: Fixed old OR Algorithm
	 *			Cheriyan-Mehlhorn: Needed one pass for LEDA
	 * 
	 */
}
