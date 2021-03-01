import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

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

	private static final int R=256; //extended ASCII
	private static final int W=8;	//fixed length W-bit codewords
	
	public static void compress()
	{
		
	}
}
