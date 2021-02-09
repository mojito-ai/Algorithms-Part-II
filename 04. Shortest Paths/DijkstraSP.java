import edu.princeton.cs.algs4.IndexMinPQ;
/**
* <h1>Dijkstra's Algorithm</h1>
* <li> Consider vertices in increasing order of distance from s (non tree vertex with the lowest distTo[] value)
* <li> Add vertex to tree and relax all edges pointing from that vertex
* 
* @author  Mohit Sharma
* @version 2.0
* @since   09-02-2021
* 
*/

/*
 * Edsger W. Dijkstra [Turing Award 1972]
 * 1. Do only what only you can do
 * 2. In their capacity as a tool, computers will be but a ripple on the surface of our culture. In their capacity as intellectual challenge, they are without precedent in the cultural history of mankind.
 * 3. The use of COBOL cripples the mind; its teaching should, therefore, be regarded as a criminal offense.
 * 4. It is practically impossible to teach good programming to students that have had a prior exposure to BASIC: as potential programmers they are mentally mutilated beyond hope of regeneration.
 * 5. APL is a mistake, carried through to perfection. It is the language of the future for the programming techniques of the past: it creates a new generation of coding bums.
 * 6. Object-oriented programming is an exceptionally bad idea which could only have originated in California.
 */
public class DijkstraSP {
	private final double [] distTo;
	private final DirectedEdge [] edgeTo;
	private final IndexMinPQ<Double> pq;
	
	/**
	 * Correctness Proof:
	 * <li> Proposition: Dijkstra's algorithm computes a SPT in any edge-weighted digraph with non-negative weights.
	 * <li> Proof: Each edge e=v->w is relaxed exactly once (when v is relaxed), leaving distTo[w]<=distTo[v]+e.weight()
	 * <li> Inequality holds until algorithm terminates because:
	 * <li> distTo[w] cannot increase -> distTo[] values are monotonically decreasing
	 * <li> distTo[v] will not change -> edge weights are non negative & we chose lowest distTo[] value at each step
	 * 
	 * @param G
	 * @param s
	 */
	DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		distTo=new double[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		pq=new IndexMinPQ<>(G.V());
		for(int v=0;v<G.V();v++)
			distTo[v]=Double.POSITIVE_INFINITY;
		distTo[s]=0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty()) 
		{
			int v=pq.delMin();
			for(DirectedEdge e: G.adj(v))
				relax(e);
		}
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
	
	/*Computing spanning trees in graphs
	 * 
	 * 1. Dijkstra's algorithm seem familiar?
	 * 		-Prim's algorithm is essentially the same algorithm
	 * 		-Both are in a family of algorithms that compute graph's spanning tree.
	 * 
	 * 2. Main distinction: Rule to choose next vertex for the tree
	 * 		-Prim's: Closest vertex to the tree (via an undirected edge)
	 * 		-Dijkstra's: Closest vertex to the source (via a directed path)
	 * 
	 * Note: DFS & BFS are also in this family of algorithms
	 */

}
