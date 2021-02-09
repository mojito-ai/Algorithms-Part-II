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
	/**
	 * Shortest paths from s in Graph G
	 * @param G
	 * @param s
	 */
	SP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		/*
		 * 1. Dijkstra's Algorithm
		 * 2. Topological Sort
		 * 3. Bellman-Ford Algorithm
		 */
	}
	//length of shortest path from s to v
	double distTo(int v)
	{
		return distTo[v];
	}
	
	//shortest path from s to v
	Iterable<DirectedEdge> pathTo(int v)
	{
		Stack<DirectedEdge> path=new Stack<>();
		for(DirectedEdge e=edgeTo[v]; e!=null; e=edgeTo[e.from()])
		{
			path.push(e);
		}
		return path;
	}
	
	//is there a path from s to v
	boolean hasPathTo(int v)
	{
		return edgeTo[v].weight()!=Double.POSITIVE_INFINITY;
	}

}
