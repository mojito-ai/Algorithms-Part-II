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
* @version 2.0
* @since   05-02-2021
* 
*/

public class DepthFirstOrder {
	
	/**
	 * Topological Sort in a DAG: Reverse Post order (DFS) of a DAG is a topological order.
	 * <li> Consider any edge v->w, when dfs(v) is called :
	 * <li> Case 1: dfs(w) has been called and returned. Thus, w was done before v.
	 * <li> Case 2: dfs(w) has not been called. dfs(w) will get called directly or indirectly by dfs(v) and will finish before dfs(v). Thus w will be done before v.
	 * <li> Case 3: dfs(w) has already been called but not yet returned. Can't happen in a DAG as function call stack contains path from w->v, so v->w would complete a cycle.
	 * 
	 */
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
