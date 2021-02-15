/**
* <h1> R-way Tries: [from reTrieval, but pronounced as "try"] </h1>
* 
* <li> Faster than hashing, more flexible than BST
* <li> For now, store characters in nodes (not keys)
* <li> Each node has R children, one for each possible character.
* <li> Store values in nodes corresponding to last character in keys.
* <li> Cost summary			Implementation			search miss			search miss			insert			space(ref)
* <li>						R-way Trie					L					logᵣN			 L				  (R+1)N
* 
* @author  Mohit Sharma
* @version 2.0
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
	 *  				Typical case: Need to examine only a few characters (sub-linear)
	 *  
	 *  3. Space: R null links at each leaf (but sub-linear space possible if many short strings share common prefixes)
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
	
	/**
	 * R-Way Trie: Method of choice for small R
	 * <li> Too much memory for large R
	 * <li> The order in which the strings are inserted DO NOT determine the shape of the trie
	 */
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
	
	/**
	 * To delete a key-value pair: 
	 * <li> To find a node corresponding to key and set value to null.
	 * <li> If node has null value and all null links, remove that node (& recur).
	 * @param key
	 */
	void delete(String key)
	{
		root=delete(root, key, 0);
	}
	private Node delete(Node x, String key, int d)
	{
		if(d==key.length())		
		{
			x.value=null;
			return x;
		}
		
		char c=key.charAt(d);
		x.next[c]=delete(x.next[c], key, d+1);
		
		if(x.value==null)
		{
			boolean flag=true;
			for(int i=0; i<R; i++)
				if(x.next[i].value!=null)
				{
					flag=false;
					break;
				}
			
			if(flag==true)
				x=null;
		}
				
			return x;	
	}

	/*
	 * Popular Interview Question: Design a data structure to perform efficient spell checking
	 * 
	 * Build a 26 way trie (key=word, value=bit)
	 * 
	 */
	
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
	
	//Character based Trie Opearations: The string ST API supports several useful character based operations
	/**
	 * Ordered Iteration: To iterate through all keys in sorted order
	 * <li> Do inorder traversal of trie: add keys encountered to a queue
	 * <li> Maintain sequence of characters on path from root to node.
	 * @return
	 */
	Iterable<String> keys()
	{
		Queue<String> queue=new Queue<>();
		collect(root, "", queue);
		return queue;
	}
	
	private void collect(Node x, String prefix, Queue<String> q)
	{
		if(x==null)	return;
		
		if(x.value!=null)	q.enqueue(prefix);
		for(int c=0; c<R; c++)
			collect(x.next[c], prefix+c, q);
	}
	
	/**
	 * Keys with prefix "sh" : "she" , "shells" , "shore"
	 * <li> Keys that have s as a prefix
	 * <li> Applications: Autocomplete in a cell phone, Search bar, text editor, or shell
	 * <li> User types characters one at a time.
	 * <li> System reports all matching strings
	 * 
	 * @param s
	 * @return
	 */
	Iterable<String> keysWithPrefix(String prefix)
	{
		Queue<String> queue=new Queue<>();
		Node x=get(root, prefix, 0);	//root of subtrie for all strings beginning with the given prefix
		collect(x, prefix, queue);
		return queue;
	}
	
	/**
	 * Key that is the longest prefix of "shellsort" : "shells"
	 * @param Longest key that is a prefix of s
	 * @return
	 */
	Iterable<String> LongestPrefixOf(String s)
	{
		
	}
	
	/**
	 * Keys that match s (where . is a wildcard)
	 * <li> Wildcard match: Keys that match ".he": "she" & "the"
	 * @param s
	 * @return
	 */
	Iterable<String> keysThatMatch(String s)
	{
		
	}
	
}
