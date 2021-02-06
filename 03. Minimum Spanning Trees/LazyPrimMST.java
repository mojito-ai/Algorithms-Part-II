/**
* <h1>Lazy Prim's Algorithm: We allow stuff on the priority queue even when we know it's obselete. The PQ contains
* 							 all of the edges that cross the cut, plus possibly some edges with both endpoints in the tree.</h1>
* 
* <li> Maintain a PQ of edges with (at-least) one endpoint in T.
* <li> Key=edges; Priority=weight of edge
* <li> Delete-min to determine next edge e=v-w to add to T
* <li> Disregard if both endpoints v & w are in tree.
* <li> Otherwise, let w be the vertex not in T.
* <li> Add to PQ any edges incident to w (assuming other endpoint not in T)
* <li> Add w to T
* 
* @author  Mohit Sharma
* @version 2.0
* @since   06-02-2021
* 
*/


public class LazyPrimMST {

}
