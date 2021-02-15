/**
* <h1> TST (Ternary Search Tries): Store characters and values in nodes (not keys) </h1>
* 
* <li> Each node has 3 children : smaller (left), equal (middle), larger (right)
* <li> Fast Algorithms for sorting and searching strings : Joe L. Bentley & Robert Sedgewick
* 
* @author  Mohit Sharma
* @version 1.0
* @since   15-02-2021
* 
*/

public class TST<Value> {
	
	private Node root;
	private static final int R=256;		//extended ASCII
	
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
		
	}
	private Node put(Node x, String key, Value val, int d)
	{
		
	}
	
	public boolean contains(String key)
	{
		return get(key)!=null;
	}
	


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
	

}
