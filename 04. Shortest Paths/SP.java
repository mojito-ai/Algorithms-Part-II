/**
* <h1>Single-source shortest paths API: Find the shortest path from s to every other vertex.</h1>
* 
* <li>
* 
* @author  Mohit Sharma
* @version 2.0
* @since   09-02-2021
* 
*/

public class SP 
{
	/*
	 * Shortest Path Properties: 
	 * 
	 * 1. Goal: Find the shortest path from s to every other vertex
	 * 2. Observation: A Shortest Path Tree (SPT) solution exists
	 * 3. Consequence: Can traverse the SPT with two vertex-indexed arrays
	 *		- distTo[v] is length of shortest path from s to v.
	 *		- edgeTo[v] is last edge on shortest path from s to v.
	 * 
	 *Edge Relaxation: Relax edge e=v->w
	 *
	 *1. distTo[v] is length of shortest known path from s to v
	 *2. distTo[w] is length of shortest known path from s to w
	 *3. edgeTo[w] is last edge on shortest path to w through v.
	 *4. if e=v->w gives shorter path to w through v, update both distTo[w] & edgeTo[w]
	 * 					- 
	 *When we consider a new edge, does it give a new shortest path to that vertex or not. If it doesen't, we ignore it.
	 *If it does, we update our data structures. 
	 * 
	 */
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
	
	@SuppressWarnings("unused")
	private void relax(DirectedEdge e)
	{
		int v=e.from();
		int w=e.to();
		if(distTo[w]>distTo[v]+e.weight())
		{
			distTo[w]=distTo[v]+e.weight();
			edgeTo[w]=e;
		}
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
