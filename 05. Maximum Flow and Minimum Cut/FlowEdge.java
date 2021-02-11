/**
* <h1>Flow-Edge: Associate flow fₑ and capacity cₑ wit edge e=v->w</h1>
* 
* <li> Residual capacity: 
* <li> Forward edge = residual capacity = cₑ-fₑ
* <li> Backward edge = residual capacity = fₑ
* <li> Augment Flow:
* <li> Forward edge: Add Δ
* <li> Backward edge: Subtract Δ
* 
* @author  Mohit Sharma
* @version 1.0
* @since   11-02-2021
* 
*/

public class FlowEdge {
	private final int v, w;
	private final double capacity;
	private double flow;
	
	/**
	 * Create a flow edge
	 * <li> A flow edge should be able to process in both directions
	 * @param v
	 * @param w
	 * @param capacity
	 */
	FlowEdge(int v, int w, double capacity)
	{
		this.v=v;
		this.w=w;
		this.capacity=capacity;
	}
	
	//vertex this edge points from
	int from()
	{
		return v;
	}
	
	//vertex this edge points to
	int to()
	{
		return w;
	}
	
	//other endpoint
	int other(int v)
	{
		
	}
	
	//capacity of this edge
	double capacity()
	{
		return capacity;
	}
	
	//flow of this edge
	double flow()
	{
		return flow;
	}
	
	//residual capacity towards v
	double residualCapacityTo(int v)
	{
		
	}
	
	//add delta flow towards v
	void addResidualFlowTo(int v, double delta)
	{
		
	}


}
