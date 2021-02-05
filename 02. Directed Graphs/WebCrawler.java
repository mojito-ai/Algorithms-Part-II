import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.In;

/**
* <h1>Web Crawler: Digraph BFS application. Crawl Internet, starting from some root website. </h1>
* 
* <li> The Internet is a digraph. Use BFS with implicit digraph
* <li> Start at some root website (say https://www.princeton.edu)
* <li> Maintain a Queue of websites to explore
* <li> Maintain a SET of discovered websites.
* <li> Dequeue the next website and enqueue websites to which it links (provided you haven't done so before)
* <li> Why not DFS? Internet is not fixed (some pages generate new ones when visited and this could trap search)
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-02-2021
* 
*/

public class WebCrawler {
	
	public static void main(String [] args)
	{
		Queue<String> q=new Queue<>();
		SET<String> visited=new SET<>();
		
		String s="https://www.princeton.edu";
		q.enqueue(s);
		visited.add(s);
		
		while(!q.isEmpty())
		{
			String v=q.dequeue();
			System.out.println(v);
			In in=new In(v);
			String input=in.readAll();
			
			String regexp = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern=Pattern.compile(regexp);
			Matcher matcher=pattern.matcher(input);
			while(matcher.find())
			{
				String w=matcher.group();
				if(!visited.contains(w))
				{
					visited.add(w);
					q.enqueue(w);
				}
			}
			
		}
	}
}
