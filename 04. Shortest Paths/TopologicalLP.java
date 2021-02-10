import edu.princeton.cs.algs4.IndexMinPQ;
/**
* <h1> Longest Paths in edge-weighted-DAGs: Formulate as a shortest paths problem in edge weighted DAGs</h1>
* <li> Negate all weights
* <li> Find shortest paths
* <li> Negate weights in result
* <li> Essentially negative sense of equality in relax
* 
* @author  Mohit Sharma
* @version 1.0
* @since   10-02-2021
* 
*/

public class TopologicalLP {
	private final double [] distTo;
	private final DirectedEdge [] edgeTo;
	private final IndexMinPQ<Double> pq;
	
	TopologicalLP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		pq=new IndexMinPQ<>(G.V());
		for(int v=0;v<G.V();v++)
			distTo[v]=Double.NEGATIVE_INFINITY;
		distTo[s]=0.0;
		
		Topological topological=new Topological(G);
		for(int v: topological.order())
			for(DirectedEdge w:G.adj(v))
				relax(w);
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
		return -distTo[v];
	}
	
	boolean hasPathTo(int v)
	{
		return distTo[v]!=Double.NEGATIVE_INFINITY;
	}

}
