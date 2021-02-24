import edu.princeton.cs.algs4.StdIn;

/**
* <h1> <b>GREP:</b> Generalized Regular Expression Print.</h1>
* 
* <li> Grep. Take a RE as a command-line argument and print the lines from standard input having some substring that is matched by the RE.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   24-02-2021
* 
*/
public class GREP {
	
	public static void main(String [] args)
	{
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
