/**
* <h1>Directed Edge: Weighted Directed Edge abstraction needed for Directed Edge weighted Graph construction</h1>
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   09-02-2021
* 
*/

public class DirectedEdge 
{
	private final int v, w;
	private final double weight;
	/**
	 * Weighted edge v->w
	 * @param v
	 * @param w
	 * @param weight
	 */
	DirectedEdge(int v, int w, double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	//vertex v
	int from()
	{
		return v;
	}
	//vertex w
	int to()
	{
		return w;
	}
	//weight of this edge
	double weight()
	{
		return weight;
	}
}
