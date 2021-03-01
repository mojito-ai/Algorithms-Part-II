import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.TST;

/**
* <h1> <b>LZW Compression:</b> By Abraham Lempel, Jacob Ziv & Terry Welch</h1>
* 
* <li> Statistical methods
* 
* <li> 1. Static model. Same model for all texts.
* <li> Fast.
* <li> Not optimal: different texts have different statistical properties.
* <li> Ex: ASCII, Morse code.
* 
* <li> 2. Dynamic model. Generate model based on text.
* <li> Preliminary pass needed to generate model.
* <li> Must transmit the model.
* <li> Ex: Huffman code.
* 
* <li> 3. Adaptive model. Progressively learn and update model as you read text.
* <li> More accurate modeling produces better compression.
* <li> Decoding must start from beginning.
* <li> Ex: LZW
* 
* @author  Mohit Sharma
* @version 1.0
* @since   1-03-2021
* 
*/

public class LZW {

	/*
	 * LZW Implementation Details
	 * 
	 * 1. How big to make ST?
	 * 		How long is message?
	 * 		Whole message similar model?
	 * 		[many other variations]
	 * 
	 * 2. What to do when ST fills up?
	 * 		Throw away and start over. [GIF]
	 * 		Throw away when not effective. [Unix compress]
	 * 		[many other variations]
	 * 
	 * 3. Why not put longer substrings in ST?
	 * 		[many variations have been developed]
	 * 
	 */
	private static final int R=256; //extended ASCII
	private static final int W=8;	//fixed length W-bit codewords
	private static final int L=999;
	
	/**
	 * LZW compression.
	 * <li> Create ST associating W-bit codewords with string keys.
	 * <li> Initialize ST with codewords for single-char keys.
	 * <li> Find longest string s in ST that is a prefix of unscanned part of input.
	 * <li> Write the W-bit codeword associated with s.
	 * <li> Add s + c to ST, where c is next char in the input.
	 */
	public static void compress()
	{
		String input = BinaryStdIn.readString();
		/*
		 * Q. How to represent LZW compression code table?
		 * A. A trie to support longest prefix match.
		 */
		TST<Integer> st = new TST<>();
		for(int i=0; i<R; i++)
			st.put(""+(char)i, i);	//codewords for single char, radix R keys
		int code = R+1;
		
		while(input.length()>0)	
		{
			String s=st.longestPrefixOf(input);	//find longest prefix match s
			BinaryStdOut.write(st.get(s),W);	//write W-bit codeword for s
			int t=s.length();
			if(t<input.length() && code<L)
				st.put(input.substring(0,t+1), code++);	//add new codeword
			input=input.substring(t);	//scan past s in input
		}
		
		BinaryStdOut.write(R,W);	//write stop codeword & close input stream
		BinaryStdOut.close();
	}
	
	/**
     * Reads a sequence of bit encoded using LZW compression with
     * 12-bit codewords from standard input; expands them; and writes
     * the results to standard output.
     */
	/*
	 * LZW expansion.
	 * Create ST associating string values with W-bit keys.
	 * Initialize ST to contain single-char values.
	 * Read a W-bit key.
	 * Find associated string value in ST and write it out.
	 * Update ST.
	 * 
	 */
    public static void expand() {
        String[] st = new String[L];
        int i; // next available codeword value

        /*
         * Q. How to represent LZW expansion code table?
         * A. An array of size 2W.
         */
        // initialise symbol table with all 1-character strings
        for (i = 0; i < R; i++)
            st[i] = "" + (char) i;
        st[i++] = "";                        // (unused) lookahead for EOF

        int codeword = BinaryStdIn.readInt(W);
        if (codeword == R) return;           // expanded message is empty string
        String val = st[codeword];

        while (true) {
            BinaryStdOut.write(val);
            codeword = BinaryStdIn.readInt(W);
            if (codeword == R) break;
            String s = st[codeword];
            if (i == codeword) s = val + val.charAt(0);   // special case hack
            if (i < L) st[i++] = val + s.charAt(0);
            val = s;
        }
        BinaryStdOut.close();
    }
}
