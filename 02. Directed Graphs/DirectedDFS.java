/**
* <h1>Reachability: Find all vertices reachable from s along a directed path.</h1>
* 
* <li> DFS is a Di-graph
* <li> Every undirected graph is a digraph (with edges in both directions)
* <li> DFS is a Di-graph algorithm
* <li> DFS marks all vertices connected to s in time proportional to sum of their degrees. -> Proof: Every vertex connected to s is visited once
* 
* @author  Mohit Sharma
* @version 2.0
* @since   05-02-2021
* 
*/

public class DirectedDFS {
	private boolean [] marked; //marked[v]=true if v is connected to s
	private Integer [] edgeTo; //edgeTo[v]=previous vertex on path from s to v
	private int s;
	
	/**
	 * Depth First Search: The aim of the algorithm is not getting lost or going the wrong way, but the key thing is not going to the same place twice.
	 * <li>Mark v as visited
	 * <li>Recursively visit all unmarked vertices w adjacent to v and mark them.
	 * 
	 * @param G
	 * @param s
	 */
	
	/*
	 * Q. During DFS of Digraph G, dfs(v) is called after dfs(w) is called, but returns before dfs(w) returns
	 * A. There exists a directed path from w to v.
	 */
	DirectedDFS(Digraph G, int s)
	{
		marked=new boolean[G.V()];
		edgeTo=new Integer[G.V()];
		this.s=s;
		dfs(G,s); //find vertices connected to s
	}
	
	private void dfs(Digraph G, int v)
	{
		marked[v]=true;
		for(int w:G.adj(v))
		{
			if(!marked[w])
			{
				dfs(G,w);
				edgeTo[w]=v;
			}
		}
	}
	
	boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<>();
		for(int i=edgeTo[v];i!=s;i=edgeTo[i])
			path.push(i);
		path.push(s);
		return path;
	}
	
	
}
