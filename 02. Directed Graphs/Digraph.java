/**
* <h1>Directed Graph: Set of vertices connected pairwise by directed edges.</h1>
* 
* <li> Applications:
* <li> Road Network (vertex=intersection, edge=one way street)
* <li> Political Blogosphere graph (vertex=political blog, edge=link) The political blogosphere graph & the 2004 US Election-Divided they blog, Adamic & Glance
* <li> Overnight interbank loan graph (vertex=bank, edge=overnight loan) The topology of the Federal Funds Market, Bech & Atalay
* <li> Implication Graph (vertex=variable, edge=logical implication)
* <li> Combinational Circuit (vertex=logical gate, edge=wire)
* <li> Word Net (vertex=synset, edge=hypernym relationship)
* <li> The McChrystal Afghanistan Powerpoint slide
* <li> Inheritance graph (vertex=class, edge=inherits from)
* <li> Object graph (vertex=object, edge=pointer)
* <li> Web (vertex=web page, edge=hyperlink)
* 
* @author  Mohit Sharma
* @version 3.0
* @since   05-02-2021
* 
*/

/*
 * Q. How many different Digraphs can be made if there are V vertices? (Allow self loops but not parallel edges)
 * A. 2^(V*V) different Digraphs
 * 
 */
public class Digraph {
	/*
	 * Representation:
	 * 
	 * 1. Maintain a list of edges (linked list or array) = Leads to inefficiency
	 * 2. Adjacency matrix graph representation (maintain a v*v boolean array) = inefficient if V is large
	 * 3. Adjacency List graph representation = Maintain vertex indexed array of lists.
	 * 
	 * Representation			Space			Add edge 			  edge from v->w	iterate over vertices
	 * List of edges			  E					1						E					E
	 * Adjacency matrix			  V^2				1 						1					V
	 * Adjacency List			  E+V				1				   outdegree(V)			outdegree(V)
	 * 
	 */
	
	private int V;
	private Bag<Integer> [] adj; 
	
	/**
	 * Create an empty digraph with V vertices using adjacency list approach
	 * 
	 * <li>Problems:
	 * <li> Path: Is there a path from s to t?
	 * <li> Shortest Path: What is the shortest directed path from s to t?
	 * <li> Topological Sort: Can you draw the digraph with all the edges pointing upwards?
	 * <li> Transitive Closure: For which vertices v & w, is there a path from v to w?
	 * <li> Page Rank: What is the importance of a web page?
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	Digraph(int V)
	{
		this.V=V;
		adj=(Bag<Integer> [])new Bag[V];
		for(int v=0;v<V;v++)
		{
			adj[v]=new Bag<Integer>();
		}
		
	}
	
	/**
	 * Add a directed edge v->w
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	/**
	 * Vertices pointing from v
	 * @param v
	 * @return
	 */
	Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	/**
	 * Number of vertices
	 * @return
	 */
	int V()
	{
		return V;
	}
	
	/**
	 * Number of edges
	 * @return
	 */
	int E()
	{
		int edges=0;
		for(int v=0;v<V;v++)
			edges+=((Bag<Integer>)adj(v)).size();
		return edges;
	}
	
	/**
	 * Reverse of this graph
	 * @return
	 */
	Digraph reverse()
	{
		Digraph G=new Digraph(V);
		for(int v=0;v<V;v++)
		{
			for(int w:adj(v))
				G.addEdge(w, v);
		}
		return G;
	}
}
