/**
* <h1>Connected Components: Vertices v and w are connected if there is a path between them.</h1>
* 
* <li> Pre-process graph to answer queries of the form "is v-connected to w" in constant time.
* <li> It is an equivalence relation: Reflexive, Symmetric, Transitive
* <li> A connected component is a maximal set of connected components
* 
* 
* @author  Mohit Sharma
* @version 2.0
* @since   04-02-2021
* 
*/

public class CC {
	private Integer [] id; //id[v]=id of component containing v
	private boolean [] marked; //marked[v]=true if v is connected to s
	private int count; //number of components
	
	/**
	 * We maintain a id[] array. Here DFS is like Union Find but with all the trees flat. Therefore constant time.
	 * <li> Initialize all vertices v as unmarked
	 * <li> For each unmarked vertex v, run DFS to identify all vertices discovered as part of the same component
	 * 
	 * @param G
	 */
	CC(Graph G)
	{
		this.count=0;
		marked=new boolean[G.V()];
		id=new Integer[G.V()];
		for(int v=0;v<G.V();v++)
		{
			if(!marked[v])
			{
				dfs(G,v);		//run DFS from one vertex in each component
				count++;
			}
		}
	}
	
	/**
	 * 
	 * @param G
	 * @param v
	 */
	private void dfs(Graph G, int v)
	{
		marked[v]=true;
		id[v]=count; 		//all vertices discovered in same call of DFS have same id
		for(int w: G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	
	/**
	 * Are v & w connected?
	 * @param v
	 * @param w
	 * @return
	 */
	boolean connected(int v, int w)
	{
		return id[v]==id[w];
	}
	
	/**
	 * Number of connected components
	 * @return
	 */
	int count()
	{
		return count;
	}
	
	/**
	 * Component identifier for v
	 * @param v
	 * @return
	 */
	int id(int v)
	{
		return id[v];
	}
	
	/*
	 * Applications:
	 * 
	 * 1. Particle Detection (like FloodFill photoshop)
	 * 		- vertex=pixel, edge=between two adjacent pixels with greyscale >=70, Blob=Connected Component of 20-30 pixels
	 * 
	 * 2. Study spread of STD (Relationship graph at "Jefferson High"
	 * 
	 * 3. Particle Tracking
	 * 
	 */
}
