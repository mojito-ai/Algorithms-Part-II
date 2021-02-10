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
	
	private final double [] distTo;
	private final DirectedEdge [] edgeTo;
	private final IndexMinPQ<Double> pq;
	
	BellmanFordSP(EdgeWeightedDigraph G, int s)
	{
		
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

}
