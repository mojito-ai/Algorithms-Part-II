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
