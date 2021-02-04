/**
* <h1>Breadth First Search: Put unvisited vertices on a queue.</h1>
* 
* <li> Repeat until queue is empty
* <li> Remove vertex v from queue
* <li> Add to queue, all unmarked vertices adjacent to v and mark them
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   04-02-2021
* 
*/

public class BreadthFirstSearch {

	private boolean [] marked; //marked[v]=true if v is connected to s
	private Integer [] edgeTo; //edgeTo[v]=previous vertex on path from s to v
	private int s;
	
	BreadthFirstSearch(Graph G, int s)
	{
		Queue<Integer> q=new Queue<>();
		marked=new boolean[G.V()];
		edgeTo=new Integer[G.V()];
		this.s=s;
		
		q.enqueue(s);
		marked[s]=true;
		while(!q.isEmpty())
		{
			int v=q.dequeue();
			for(int w: G.adj(v))
			{
				if(!marked[w])
				{
					marked[w]=true;
					edgeTo[w]=v;
					q.enqueue(w);
				}
			}
		}
	}
	
	boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<>();
		for(int i=edgeTo[v];i!=s;i=edgeTo[i])
			path.push(i);
		path.push(s);
		return path;
	}
}
