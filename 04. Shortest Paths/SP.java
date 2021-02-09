/**
* <h1>Single-source shortest paths API: Find the shortest path from s to every other vertex.</h1>
* 
* <li>
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-02-2021
* 
*/

public class SP 
{
	private double [] distTo;
	private DirectedEdge [] edgeTo;
	SP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		
	}
	
	double distTo(int v)
	{
		return distTo[v];
	}
	
	Iterable<DirectedEdge> pathTo(int v)
	{
		Stack<DirectedEdge> path=new Stack<>();
		for(DirectedEdge e=edgeTo[v]; e!=null; e=edgeTo[e.from()])
		{
			path.push(e);
		}
		return path;
	}
	
	boolean hasPathTo(int v)
	{
		return edgeTo[v].weight()!=Double.POSITIVE_INFINITY;
	}

}
