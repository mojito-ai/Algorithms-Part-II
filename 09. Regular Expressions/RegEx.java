/**
* <h1> <b>Regular Expression:</b> Pattern matching = Finding one of a specified set of strings in text.</h1>
* 
* <li> Substring search = Find a single string in text vs Pattern Matching
* <li> Genomics = Fragile X syndrome is a common cause of mental retardation.
* <li> Human genome contains triplet repeats of CGG or AGG, bracketed by GCG at the beginning and CTG at the end.
* <li> Number of repeats is variable, and correlated with syndrome.
* <li> Pattern: GCG(CGG|AGG)*CTG
* <li> Text: GCGGCGTGTGTGCGAGAGAGTGGGTTTG GCGCGGAGGCGGCTG GCGGCGTCGT
* 
* @author  Mohit Sharma
* @version 1.0
* @since   23-02-2021
* 
*/

public class RegEx {
	
	/*
	 * Applications: 
	 * 
	 * 1. Syntax highlighting : Highlight keywords, Grey out comments
	 * 
	 * 2. Google Code search : Search public source code
	 * 						   Search via regular expression
	 * 
	 * 3. Test if string matches some pattern: 
	 * 		-Process natural language
	 * 		-Scan for virus signatures
	 * 		-Specify a programming language
	 * 		-Access information in digital libraries
	 * 		-Search Genome using PROSITE patterns
	 * 		-Filter text (spam, NetNanny, Malware)
	 * 		-Validate data - entry fields (dates, email, URL)
	 * 
	 * 4. Parse Text files:
	 * 		-Compile a java program
	 * 		-Crawl and index the web
	 * 		-Read in data stored in adhoc input file formats
	 * 		-Create java documentation from Javadoc comments
	 * 
	 */
	
	/*
	 * A regular expression is a notation to specify a set (possibly infinite) of strings.
	 * 
	 * Operation			Order				Example RE				Matches				Does not match
	 * 
	 * Concatenation		3					AABAAB					AABAAB				every other string
	 * 
	 * Or					4					AA|BAAB					AA					every other string
	 * 																 	BAAB
	 * 
	 * Closure				2					AB*A					AA					AB
	 * (0 or more 														ABBBBBBBA			ABABA	
	 *  occurances)
	 *  
	 * Parentheses							A(A|B)AAB					AAAAB				every other string
	 * 																	ABAAB				
	 * 						1
	 * 										(AB)*A						A					AA
	 * 																	ABABABABABA			ABBA					
	 * 		
	 */
	
	/*
	 * Regular Expression Shortcuts: Additional operations are often added for convenience
	 * 
	 *  Operation			Example RE					Matches				Does not match
	 * 
	 * Wildcard					.U.U.U.					CUMULUS				SUCCUBUS
	 * 													JUGULUM				TUMULTUOUS
	 * 
	 * Character-Class			[A-Za-z][a-z]*			word				camelCase
	 * 													Capitalized			4illegal
	 * 
	 * Atleast one				A(BC)+DE				ABCDE				ADE
	 * 													ABCDBCDE			BCDE	
	 * 
	 * Exactly k				[0-9]{5}-[0-9]{4}		08540-1111			111111111
	 *  												19072-5541			166-54-111
	 * 
	 * 
	 * 
	 */

}
