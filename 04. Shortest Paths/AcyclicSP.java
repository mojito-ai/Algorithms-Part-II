import edu.princeton.cs.algs4.IndexMinPQ;
/**
* <h1>Edge Weighted DAGs: Acyclic edge weighted digraph -> It is easier to find shortest paths in an edge weighted digraph
* 						  that has no directed cycles.</h1>
* <li> Topological Sort algorithm:
* <li> Consider vertices in topological order
* <li> Relax all edges pointing from that vertex.
* 
* @author  Mohit Sharma
* @version 2.0
* @since   09-02-2021
* 
*/

public class AcyclicSP {
	
	private double [] distTo;
	private DirectedEdge [] edgeTo;
	private final IndexMinPQ<Double> pq;
	
	/**
	 * Proposition: Topological sort algorithm computes the SPT in any edge weighted DAG in time E+V
	 * Proof: Each edge e=v->w is relaxed exactly once (when v is relaxed) leaving distTo[w]<=distTo[v]+e.weight()
	 * <li> Inequality holds until algorithm terminates because: 
	 * <li> distTo[w] cannot increase -> distTo[] are monotone decreasing
	 * <li> distTo[v] will not change -> because of topological order, no edge pointing to v will be relaxed after v is relaxed.
	 * @param G
	 * @param s
	 */
	AcyclicSP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		pq=new IndexMinPQ<>(G.V());
		for(int v=0;v<G.V();v++)
			distTo[v]=Double.POSITIVE_INFINITY;
		distTo[s]=0.0;
		
		Topological topological=new Topological(G);
	    for(int w:topological.order())
	    	for(DirectedEdge e: G.adj(w))
	    		relax(e);
	}
	
	private void relax(DirectedEdge e)
	{
		int v=e.from();
		int w=e.to();
		if(distTo[w]>distTo[v]+e.weight())
		{
			distTo[w]=distTo[v]+e.weight();
			edgeTo[w]=e;
			if(!pq.contains(w))	pq.insert(w, distTo[w]);
			else				pq.decreaseKey(w, distTo[w]);
		}
	}
	
	Iterable<DirectedEdge> pathTo(int v)
	{
		Stack<DirectedEdge> path=new Stack<>();
		for(DirectedEdge e=edgeTo[v]; e!=null; e=edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	double distTo(int v)
	{
		return distTo[v];
	}
	
	boolean hasPathTo(int v)
	{
		return distTo[v]!=Double.POSITIVE_INFINITY;
	}

}
