import edu.princeton.cs.algs4.MinPQ;

/**
* <h1>Lazy Prim's Algorithm: We allow stuff on the priority queue even when we know it's obselete. The PQ contains
* 							 all of the edges that cross the cut, plus possibly some edges with both endpoints in the tree.</h1>
* 
* <li> Maintain a PQ of edges with (at-least) one endpoint in T.
* <li> Key=edges; Priority=weight of edge
* <li> Delete-min to determine next edge e=v-w to add to T
* <li> Disregard if both endpoints v & w are in tree.
* <li> Otherwise, let w be the vertex not in T.
* <li> Add to PQ any edges incident to w (assuming other endpoint not in T)
* <li> Add w to T
* 
* @author  Mohit Sharma
* @version 2.0
* @since   06-02-2021
* 
*/


public class LazyPrimMST {
	private Queue<Edge> mst=new Queue<>();
	private	double weight;
	private boolean [] marked;
	private MinPQ<Edge> pq;
	
	LazyPrimMST(EdgeWeightedGraph G)
	{
		marked=new boolean[G.V()];
		pq=new MinPQ<>();
		visit(G,0);
		
		while(!pq.isEmpty() && mst.size()<G.V()-1)
		{
			Edge e=pq.delMin();
			int v=e.either();
			int w=e.other(v);
			if(marked[v] && marked[w])	continue;
			
			mst.enqueue(e);
			if(!marked[v])	visit(G,v);
			if(!marked[w])	visit(G,w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v)
	{
		marked[v]=true;
		for(Edge e: G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);
	}
	
	Iterable<Edge> edges()
	{
		return mst;
	}
	
	double weight()
	{
		weight=0;
		for(Edge e: mst)
			weight+=e.weight();
		return weight;
	}
}
