/**
* <h1>Eager Prim's Algorithm: Maintain a PQ of vertices connected by an edge to Tree T, where the priority of vertex v=
* 							  weight of shortest edge connecting v to T </h1>
* 
* <li> PQ has at most 1 vertex per vertex
* <li> Delete min vertex v and add its associated edge e=v-w to T
* <li> Update PQ by considering all the edges e=v-x incident to v.
* <li> Ignore if x already present in the tree.
* <li> Add x to PQ if not already on it.
* <li> Decrease priority of x if v-x becomes shortest edge containing x to T.
* 
* <li> For each non-tree vertex v, the eager version of Prim's algorithm maintains at most one entry per vertex in the PQ.
* 	   (with priority = weight of the cheapest edge from v to the tree)
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   06-02-2021
* 
*/

public class EagerPrimMST {

}
