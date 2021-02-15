/**
* <h1> R-way Tries: </h1>
* 
* <li> Summary of performance of symbol table implementations
* 
* 
* <li> 
* @author  Mohit Sharma
* @version 1.0
* @since   15-02-2021
* 
*/

public class TrieST {

	
	/*
	 * 
	 * 1. Order of growth of frequency of operations (key compares)
	 * Implementation		Search		Insert		Delete			Ordered Operation			Operation on keys
	 * Red-Black BST		log N		 log N		 log N				Yes					compareTo()
	 * HashTable			 1*			   1*		   1*				 No					equals() & hashCode()		* under uniform hashing assumption
	 * 
	 * 2. Order of growth of frequency of operations (character compares)
	 * Implementation		Search hit	 Search miss		Insert			Space	
	 * Red-Black BST		L+clog N		clog N			 clog N			 4N		
	 * HashTable				L			 L					L			4N to 16N	
	 * 
	 * N=number of strings
	 * L=length of string
	 * R=radix
	 * 
	 * 	
	 */
}
