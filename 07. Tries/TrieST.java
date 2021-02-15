/**
* <h1> R-way Tries: [from reTrieval, but pronounced as "try"] </h1>
* 
* <li> Faster than hashing, more flexible than BST
* <li> For now, store characters in nodes (not keys)
* <li> Each node has R children, one for each possible character.
* <li> Store values in nodes corresponding to last character in keys.

* @author  Mohit Sharma
* @version 1.0
* @since   15-02-2021
* 
*/

public class TrieST<Value> {
	
	/*
	 * Performance: 
	 * 
	 *  1. Search Hit: Need to examine all L characters for equality
	 *  
	 *  2. Search Miss: Could have mismatch on first character
	 *  				Typical case: Need to examine only a few characters (sublinear)
	 *  
	 *  3. Space: R null links at each leaf (but sublinear space possible if many short strings share common prefixes)
	 *  
	 *  Bottom line: Fast search hit and even faster search miss, but wastes space
	 * 
	 */
	private Node root;
	private static final int R=256;		//extended ASCII
	
	/**
	 * Node : A value plus reference to R nodes
	 * <li> Neither keys nor characters are explicitly stored
	 * <li> Each character is implicitly defined by link index
	 * @author _CrY
	 *
	 */
	private class Node
	{
		private Object value;
		@SuppressWarnings("unchecked")
		private Node [] next =  (TrieST<Value>.Node[]) new Object[R];
	}
	
	TrieST()
	{
		root=new Node();
	}
	
	/**
	 * Follow links corresponding to each character in the key
	 * <li> Encounter a null link : Create a new node
	 * <li> Encounter the last character of the key: Set value in that node
	 * @param key
	 * @param val
	 */
	void put(String key, Value val)
	{
		root=put(root, key, val, 0);
	}
	private Node put(Node x, String key, Value val, int d)
	{
		if(x==null)		x=new Node();
		
		if(d==key.length())		
		{
			x.value=val;
			return x;
		}
		
		char c=key.charAt(d);
		x.next[c]=put(x.next[c], key, val, d+1);
		
		return x;
	}
	
	public boolean contains(String key)
	{
		return get(key)!=null;
	}
	
	/**
	 * Follow links corresponding to each character in the key
	 * <li> Search hit - Node where search ends has a non null value.
	 * <li> Search miss - Reach null link or node where search ends has a null value
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Value get(String key)
	{
		Node x = get(root, key, 0);
		if(x==null)	return null;
		return (Value) x.value;
	}
	private Node get(Node x, String key, int d)
	{
		if(x==null)		return null;
		if(d==key.length())		return x;
		char c=key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	
	void delete(String key)
	{
		
	}

	
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
