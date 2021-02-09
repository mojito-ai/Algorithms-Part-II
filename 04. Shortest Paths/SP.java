/**
* <h1>Single-source shortest paths API: Find the shortest path from s to every other vertex.</h1>
* 
* <li> Generic Algorithm: To compute SPT from s
* <li> Initialise distTo[s]=0 & distTo[v]=infinity for all other vertices
* <li> Repeat until optimality conditions reached: Relax any edge
* <li> Proof: Throughout algorithm, distTo[v] is the length of a simple path from s to v (and edgeTo[v] is the last edge on the path)
* <li> Each successful relaxation decreases distTo[v] for some v
* <li> The entry distTo[v] can decrease at most a finite number of times.
* 
* @author  Mohit Sharma
* @version 3.0
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
		 * 1. Dijkstra's Algorithm (Non-negative weights)
		 * 2. Topological Sort (No directed cycles)
		 * 3. Bellman-Ford Algorithm (No negative cycles)
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
	
	/*
	 * Optimality Conditions: Let G be an edge-weighted digraph. Then distTo[] is the shortest path distances from s iff:
	 * 
	 * 		1. distTo[s]=0;
	 * 		2. For each vertex v, distTo[v] is the length of some path from s to v
	 * 		3. For each edge e=v->w, distTo[w]<=distTo[v]+e.weight()
	 * 
	 * Proof: Suppose that distTo[w]>distTo[v]+e.weight() for some edge e=v->w. Then e gives a path from s to w (via v) of length less than distTo[w].
	 * 
	 * Proof: Suppose that s=v0->v1->v2->....->vk=w is a shortest path from s to w
	 * 			
	 * 			distTo[v0]<=distTo[v1]+e1.weight() ; ei= ith edge on shortest path from s to w
	 *			distTo[v1]<=distTo[v2]+e2.weight()
	 *		    ...............................
	 *		    distTo[vk]<=distTo[vk-1]+ek.weight()
	 *
	 *Add inequalities: simplify distTo[v0]=distTo[s]=0
	 *			
	 *			distTo[w]=distTo[vk]<=e1.weight()+e2.weight()+......+ek.weight()
	 *
	 *Thus distTo[w] is the weight of the shortest path from s to w.
	 * 
	 */
}
