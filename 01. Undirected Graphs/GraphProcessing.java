/**
* <h1>Undirected Graphs: Set of vertices connected pairwise by edges. Challenging branch of computer science</h1>
* 
* <li>Computing the degree of v
* <li>Computing the maximum degree
* <li>Computing the average degree
* <li>Counting self loops
* 
* @author  Mohit Sharma
* @version 1.0
* @since   04-02-2021
* 
*/

public class GraphProcessing {
	
	/**
	 * Computing the outdegree or indegree of a graph
	 * @param G
	 * @param v
	 * @return
	 */
	public static int degree(Graph G, int v)
	{
		int degree=0;
		for(@SuppressWarnings("unused") int w:G.adj(v))
			degree++;
		return degree;
	}
	
	/**
	 * Computing the maximum degree of any vertex in Graph G
	 * 
	 * @param G
	 * @return
	 */
	public static int max(Graph G)
	{
		int max=0;
		for(int v=0;v<G.V();v++)
			if(degree(G,v)>max)
				max=degree(G,v);
		return max;
	}
	
	/**
	 * Computing the average degree in a undirected Graph. It is basically 2*edges/vertices as every edge appears twice in adjacency lists.
	 * 
	 * @param G
	 * @return
	 */
	public static int AvgDegree(Graph G)
	{
		return 2*G.E()/G.V();
	}
	
	/**
	 * Number of self loops in a Graph
	 * <li> Each edge is counted twice so return count/2
	 * 
	 * @param G
	 * @return
	 */
	public static int numselfloops(Graph G)
	{
		int count=0;
		for(int v=0;v<G.V();v++)
			for(int w: G.adj(v))
				if(v==w)
					count++;
		return count/2;
	}

}
