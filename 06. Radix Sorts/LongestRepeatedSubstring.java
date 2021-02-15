import java.util.Arrays;

/**
* <h1> Longest Repeated Substring: Given a string of N characters, find the longest repeated substring
* 
* <li> Brute force: Try all indices i & j for start of possible match.
* <li> Compute longest common prefix (LCP) for each pair.
* <li> Running time: N^2/2 possible choices for i & j. Finding longest common prefix takes atmost D character compares. 
* <li> Time ~ Dn^2 ; where D is the length of the longest common prefix
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   15-02-2021
* 
*/

public class LongestRepeatedSubstring {
	
	/**
	 * There is a flaw in 3 way string quicksort - if LRS is long
	 * <li> Longest repeated substring is very long
	 * <li> Same letter repeated N times
	 * <li> Two copies of same Java codebase
	 * <li> D length of longest match
	 * <li> LRS needs atleast 1+2+3+---+D character compares (Quadratic in D for LRS & for sort)
	 * @param s
	 * @return
	 */
	public String lrs(String s)
	{
		int N=s.length();
		String [] suffixes=new String[N];
		
		for(int i=0; i<N; i++)
			suffixes[i]=s.substring(i, N);
		
		Quick3string.sort(suffixes);
		String lrs="";
		
		for(int i=0; i<N-1; i++)
		{
			int len=lcp(suffixes[i], suffixes[i+1]);
			if(len>lrs.length())
				lrs=suffixes[i].substring(0, len);
		}
		return lrs;
	}
	
	public static int lcp(String v, String w)
	{
		int N=Math.min(v.length(), w.length());
		
		for(int i=0; i<N; i++)
			if(v.charAt(i)!=w.charAt(i))
				return i;
		return N;
	}

}
