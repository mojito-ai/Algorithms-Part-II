/**
* <h1>Edge Weighted DAGs: Acyclic edge weighted digraph -> It is easier to find shortest paths in an edge weighted digraph
* 						  that has no directed cycles.</h1>
* <li> Topological Sort algorithm:
* <li> Consider vertices in topological order
* <li> Relax all edges pointing from that vertex.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-02-2021
* 
*/

public class AcyclicSP {
	
	private double [] distTo;
	private DirectedEdge [] edgeTo;
	
	AcyclicSP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
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
