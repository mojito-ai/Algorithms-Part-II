import edu.princeton.cs.algs4.IndexMinPQ;
/**
* <h1> Negative weights: Shortest paths with negative weights is complex and sometimes intractable </h1>
* <li> Failed attempts: Dijkstra doesen't work with negative weights
* <li> Failed attempts: Add a constant to every edge weight doesen't work.
*
* @author  Mohit Sharma
* @version 1.0
* @since   10-02-2021
* 
*/

public class BellmanFordSP {
	/*
	 * Analysis: Dynamic Programming algorithm computes the SPT in any edge weighted digraph with no negative cycles in time ~ E*V
	 * 
	 * Proof: After pass i, found shortest path containing at most i edges.
	 * Improvement: If distTo[v] does not change during pass i, no need to relax any edge pointing from v in pass i+1
	 * 
	 * FIFO Implementation: Maintain a queue of vertices whose distTo[] changed. Overall effect is that running time ~ E*V in worst case
	 * 						But much faster than that in practise.
	 * 
	 */
	private final double [] distTo;
	private final DirectedEdge [] edgeTo;
	private final IndexMinPQ<Double> pq;
	
	/**
	 * Initialise distTo[s]=0 & distTo[v]=infinity for all other vertices
	 * <li> Relax V times: Relax each edge
	 * @param G
	 * @param s
	 */
	BellmanFordSP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		pq=new IndexMinPQ<>(G.V());
		
		for(int v=0;v<G.V();v++)
			distTo[v]=Double.POSITIVE_INFINITY;
		distTo[s]=0.0;
		
		for(int i=0;i<G.V();i++)
			for(int v=0;v<G.V();v++)
				for(DirectedEdge e: G.adj(v))
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
			if(pq.contains(w))	pq.decreaseKey(w, distTo[w]);
			else				pq.insert(w, distTo[w]);
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
	
	/*
	 * Negative Cycles: A negative cycle is a directed cycle whose sum of edge weights is negative. 
	 * 
	 * A SPT exists iff no negative cycles
	 * 
	 * Finding a negative cycle: If there is a negative cycle, BellmanFord gets stuck in loop updating distTo[] and edgeTo[] 
	 * 							 entries of vertices in the cycle.
	 * 
	 * Proposition: If any vertex v is updated in phase v (last phase) there exists a negative cycle (and can trace back edgeTo[v]
	 * 				entries to find it)
	 * 
	 */
}
