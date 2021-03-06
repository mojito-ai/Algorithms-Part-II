import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;

/**
* <h1> <b>Huffman Compression</b> By David Huffman</h1>
* 
* <li> Count frequency for each character in input
* <li> Start with one node corresponding to each character with weight equal to frequency
* <li> Select two tries with min weight
* <li> Merge into single trie with cumulative weight.
* 
* <li> Running time: N+RlogR; 		N=Input size		R=Alphabet size
* <li> Proposition. [Huffman 1950s] Huffman algorithm produces an optimal prefix-free code. (optimal in the sense that no prefix free code uses fewer bits
* <li> Pf. See textbook.
* 
* @author  Mohit Sharma
* @version 2.0
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
 * A. Ensure that no codeword is a prefix of another.
 * 
 * 		Ex1: Fixed length code
 * 		Ex2: Append special stop char to each codeword
 * 		Ex3: general prefix free code
 */

public class Huffman {
	
	// alphabet size of extended ASCII
    private static final int R = 256;
	
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
	private static class Node implements Comparable<Node>
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
	
	public static void compress() {
        // read the input
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        // tabulate frequency counts
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;

        // build Huffman trie
        Node root = buildTrie(freq);

        // build code table
        String[] st = new String[R];
        buildCode(st, root, "");

        // print trie for decoder
        writeTrie(root);

        // print number of bytes in original uncompressed message
        BinaryStdOut.write(input.length);

        // use Huffman code to encode input
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    BinaryStdOut.write(false);
                }
                else if (code.charAt(j) == '1') {
                    BinaryStdOut.write(true);
                }
                else throw new IllegalStateException("Illegal state");
            }
        }

        // close output stream
        BinaryStdOut.close();
    }

	 // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.c] = s;
        }
    }

	
	/**
	 * Running time : Linear in input size N
	 */
	public static void expand()
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
	
	/**
	 * <li> Implementation.
	 * <li> Pass 1: tabulate char frequencies and build trie.
	 * <li> Pass 2: encode file by traversing trie or lookup table.
	 * @return
	 */
	private static Node readTrie()
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
	
	/**
	 * Q. How to find best prefix-free code?
	 * 
	 * <li> Huffman algorithm:
	 * <li> Count frequency freq[i] for each char i in input.
	 * <li> Start with one node corresponding to each char i (with weight freq[i]).
	 * 
	 * <li> Repeat until single trie formed:
	 * <li>		� select two tries with min weight freq[i] and freq[j]
	 * <li>		� merge into single trie with weight freq[i] + freq[j]
	 * @param freq
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Node buildTrie(int [] freq)
	{
		MinPQ<Node> pq = new MinPQ<>();
		for(char i=0; i<R; i++)
			if(freq[i]>0)			//initialize PQ with singleton tries
				pq.insert(new Node(i, freq[i], null, null));
		
		while(pq.size()>1)
		{
			Node x=pq.delMin();		//merge two smallest tries
			Node y=pq.delMin();
			Node parent=new Node('\0', x.freq+y.freq, x, y);	//not used for internal nodes
			pq.insert(x);
		}
		
		return pq.delMin();
	}
	
	/*
	 * Shannon-Fano codes
	 * Q. How to find best prefix-free code?
	 * 
	 * 		Shannon-Fano algorithm:
	 * 			-Partition symbols S into two subsets S0 and S1 of (roughly) equal freq.
	 * 			-Codewords for symbols in S0 start with 0; for symbols in S1 start with 1.
	 * 			-Recur in S0 and S1.
	 * 
	 * char freq encoding				char	freq	encoding
	 * A 	5	 0...					B		2		1...
	 * C 	1 	 0...					D		1		1...
	 *									R		2		1...
	 * S0=codewords starting 			!		1		1...
	 *    with 0
	 *    								S1=codewords starting with 1
	 *    
	 *    Problem 1. How to divide up symbols?
	 *    Problem 2. Not optimal!
	 */										
	
	/*
	 * Q. Suppose you have a n-byte input stream consisting of n 7-bit ASCII characters. Find compression ratio if each
	 * 	  ASCII character appears with equal frequency & we will use Huffman compression
	 * A. 7/8	The Huffman Trie will be complete binary trie of height 7 (with the 128 characters in leaves)
	 * 
	 */

}
