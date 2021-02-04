import edu.princeton.cs.algs4.Bag;

/**
* <h1>Undirected Graphs: Set of vertices connected pairwise by edges. Challenging branch of computer science</h1>
* 
* <li> Applications:
* <li> Protein-Protein Interaction Network
* <li> The Internet as mapped by the Opte Project
* <li> Map of science clickstreams
* <li> Visualising friendships by Paul Butler
* <li> Enron Email dataset
* <li> The evolution of FCC-lobbying coalition
* <li> Framingham Heart Study
* <li> Graph=Neural Network, Vertex=Neuron, Edge=Synapse
* 
* @author  Mohit Sharma
* @version 3.0
* @since   04-02-2021
* 
*/

/*
 * Graph Terminology:
 * 
 * 1. Path: Sequence of vertices connected by edges. Is there a path between s & t?
 * 2. Cycle: Path whose first and last vertices are the same. Is there a cycle in the graph?
 * 3. Shortest path: What is the shortest path between s & t?
 * 4. Euler Tour: Is there a cycle that uses each edge exactly once?
 * 5. Hamilton Tour: Is there a cycle that uses each vertex exactly once?
 * 6. Connectivity: Is there a way to connect all of the verteices?
 * 7. MST: What is the best way to connect all of the vertices?
 * 8. Bi-connectivity: Is there a vertex whose removal disconnects the graph?
 * 9. Planarity: Can you draw the graph with no crossing edges?
 * 10. Graph Isomerism: Do two adjacency list represent the same graph?
 */

public class Graph {
	/*
	 * Representation:
	 * 
	 * 1. Maintain a list of edges (linked list or array) = Leads to inefficiency
	 * 2. Adjacency matrix graph representation (maintain a v*v boolean array) = inefficient if V is large
	 * 3. Adjacency List graph representation = Maintain vertex indexed array of lists.
	 * 
	 * Representation			Space			Add edge 			edge btw v & w		iterate over vertex
	 * List of edges			  E					1						E					E
	 * Adjacency matrix			  V^2				1 						1					V
	 * Adjacency List			  E+V				1				    degree(V)			degree(V)
	 * 
	 */
	private Bag<Integer> [] adj;
	private final int V;
	/**
	 * Create an empty graph with V-vertices
	 * @param V
	 */
	
	@SuppressWarnings("unchecked")
	public Graph(int V)
	{
		this.V=V;
		adj=(Bag<Integer> []) new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<Integer>();
	}
	
	/**
	 * Add an edge v-w
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w) 
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	
	/**
	 * Vertices adjacent to v
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
	public int V() 
	{
		return V;
	}
	
	/**
	 * Number of edges
	 * @return
	 */
	public int E() 
	{
		int edges=0;
		for(int v=0;v<V;v++)
		{
			Bag<Integer> bag=(Bag<Integer>) adj(v);
			//edges+=((Bag<Integer>)adj(v)).size();
			edges+=bag.size();
		}
		return edges/2;
	}

}
