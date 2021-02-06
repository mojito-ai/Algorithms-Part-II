import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

/**
* <h1>Kruskal's Algorithm: Consider edges in ascending order of weight. Add edge to tree T unless doing so would create a cycle</h1>
* 
* <li> In visualisation, its taking the small edges and they coalless together in little clusters & eventually get longer and longer and connect together
* 
* @author  Mohit Sharma
* @version 1.0
* @since   06-02-2021
* 
*/

public class KruskalMST {
	
	private double weight;
	private Queue<Edge> mst=new Queue<>();
	
	/**
	 * Kruskal's Algorithm computes the MST (Correctness Proof):
	 * 
	 * <li> Kruskal Algorithm is a special case of Greedy MST algorithm.
	 * <li> Suppose Kruskal's Algorithm colors edge e=v-w black.
	 * <li> Cut=Set of vertices connected to v in tree T.
	 * <li> No crossing edge is black.
	 * <li> No crossing edge is of lower weight. (As edges in ascending order) 
	 * @param G
	 */
	@SuppressWarnings("deprecation")
	KruskalMST(EdgeWeightedGraph G)
	{
		MinPQ<Edge> pq=new MinPQ<>();
		for(Edge w: G.edges())
			pq.insert(w);
		
		UF uf=new UF(G.V());
		while(!pq.isEmpty() && mst.size()<G.V()-1)
		{
			Edge e=pq.delMin();
			int v=e.either();
			int w=e.other(v);
			if(!uf.connected(v, w))
			{
				uf.union(v, w);
				mst.enqueue(e);
			}
		}	
	}
	
	Iterable<Edge> edges()
	{
		
	}
	
	double weight()
	{
		
	}

}
