/**
* <h1>Strings in Java: String is sequence of characters</h1>
* 
* <li> Important fundamental abstraction
* <li> Information processing
* <li> Genomic sequences
* <li> Communication systems (e.g. Email)
* <li> Programming systems (e.g. Java Programs)
*
* "The digital information that underlies biochemistry, cell biology, and development can be represented by a simple string of
*  G's, A's, T's & C's. This string is the root data structure of an organism's biology" - M. V. Olson
*  
* @author  Mohit Sharma
* @version 1.0
* @since   13-02-2021
* 
*/

public final class Strings implements Comparable<String> {

	private char [] value;	//characters
	private int offset;		//index of first character in array
	private int length;		//length of string
	private int hash;		//cache of hashCode()

	/*
	 * The char data type: 
	 * 
	 * 1. C - char datatype - Typically an 8 bit integer
	 * 						- Supports 7 bit ASCII
	 * 						- Can represent only 256 characters
	 * 
	 * 2. Now-a-days people use UNICODE where a character is a 16-bit-integer
	 * 
	 * 3. Java char data type: A 16-bit unsigned integer
	 * 						  - Supports orignal 16 bit UNICODE
	 * 					      - Supports 21 bit UNICODE v3.0 (awkwardly)
	 */
	
	public int length()
	{
		
	}
	
	/**
	 * Indexing - Get the ith character
	 * @param i
	 * @return
	 */
	public char charAt(int i)
	{
		
	}
	
	/**
	 * The string data type: Sequence of characters (immutable)
	 * 
	 * <li> String concatenation: Append one character at the end of another string
	 * @param offset
	 * @param length is the number of characters
	 * @param value
	 */
	private Strings(int offset, int length, char [] value)
	{
		
	}
	
	/**
	 * Substring extraction: Get a contiguous subsequence of characters
	 * @param from
	 * @param to
	 * @return
	 */
	public String substring(int from, int to)
	{
		
	}
	
	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
