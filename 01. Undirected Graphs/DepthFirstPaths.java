/**
* <h1>Maze Exploration: Explore every intersection in the maze.</h1>
* 
* <li>Applications:
* <li>Tremaux maze exploration: Unroll a ball of string behind you. Mark each visited intersection and passage. Retrace when no unvisited options.
* <li>Thesus was instructed by Ariadne to use a ball of string when going to fight the Minotaur in the labyrinth.
* <li>Claude Shannon used mice in maze exploration
* 
* <li> DFS marks all vertices connected to s in time proportional to sum of their degrees. -> Proof: Every vertex connected to s is visited once
* @author  Mohit Sharma
* @version 2.0
* @since   04-02-2021
* 
*/

public class DepthFirstPaths {
	
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
	DepthFirstPaths(Graph G, int s)
	{
		marked=new boolean[G.V()];
		edgeTo=new Integer[G.V()];
		this.s=s;
		dfs(G,s);	//find vertices connected to s
	}
	
	private void dfs(Graph G, int v)
	{
		marked[v]=true;
		for(int w: G.adj(v))
			if(!marked[w])
			{
				dfs(G,w);
				edgeTo[w]=v;
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
	
	/*
	 * Application: Flood Fill (Photoshop magic wand)
	 * Assumption: Picture has millions to billions of pixels
	 * 
	 * 1. Build a grid graph
	 * 2. Vertex=pixel
	 * 3. Edge=Between two adjacent grey pixels
	 * 4. Blob=All pixels connected to given pixel.
	 * 
	 * When you click a pixel, it does DFS to find all connected pixels of similar color
	 */

}
