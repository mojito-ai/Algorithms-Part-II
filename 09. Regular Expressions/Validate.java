/**
* <h1> <b>Validate:</b> Regular expressions in Java.</h1>
* 
* <li> Validity checking : Does the input match the regexp?
* <li> Java String Library : Use input.matches(regexp) for basic RE matching. 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   24-02-2021
* 
*/

/*
 * Regular expressions in other languages:
 * 
 * 1. Broadly applicable programmer's tool.
 * 	-Originated in Unix in the 1970s.
 * 	-Many languages support extended regular expressions.
 * 	-Built into grep, awk, emacs, Perl, PHP, Python, JavaScript, ...
 * 
 * ex: % grep 'NEWLINE' *\* .java ---> Print all lines containing NEWLINE which occurs in any file with a .java extension
 * 
 * ex. % egrep '^[qwertyuiop]*[zxcvbnm]*$' words.txt | egrep '...........'
 * 		typewritten
 * 
 * 2. PERL. Practical Extraction and Report Language.
 * 
 * ex. % perl -p -i -e 's|from|to|g' input.txt --> replace all occurrences of from with to in the file input.txt
 * 
 * ex. % perl -n -e 'print if /^[A-Z][A-Za-z]*$/' words.txt --> print all words that start with uppercase letter
 *
 */

public class Validate {
	
	public static void main(String [] args)
	{
		String regexp=args[0];
		String input=args[1];
		System.out.println(input.matches(regexp));
	}

}
