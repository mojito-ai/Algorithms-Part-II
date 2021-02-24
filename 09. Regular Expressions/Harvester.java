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
* @version 1.0
* @since   24-02-2021
* 
*/

public class Harvester {
	
	public static void main(String [] args)
	{
		String regexp = args[0];
		In in = new In(args[1]);
		String input=in.readAll();
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find())
		{
			System.out.println(matcher.group());
		}
	}

}
