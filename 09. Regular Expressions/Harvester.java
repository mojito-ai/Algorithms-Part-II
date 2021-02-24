import java.util.regex.Matcher;
import java.util.regex.Pattern;
import edu.princeton.cs.algs4.In;

/**
* <h1> <b>Harvester:</b> Print all substrings of input that match a RE.</h1>
* 
* <li> ex. % java Harvester "gcg(cgg|agg)*ctg" chromosomeX.txt		--> Harvest pattern from DNA
*			gcgcggcggcggcggcggctg
*			gcgctg
*			gcgctg
*			gcgcggcggcggaggcggaggcggctg
*
* <li> % java Harvester "http://(\\w+\\.)*(\\w+)" http://www.cs.princeton.edu		--> harvest links from website
*			http://www.princeton.edu
*			http://www.google.com
*			http://www.cs.princeton.edu/news
* 
* @author  Mohit Sharma
* @version 2.0
* @since   24-02-2021
* 
*/

/*
 * 1. Warning. Typical implementations do not guarantee performance!
 * 
 * % java Validate "(a|aa)*b" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaac 				1.6 seconds
 * % java Validate "(a|aa)*b" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac 			3.7 seconds
 * % java Validate "(a|aa)*b" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac 			9.7 seconds
 * % java Validate "(a|aa)*b" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac 		23.2 seconds
 * % java Validate "(a|aa)*b" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac 		62.2 seconds
 * % java Validate "(a|aa)*b" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac 	161.6 seconds
 * 
 * 2. SpamAssassin regular expression. 
 * 
 * % java RE "[a-z]+@[a-z]+([a-z\.]+\.)+[a-z]+" spammer@x...................... 
 * Takes exponential time on pathological email addresses.
 * Troublemaker can use such addresses to DOS a mail server. 
 * 
 */

/*
 * 3. Back-references.
 * 
 * \1 notation matches subexpression that was matched earlier.
 * Supported by typical RE implementations.
 * 
 * (.+)\1 // beriberi couscous
 * 1?$|^(11+?)\1+ // 1111 111111 111111111
 * 
 * 4. Some non-regular languages.
 * Strings of the form ww for some string w: beriberi.
 * Unary strings with a composite number of 1s: 111111.
 * Bitstrings with an equal number of 0s and 1s: 01110100.
 * Watson-Crick complemented palindromes: atttcggaaat.
 * Remark. Pattern matching with back-references is intractable.
 * 
 */
public class Harvester {
	
	public static void main(String [] args)
	{
		String regexp = args[0];
		In in = new In(args[1]);
		String input=in.readAll();
		Pattern pattern = Pattern.compile(regexp);	//compile() creates a Pattern(NFA) from RE
 		Matcher matcher = pattern.matcher(input);	//matcher() creates a Matcher(NFA simulator) from NFA and text
		while(matcher.find())						//find() looks for the next match
		{
			System.out.println(matcher.group());	//group() returns the substring most recently found by find()
		}
	}

	/*
	 * Context:
	 * 
     * Abstract machines, languages, and nondeterminism.
     * Basis of the theory of computation.
     * Intensively studied since the 1930s.
     * Basis of programming languages.
     * 
     * Compiler. A program that translates a program to machine code.
     * 		KMP string -> DFA.
     * 		grep RE -> NFA.
  	 * 		javac Java language -> Java byte code
	 * 
	 * 
	 */
}
