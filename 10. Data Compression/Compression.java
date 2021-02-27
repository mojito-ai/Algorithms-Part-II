/**
* <h1> <b>Data Compression:</b> Various techniques and applications of data compression</h1>
* 
* <li> 1. Compression reduces the size of a file:
* <li> To save space when storing it.
* <li> To save time when transmitting it.
* <li> Most files have lots of redundancy.
* 
* <li> 2. Who needs compression?
* <li> Moore's law: # transistors on a chip doubles every 18–24 months.
* <li> Parkinson's law: data expands to fill space available.
* <li> Text, images, sound, video, …
* 
* <li> “ Everyday, we create 2.5 quintillion bytes of data—so much that
* 		 90% of the data in the world today has been created in the last
* 		 two years alone. ” — IBM report on big data (2011)
* 
* <li> Basic concepts ancient (1950s), best technology developed recently.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   26-02-2021
* 
*/

/*
 * Applications: 
 * 
 * 1. Generic file compression.
 * Files: GZIP, BZIP, 7z.
 * Archivers: PKZIP.
 * File systems: NTFS, HFS+, ZFS.
 * 
 * 2. Multimedia.
 * Images: GIF, JPEG.
 * Sound: MP3.
 * Video: MPEG, DivX™, HDTV.
 * 
 * 3. Communication.
 * ITU-T T4 Group 3 Fax.
 * V.42bis modem.
 * Skype.
 * 
 * 4. Databases. Google, Facebook, ....
 * 
 */
public class Compression {

	/*
	 * Lossless compression and expansion:
	 * 
	 * Message: Binary data B we want to compress
	 * Compress: Generates a "compressed" representation C(B) [We hope it uses fewer bits]
	 * Expand: Reconstructs original bitstream B.
	 * 
	 * 1. Basic model for data compression:
	 * 
	 * bistream B			_______			compressed version C(B)		_______		Orignal Bitstream B
	 * 						|	  |										|	  |
	 * 0110110101...	-->	|	  |	-->			1101011111...		-->	|	  |	-->	1101011111...
	 *						|_____|	  									|_____|	
	 *						Compress									 Expand
	 *
	 *2. Compression ratio: Bits in C(B)/Bits in B
	 *
	 *50-75% or better compression ratio for natural language.
	 */
	
	/*
	 * Food for thought: 
	 * 
	 * 1. Data compression has been omnipresent since antiquity:
	 * Number systems.
	 * Natural languages.
	 * Mathematical notation.
	 * 
	 * 2. Has played a central role in communications technology,
	 * Grade 2 Braille.
	 * Morse code.
	 * Telephone system.
	 * 
	 * 3. And is part of modern life.
	 * MP3.
	 * MPEG.
	 * 
	 * Q. What role will it play in the future?
	 */
	
	/*
	 * Genomic code:
	 * 
	 * Genome. String over the alphabet { A, C, T, G }.
	 * Goal. Encode an N-character genome: ATAGATGCATAG ...
	 * 
	 * 
	 * 1. Standard ASCII encoding.					2. Two bit encoding
	 * 	-8 bits per char.							 	-2 bits per char
	 * 	-8 N bits.										-2N bits
	 *
	 * char hex binary									char 	hex binary
	 *	A	41	01000001								 A 		41 	01000001
	 *	C	43	01000011								 C 		43 	01000011
	 *	T	54	01010100								 T 		54 	01010100
	 *	G	47	01000111								 G 		47 	01000111
	 * 
	 * Fixed-length code. k-bit code supports alphabet of size 2k
	 * 
	 * Amazing but true. Initial genomic databases in 1990s used ASCII.
	 */
	
	/**
	 * Binary standard input and standard output. Libraries to read and write bits from standard input and to standard output.
	 *
	 * @author _CrY
	 *
	 */
	@SuppressWarnings("unused")
	private class BinaryStdIn{
		
		boolean readBoolean() //read 1 bit of data and return as a boolean value
		{
			return false;
			
		}
		char readChar()// read 8 bits of data and return as a char value
		{
			return 0;
			
		}
		char readChar(int r)// read r bits of data and return as a char value
		{
			return 0;
			
		}
		//[similar methods for byte (8 bits); short (16 bits); int (32 bits); long and double (64 bits)]
		boolean isEmpty() //is the bitstream empty?
		{
			return false;
			
		}
		void close() //close the bitstream
		{
			
		}
	}
	
	private class BinaryStdOut{
		
	}
}
