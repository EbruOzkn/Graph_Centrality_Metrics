import java.util.ArrayList;

public class Vertex <T>implements VertexInterface<T>
{
	private T label; 
	private ArrayList<Edge<T>> edges;
    private double pathLength;
    private int betweenness;
    private double closeness;

	public double getCloseness() 
	{
		return closeness;
	}

	public void setCloseness(double closeness)
	{
		this.closeness = closeness;
	}

	public int getBetweenness() 
	{
		return betweenness;
	}

	public void setBetweenness(int betweenness) 
	{
		this.betweenness = betweenness;
	}

	public Vertex(T label) 
	{
		this.label = label;
		edges = new ArrayList<Edge<T>>();
		pathLength=0;
		betweenness=0;
	}

	public void addEdge(Edge<T> e) 
	{
		edges.add(e);
	}

	public ArrayList<Edge<T>> getEdges()
	{
		return this.edges;
	}
	
	public T getLabel()
	{
		return label;
	}

	public void setLabel(T label)
	{
		this.label = label;
	}
     public double getPathLength() 
 	{
 		return pathLength;
 	}

 	public void setPathLength(double pathLength)
 	{
 		this.pathLength = pathLength;
 	}
 	public boolean equals(Object other)
    {
        boolean result;
        if ((other == null) || (getClass() != other.getClass()))
            result = false;
        else
        {   // This cast is safe within this else clause
            @SuppressWarnings("unchecked")
            Vertex<T> otherVertex = (Vertex<T>) other;
            result = label.equals(otherVertex.label);
        } 
        return result;
    } 
}
