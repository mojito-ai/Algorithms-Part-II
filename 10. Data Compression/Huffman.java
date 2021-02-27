import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
* <h1> <b>Huffman Compression</b> By David Huffman</h1>
* 
* <li> 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   27-02-2021
* 
*/

/*	Variable Length codes: Use different number of bits to encode different chars.
 *	Ex. Morse code: 
 *						. . . _ _ _ . . .
 *
 * 		Issue: Ambiguity = SOS? V7? IAMIE? EEWNI? 
 * 
 * 		In practise : Use a medium gap to seperate codewords
 * 
 * Q. How to avoid ambiguity?
 * A. Ensure that no codeword is a perfix of another.
 * 
 * 		Ex1: Fixed length code
 * 		Ex2: Append special stop char to each codeword
 * 		Ex3: general prefix free code
 */

public class Huffman {
	
	/**
	 * Prefix free codes: trie representation
	 * <li> Q. How to represent the prefix free code?
	 * <li> A. A binary trie: Chars in leaves, Codeword is path from root to leaf.
	 * 
	 * Prefix free codes: Compression and expansion
	 * 
	 * <li> Compression: Method 1=Start at leaf, follow path up to the root, print bits in reverse
	 * 					 Method 2=Create a ST of key value pairs.
	 * 
	 * <li> Expansion: Start at root, Go left if bit is 0, go right if 1. If leaf node, print char and return to root.
	 * @author _CrY
	 *
	 */
	private class Node implements Comparable<Node>
	{
		private final char c;	//used only for leaf nodes
		private final int freq;	//used only for compress
		private final Node left, right;
			
		Node(char c, int freq, Node left, Node right)	//initialising constructor
		{
			this.c=c;
			this.freq=freq;
			this.left=left;
			this.right=right;
		}
		
		public boolean isLeaf()
		{
			return left==null && right==null;	//is node a leaf?
		}
		
		@Override
		public int compareTo(Node that) {
			return this.freq-that.freq;		//compare nodes by frequency.
		}
		
	}
	
	/**
	 * Running time : Linear in input size N
	 */
	public void expand()
	{
		Node root=readTrie();	//read in encoding trie
		int N=BinaryStdIn.readInt();	//read in number of chars
		for(int i=0; i<N; i++)
		{
			Node x=root;
			while(!x.isLeaf())
			{
				if(!BinaryStdIn.readBoolean())
					x=x.left;
				else				//expand codeword for ith character
					x=x.right;
			}
			BinaryStdOut.write(x.c, 8);
		}
		BinaryStdOut.close();
	}
	
	private Node readTrie()
	{
		if(BinaryStdIn.readBoolean())
		{
			char c=BinaryStdIn.readChar(8);
			return new Node(c, 0 ,null, null);
		}
		
		Node x=readTrie();
		Node y=readTrie();
		return new Node('\0', 0, x, y);
	}
	
	@SuppressWarnings("unused")
	private static void writeTrie(Node x)
	{
		if(x.isLeaf())
		{
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.c, 8);
			return;
		}
		
		BinaryStdOut.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}

}
