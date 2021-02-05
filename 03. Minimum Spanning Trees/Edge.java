/**
* <h1>Edge: Weighted Edge abstraction needed for MST construction</h1>
* 
* <li> Edges should be Comparable type
* 
* @author  Mohit Sharma
* @version 1.0
* @since   05-02-2021
* 
*/

public class Edge implements Comparable<Edge>
{
	private final int v, w;
	private final double weight;
	
	/**
	 * Create a weighted edge e
	 * @param v
	 * @param w
	 * @param weight
	 */
	Edge(int v, int w, double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	
	/**
	 * Either endpoint
	 * <li> Idiom: int v=e.either()
	 * @return
	 */
	int either()
	{
		return v;
	}
	
	/**
	 * The endpoint that is not v
	 * <li> Idiom: int w=e.either(v)
	 * @param vertex
	 * @return
	 */
	int other(int vertex)
	{
		if(vertex==v)	return w;
		else 			return v;
	}
	
	/**
	 * Return the weight of the edge
	 * @return
	 */
	double weight()
	{
		return weight;
	}
	
	@Override
	public int compareTo(Edge that) 
	{
		if(this.weight<that.weight)			return -1;
		else if(this.weight>that.weight)	return +1;
		else 								return 0;
	}
}
