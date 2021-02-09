/**
* <h1>Topological Sort: Given a set of tasks to be completed with precedence constraints, in which order should we schedule the tasks?</h1>
* 
* <li> Vertex=Task, Edge=Precedence Constraint
* <li> DAG (Directed Acyclic Graph): EdgeWeightedDigraph that has no cycles. 
* <li> If we have a cycle, we cannot do topological sort
* <li> Topological Sort: Redraw DAG so all edges point upwards.
* <li> DFS Based solution
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-02-2021
* 
*/

public class Topological {
	private boolean [] marked;
	private Stack<Integer> reversePost;
	
	Topological(EdgeWeightedDigraph G)
	{
		marked=new boolean[G.V()];
		reversePost=new Stack<>();
		for(int v=0;v<G.V();v++)
			if(!marked[v])
				dfs(G,v);
	}
	
	private void dfs(EdgeWeightedDigraph G, int v)
	{
		marked[v]=true;
		for(DirectedEdge e: G.adj(v))
		{
			int w=e.to();
			if(!marked[w])
				dfs(G,w);
		}
		reversePost.push(v);
	}

	Iterable<Integer> order()
	{
		return reversePost;
	}
}
