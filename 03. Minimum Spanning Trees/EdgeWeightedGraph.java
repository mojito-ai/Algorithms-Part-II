/**
* <h1>Edge Weighted Graph: API to create an adjacency list of Edges</h1>
* 
* <li> Edges should be Comparable type
* <li> Can allow self loops and parallel edges
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-02-2021
* 
*/

public class EdgeWeightedGraph {
	private Bag<Edge> [] adj;
	private final int V;
	/**
	 * Create an empty graph with V vertices
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	EdgeWeightedGraph(int V)
	{
		this.V=V;
		adj=(Bag<Edge>[]) new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<Edge> ();
	}
	
	void addEdge(Edge e)
	{
		int v=e.either();
		int w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}
	
	Iterable<Edge> adj(int v)
	{
		return adj[v];
	}
	
	Iterable<Edge> edges()
	{
		SET<Edge> set=new SET<>();
		for(int v=0;v<V;v++)
			for(Edge e: adj(v))
				set.add(e);
		return set.Keys();
	}
	
	int V()
	{
		return V;
	}
	
	int E()
	{
		int edges=0;
		for(int v=0;v<V;v++)
			edges+=((Bag<Edge>)adj(v)).size();
		return edges/2;
	}

}
