/**
* <h1>String Builder data type: Sequence of characters (mutable) </h1>
* 
* <li> Underlying implementation of resizing char [] array and length
* <li> StringBuilder is similar to String, but thread safe and slower
* <li> Substring take time ~ N as we have to create a new resizing array.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   13-02-2021
* 
*/

public class StringsBuilder {
	//String vs StringBuilder
	
	
	//How to effecienty reverse a string
	public static String reverse(String s)
	{
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
			rev+=s.charAt(i);				//Quadratic time
		return rev;
	}

	public static String reverse2(String s)
	{
		StringBuilder rev=new StringBuilder();
		for(int i=s.length()-1;i>=0;i--)
			rev.append(s.charAt(i));		//Linear Time
		return rev.toString();
	}
	
	/*Array of suffixes: How to effeciently form array of suffixes
	 * 
	 * Input string: a a c a a g
	 * 				 0 1 2 3 4 5
	 * 
	 * Suffixes 	 0 | a a c a a g
	 * 				 1 | a c a a g
	 * 				 2 | c a a g
	 * 				 3 | a a g
	 * 				 4 | a g
	 * 				 5 | g
	 */
	
	public static String [] suffixes(String s)
	{
		int N=s.length();
		String [] suffixes = new String [N];
		for(int i=0; i<N; i++)
			suffixes[i]=s.substring(i,N);			// Linear time (Java 6) & Quadratic Time  (Java 7)
		return suffixes;
	}
	
	public static String [] suffixes2(String s)
	{
		int N=s.length();
		StringBuilder sb = new StringBuilder (s);
		String [] suffixes = new String [N];
		for(int i=0; i<N; i++)
			suffixes[i]=sb.substring(i, N);			// Quadratic time and Quadratic space
		return suffixes;
	}
	
	/*Longest Common Prefix: How to compute the longest common prefix?
	 * 
	 * E.g. 		p r e f e t c h
	 * 
	 * 				0 1 2 3 4 5 6 7
	 * 
	 * 				p r e f i x
	 */
	
	/**
	 * Running time: Proportional to length D of longest common prefix
	 * <li> Also can compute compareTo() in sublinear time
	 * @param s
	 * @param t
	 * @return
	 */
	public static int lcp(String s, String t)
	{
		int N=Math.min(s.length(), t.length());
		for(int i=0; i<N; i++)
			if(s.charAt(i)!=t.charAt(i))			// Linear Time (worst case) & Sub-linear time (typical case)
				return i;
		return N;
	}
}
