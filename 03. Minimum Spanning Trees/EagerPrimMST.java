import edu.princeton.cs.algs4.IndexMinPQ;

/**
* <h1>Eager Prim's Algorithm: Maintain a PQ of vertices connected by an edge to Tree T, where the priority of vertex v=
* 							  weight of shortest edge connecting v to T </h1>
* 
* <li> PQ has at most 1 vertex per vertex
* <li> Delete min vertex v and add its associated edge e=v-w to T
* <li> Update PQ by considering all the edges e=v-x incident to v.
* <li> Ignore if x already present in the tree.
* <li> Add x to PQ if not already on it.
* <li> Decrease priority of x if v-x becomes shortest edge containing x to T.
* 
* <li> For each non-tree vertex v, the eager version of Prim's algorithm maintains at most one entry per vertex in the PQ.
* 	   (with priority = weight of the cheapest edge from v to the tree)
* 
* 
* @author  Mohit Sharma
* @version 3.0
* @since   09-02-2021
* 
*/

public class EagerPrimMST {
	private Queue<Edge> mst;
	private double weight;
	private IndexMinPQ<Edge> pq;
	private boolean [] marked;
	
	EagerPrimMST(EdgeWeightedGraph G)
	{
		mst=new Queue<>();
		weight=0;
		pq=new IndexMinPQ<>(G.V());
		marked=new boolean[G.V()];
		visit(G,0);
		marked[0]=true;
		
		while(!pq.isEmpty() && mst.size()<G.V()-1)
		{
			Edge e=pq.minKey();
			int v=e.either();
			int w=e.other(v);

			mst.enqueue(e);
			
			if(!marked[v])	visit(G,v);
			if(!marked[w])	visit(G,w);
			marked[w]=true;
		}
		
	}
	
	private void visit(EdgeWeightedGraph G, int v)
	{
		for(Edge e: G.adj(v)) 
		{
			int w=e.other(v);
			if(!marked[w] && !pq.contains(w))
				pq.insert(v, e);
			
			else if(!marked[w] && pq.contains(w))
				pq.decreaseKey(w, e);
			
			else
				continue;
		}
	}
	
	Iterable<Edge> edges()
	{
		return mst;
	}
	
	double weight()
	{
		return weight;
	}

}
