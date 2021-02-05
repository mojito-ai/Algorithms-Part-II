/**
* <h1>Topological Sort: Given a set of tasks to be completed with precedence constraints, in which order should we schedule the tasks?</h1>
* 
* <li> Vertex=Task, Edge=Precedence Constraint
* <li> DAG (Directed Acyclic Graph): Digraph that has no cycles. 
* <li> If we have a cycle, we cannot do topological sort
* <li> Topological Sort: Redraw DAG so all edges point upwards.
* <li> DFS Based solution
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-02-2021
* 
*/

public class DepthFirstOrder {
	
	private boolean [] marked;
	private Stack<Integer> reversePost;
	
	/**
	 * <li> Run Depth First Search
	 * <li> Return vertices in reverse post-order
	 * @param G
	 */
	DepthFirstOrder(Digraph G)
	{
		marked=new boolean[G.V()];
		reversePost=new Stack<>();
		for(int v=0;v<G.V();v++)
		{
			if(!marked[v])
				dfs(G,v);
		}
	}
	
	private void dfs(Digraph G, int v)
	{
		marked[v]=true;
		for(int w: G.adj(v))
			if(!marked[v])
				dfs(G,w);
		
		reversePost.push(v);
	}
	
	/**
	 * Return all vertices in reverse DFS Postorder
	 * @return
	 */
	public Iterable<Integer> reversePost()
	{
		return reversePost;
	}

}
