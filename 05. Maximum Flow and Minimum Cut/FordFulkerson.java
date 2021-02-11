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
	 */

}
