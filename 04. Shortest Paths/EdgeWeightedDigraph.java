/**
* <h1>Edge Weighted Digraph: API to create an adjacency list of Directed Edges</h1>
* 
* <li> Can allow self loops and parallel edges
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-02-2021
* 
*/

public class EdgeWeightedDigraph 
{
	private final int v;
	private final Bag<DirectedEdge> [] adj;
	
	@SuppressWarnings("unchecked")
	EdgeWeightedDigraph(int V)
	{
		this.v=V;
		adj=(Bag<DirectedEdge> [])new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<DirectedEdge>();
	}
	//Add edge e=v->w to only v's adjacency list
	void addEdge(DirectedEdge e)
	{
		int v=e.from();
		adj[v].add(e);
	}
	
	Iterable<DirectedEdge> adj(int v)
	{
		return adj[v];
	}
	
	int V()
	{
		return v;
	}
	
	@SuppressWarnings("unused")
	int E()
	{
		int E=0;
		for(int v=0;v<V();v++)
			for(DirectedEdge w:adj(v))
				E++;
		return E;
	}
	
	Iterable<DirectedEdge> edges()
	{
		Bag<DirectedEdge> bag=new Bag<>();
		for(int v=0;v<V();v++)
			for(DirectedEdge w:adj(v))
				bag.add(w);
		return bag;
	}

}
