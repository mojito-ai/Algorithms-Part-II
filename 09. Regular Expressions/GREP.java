import edu.princeton.cs.algs4.StdIn;

/**
* <h1> <b>GREP:</b> Generalized Regular Expression Print.</h1>
* 
* <li> Grep: Take a RE as a command-line argument and print the lines from standard input having some substring that is matched by the RE.
* <li> Bottom line: Worst case for grep (proportional to MN) is the same as for brute-force substring search.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   24-02-2021
* 
*/
public class GREP {
	
	/**
	 * Typical grep application: crossword puzzles
	 * 
	 * <li> Industrial Strength grep implementation: 
	 * <li> To complete the implementation:
	 * <li> Add multiway or.
     * <li>	Handle metacharacters.
	 * <li>	Support character classes.
	 * <li>	Add capturing capabilities.
	 * <li>	Extend the closure operator.
	 * <li>	Error checking and recovery.
	 * <li>	Greedy vs reluctant matching.
	 * @param args
	 */
	public static void main(String [] args)
	{
		//contains RE as a substring
		String regexp = "(.*" + args[0] + "*.)";
		NFA nfa = new NFA(regexp);
		while(StdIn.hasNextLine())
		{
			String line = StdIn.readLine();
			if(nfa.recognizes(line))
				System.out.println(line);
		}
	}

}
