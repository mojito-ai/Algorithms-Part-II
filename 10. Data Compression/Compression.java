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
}
