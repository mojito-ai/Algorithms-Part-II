/**
* <h1>Ford-Fulkerson Algorithm: </h1>
* 
* <li> Initialisation: Start with 0 flow
* <li> Idea: Increase flow along augmenting paths
* <li> Augmenting paths: Find an undirected path from s to t such that:
* <li> Can increase flow on forward edges (not full)
* <li> Can decrease flow on backward edges (not empty)
* <li> When we augment, we preserve local equilibrium at vertex property
* 
* <li> Termination: All paths from s to t are blocked by either a 
* <li> Full forward edge
* <li> Empty backward edge
* 
* @author  Mohit Sharma
* @version 3.0
* @since   11-02-2021
* 
*/

public class FordFulkerson {
	private boolean [] marked;
	private FlowEdge [] edgeTo;
	private double value;
	
	/*
	 * Ford-Fulkerson Algorithm: Start with 0 flow.
	 * 
	 * 1. While there exists an augmenting path:
	 * 		-Find an augmenting path
	 * 		-Compute the bottleneck capacity
	 * 		-Increase flow on that path by bottleneck capacity
	 * 
	 * 2. Questions:
	 * 		-How to find a mincut?
	 * 			
	 * 			To compute a mincut(A,B) from maxflow f
	 * 			a. By augmenting path theorem, no augmenting paths wrt f
	 * 			b. Compute A=set of vertices connected to s by an undirected path with no full forward or empty backward edges
	 * 			c. Order of growth ~ V+E (Can be done in linear time by DFS or BFS)
	 * 
	 * 		-How to find an augmenting path?
	 * 
	 * 			BFS works well
	 * 
	 * 		-If FF terminates, does it always compute a maxflow?
	 * 
	 * 			Yes
	 * 
	 * 		-Does FF always terminate? If so, after how many augmentations.
	 * 
	 * 			Yes. Provided edge weights capacities are integers (or augmenting paths chosen carefully)
	 * 
	 */
	
	public FordFulkerson(FlowNetwork G, int s, int t)
	{
		value=0.0;
		while(hasAugmentingPath(G,s,t))
		{
			double bottle=Double.POSITIVE_INFINITY;
			for(int v=t;v!=s;v=edgeTo[v].other(v))
				bottle=Math.min(bottle, edgeTo[v].residualCapacityTo(v));	//compute bottleneck capacity
			
			for(int v=t;v!=s; v=edgeTo[v].other(v))
				edgeTo[v].addResidualFlowTo(v, bottle); //augment flow
			
			value+=bottle;
		}
	}
	
	public double value()
	{
		return value;
	}
	
	public boolean inCut(int v)
	{
		return marked[v];
	}
	
	/**
	 * Here we can use BFS but can use anything like DFS or priority queue as in Prim's or Dijkstra
	 * <li> FF performance depends on choice of augmenting paths
	 * <li> Augmenting Paths		Number of paths				Implementation 
	 * <li> shortest path				~1/2EV					queue(BFS)
	 * <li> fattest path				~Eln(EU)				priority queue
	 * <li> random path					~EU						randomized queue
	 * <li> DFS Path					~EU						Stack(DFS)
	 * 
	 * <li> Shortest path=augmenting path with fewest edges
	 * <li> Fattest path=augmenting path with maximum bottleneck capacity
	 * @param G
	 * @param s
	 * @param t
	 * @return
	 */
	
	/*
	 * Theory: Yet another holy grail for theoretical computer scientists
	 * 
	 * Year		Method						Worst Case				Discovered By
	 * 1951		Simplex						 UE^3 					Dantzig
	 * 1955		Augmenting path				 UE^2					Ford-Fulkerson
	 * 1970		Shortest augmenting path	 E^3					Dinitz, Edmonds-Keep
	 * 1970		Fattest augmenting path		 E^2 logE log(EU)		Dinitz, Edmonds-Keep
	 * 1977		blocking flow				 E^(5/2)				Cherkasky
	 * 1978		blocking flow				 E^(7/3)				Galil
	 * 1983		dynamic trees				 E^2logE				Sleator-Tarjan
	 * 1985		capacity scaling			 E^2logU				Gabow
	 * 1997		length function				 E^(3/2) LogE logU		Goldberg-Rao
	 * 2012		compact network				 E^2/logE				Orlin
	 * 
	 * Maxflow algorithms for sparse digraphs with E edges and integer capacities (max U)
	 * 
	 */
	private boolean hasAugmentingPath(FlowNetwork G, int s, int t)
	{
		edgeTo=new FlowEdge[G.V()];
		marked=new boolean[G.V()];
		Queue<Integer> q=new Queue<>();
		q.enqueue(s);
		marked[s]=true;
		
		while(!q.isEmpty())
		{
			int v=q.dequeue();
			for(FlowEdge e: G.adj(v))
			{
				int w=e.other(v);
				if(e.residualCapacityTo(w)>0 && !marked[w]) //found path from s to w in residual network
				{
					marked[w]=true;	//mark w
					edgeTo[w]=e;	//save last edge on path to w
					q.enqueue(w);	//add w to the queue
				}
			}
		}
		return marked[t];	//is t reachable from s in residual network
	}
	/*
	 *Ford Fulkerson algorithm with integer capacities
	 *
	 *1. Important special case - Edge capacities are integers between 1 & U
	 *2. Invariant: The flow is integer-valued throughout Ford Fulkerson
	 *
	 *Proof: [by induction]
	 *	-Bottleneck capacity is an integer
	 *	-Flow on an edge increases/decreases by bottleneck capacity
	 *
	 *Proposition: Number of augmentations <= the value of the maxflow
	 *Proof: Each augmentation increases the value by atleast 1
	 * 
	 *3. Integrality Theorem: There exists an integer valued maxflow
	 *
	 *Proof: FF terminates and maxflow is integer valued
	 */

}
