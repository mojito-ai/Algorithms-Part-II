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
	private Queue<Edge> mst=new Queue<>();	//MST edges
	private	double weight;
	private boolean [] marked;	//MST vertices
	private MinPQ<Edge> pq;	//PQ of edges
	
	LazyPrimMST(EdgeWeightedGraph G)
	{
		marked=new boolean[G.V()];
		pq=new MinPQ<>();
		visit(G,0);		//Assume G is connected
		
		while(!pq.isEmpty() && mst.size()<G.V()-1)
		{
			Edge e=pq.delMin();		//Repeatedly delete the minimum weight edge e=v-w from PQ
			int v=e.either();
			int w=e.other(v);
			if(marked[v] && marked[w])	continue;	//ignore if both endpoints in T
			
			mst.enqueue(e);	//Add edge e to tree
			if(!marked[v])	visit(G,v);	//add v or w to tree
			if(!marked[w])	visit(G,w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v)
	{
		marked[v]=true;		//Add v to tree
		for(Edge e: G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);	//for each edge e=v-w, add to PQ if w not already in T
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
