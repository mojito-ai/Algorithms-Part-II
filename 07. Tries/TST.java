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
		
	}
	private Node get(Node x, String key, int d)
	{

	}
	

}
