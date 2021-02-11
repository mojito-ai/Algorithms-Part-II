import java.util.TreeSet;
/**
* <h1>Flow Network: Need to process edge e=v->w in either directions. Include e in both v and w's adjacency list</h1>
* 
* <li> Residual Network: A useful view of a flow network
* <li> Augmenting path in orignal network is equivalent to directed path in residual network.
* <li> Allow self loops & parallel edges
* 
* @author  Mohit Sharma
* @version 2.0
* @since   11-02-2021
* 
*/

public class FlowNetwork {
	private final Bag<FlowEdge> [] adj;
	private final int v;
	
	@SuppressWarnings("unchecked")
	FlowNetwork(int V)
	{
		this.v=V;
		adj=(Bag<FlowEdge> []) new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<FlowEdge> ();
	}
	
	void addEdge(FlowEdge e)
	{
		int v=e.from();
		int w=e.to();
		adj[v].add(e);	//add forward edge
		adj[w].add(e);	//add backward edge
	}
	
	Iterable<FlowEdge> adj(int v)
	{
		return adj[v];
	}
	
	Iterable<FlowEdge> edges()
	{
		TreeSet<FlowEdge> edges=new TreeSet<>();
		for(int v=0;v<V();v++)
			for(FlowEdge e: adj(v))
				edges.add(e);
		return edges;
	}
	
	int V()
	{
		return v;
	}
	
	int E()
	{
		int e=0;
		for(int v=0;v<V();v++)
			e+=((Bag<FlowEdge>) adj(v)).size();
		return e/2;
	}

}
