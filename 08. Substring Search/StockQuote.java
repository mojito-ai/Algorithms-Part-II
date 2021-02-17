import edu.princeton.cs.algs4.In;

/**
* <h1> <b>Substring Search:</b> Find pattern of length M in a text of length N. (Typically N>>M) </h1>
* 
* <li> Pattern : N E E D L E
* <li> Text : I N A H A Y S T A C K N E E D L E I N A
* 
* <li> Applications: 
* <li> 1. Find and Replace
* <li> 2. Computer Forensics: Search memory or disk for signatures. (e.g. all URLs or RSA keys that the user has entered)
* <li> 3. Identify patterns indicative of SPAM : PROFITS, LOSE WEIGHT, THIS IS A ONE TIME MAILING
* <li> 4. Electronic surveillance: Building a machine to find "Attack at Dawn"
* <li> 5. Screen Scraping: Extract relevant data from a web page
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   17-02-2021
* 
*/

public class StockQuote {
	
	/**
	 * Find string delimited by <b> and </b> after the first occurance of pattern "Last Trade:"
	 * @param args
	 */
	public static void main(String [] args)
	{
		String name="https://finance.yahoo.come/g?s=";
		In in=new In(name+args[0]);
		String text=in.readAll();
		int start=text.indexOf("Last Trade:", 0);
		int from=text.indexOf("<b>", start);
		int to=text.indexOf("</b>", from);
		String price=text.substring(from+3, to);
		System.out.println(price);
	}
}
