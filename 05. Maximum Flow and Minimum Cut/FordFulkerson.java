/**
* <h1>Ford-Fulkerson Algorithm: </h1>
* 
* <li> Initialisation: Start with 0 flow
* <li> Idea: Increase flow along augmenting paths
* <li> Augmenting paths: Find an undirected path from s to t such that:
* <li> Can increase flow on forward edges (not full)
* <li> Can decrease flow on backward edges (not empty)
* <li> When we augment, we preserve local equilibrium at vertex property
* 
* <li> Termination: All paths from s to t are blocked by either a 
* <li> Full forward edge
* <li> Empty backward edge
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-02-2021
* 
*/

public class FordFulkerson {
	
	/*
	 * Ford-Fulkerson Algorithm: Start with 0 flow.
	 * 
	 * 1. While there exists an augmenting path:
	 * 		-Find an augmenting path
	 * 		-Compute the bottleneck capacity
	 * 		-Increase flow on that path by bottleneck capacity
	 * 
	 * 2. Questions:
	 * 		-How to find a mincut?
	 * 			
	 * 			To compute a mincut(A,B) from maxflow f
	 * 			a. By augmenting path theoram, no augmenting paths wrt f
	 * 			b. Compute A=set of vertices connected to s by an undirected path with no full forward or empty backward edges
	 * 			c. Order of growth ~ V+E (Can be done in linear time by DFS or BFS)
	 * 
	 * 		-How to find an augmenting path?
	 * 
	 * 			BFS works well
	 * 
	 * 		-If FF terminates, does it always compute a maxflow?
	 * 
	 * 			Yes
	 * 
	 * 		-Does FF always terminate? If so, after how many augmentations.
	 * 
	 * 			Yes. Provided edge weights capacities are integers (or augmenting paths chosen carefully)
	 * 
	 */

}
