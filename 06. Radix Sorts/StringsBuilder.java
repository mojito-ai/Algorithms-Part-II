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
}
