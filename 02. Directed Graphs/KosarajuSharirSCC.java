/**
* <h1>Strongly Connected Components: Vertices v & w are strongly connected components if there is a dedicated path
* 									 from v to w and a directed path from w to v. </h1>
* 
* <li> It is an equivalence relation: Reflexive, Transitive, Symmetric
* <li> A strong component is a maximal subset of strongly connected vertices.
* <li> A DAG with V vertices, E edges has V strongly connected components.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-02-2021
* 
*/

public class KosarajuSharirSCC {

	
	/*
	 * Applications: 
	 * 
	 * 1. Ecological Food Webs: Vertex=Species, 
	 * 							Edge=From producer to consumer, 
	 * 							Strong Component=Subset of species with common energy flow.
	 * 
	 * 2. Software Modules: Vertex=Software Module
	 * 						Edge=From module to dependency
	 * 						Strong component=Subset of mutually interacting modules
	 * 
	 * 	- Approach 1: Package strong components together
	 * 	- Approach 2: Use to improve design
	 * 
	 */
}
