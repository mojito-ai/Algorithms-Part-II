/**
* <h1> TST (Ternary Search Tries): Store characters and values in nodes (not keys) </h1>
* 
* <li> Each node has 3 children : smaller (left), equal (middle), larger (right)
* <li> Fast Algorithms for sorting and searching strings : Joe L. Bentley & Robert Sedgewick
* <li> Can build balanced TSTs via rotations to achieve L+logN worst case guarantees
* <li> TST is as fast as hashing (for string keys), space efficient
* 
* @author  Mohit Sharma
* @version 1.0
* @since   15-02-2021
* 
*/

public class TST<Value> {
	
	/*
	 * Cost Summary
	 * 
	 * 									Character Accesses  (typical case)									dedup
	 * Implementation		search hit			search miss			insert			space (ref)		moby.txt		actors.txt
	 * Red-Black BST		L+ClgN				cLgN				clgN				4N			 1.40				97.4
	 * Hashing (Linear prob) L					 L					 L   				4N to 16N	 0.76			    40.6
	 * R-way Trie			 L					logᵣN			 	 L				   (R+1)N		 1.12				out of memory
	 * TST					 L+lnN*				lnN*				L+lnN				4N			 0.72				38.7
	 * TST with R^2			 L+lnN*				lnN*				L+lnN				4N+R^2		 0.51				32.7
	 * 
	 * TST really adapts from data that is not random (* for random keys)
	 * 
	 */
	
	private Node root;
	
	/**
	 * Node : A TST node has 5 fields
	 * <li> A value
	 * <li> A character c
	 * <li> A reference to left TST
	 * <li> A reference to middle TST
	 * <li> A reference to right TST
	 * @author _CrY
	 *
	 */
	private class Node
	{
		private char c;
		private Value value;
		private Node left;
		private Node mid;
		private Node right;
	}
	
	void put(String key, Value val)
	{
		root=put(root, key, val, 0);
	}
	private Node put(Node x, String key, Value val, int d)
	{
		char c=key.charAt(d);
		if(x==null)		
		{
			x=new Node();
			x.c=c;
		}
		
		if(c<x.c)					x.left=put(x.left, key, val, d);
		else if(c>x.c)				x.right=put(x.right, key, val, d);
		else if(d<key.length()-1)	x.mid=put(x.mid, key, val, d+1);
		else						x.value=val;
		
		return x;
		
	}
	
	public boolean contains(String key)
	{
		return get(key)!=null;
	}
	

	/**
	 * Follow links corresponding to each character in the key
	 * <li> If less, take left link; if greater, take right link
	 * <li> If equal, take the middle link and move to the next key character.
	 * 
	 * <li> Search hit - Node where search ends has a non null value
	 * <li> Search miss - Reach a null link or node where search ends has a null value.
	 * @param key
	 * @return
	 */
	public Value get(String key)
	{
		Node x=get(root, key, 0);
		if(x==null)	return null;
		return x.value;
	}
	private Node get(Node x, String key, int d)
	{
		if(x==null)	return null;
		
		char c=key.charAt(d);
		if(c<x.c)					return get(x.left, key, d);
		else if(c>x.c)				return get(x.right, key, d);
		else if(d<key.length()-1)	return get(x.mid, key, d+1);
		else						return x;
	}
	
	/*
	 * Spell Checker: 26 way trie vs TST
	 * 
	 * 1. 26 way Trie - 26 null links in each leaf
	 * 2. TST - 3 null links in each leaf
	 * 
	 */
	
	/*
	 * TST with R^2 Branching at root
	 * 
	 * Hybrid of R-way Trie and TST
	 * 1. Do R^2 branching at root
	 * 2. Each of R^2 root nodes points to a TST
	 * 3. Have to take take of 1 and 2 letter words.
	 * 
	 */
}
