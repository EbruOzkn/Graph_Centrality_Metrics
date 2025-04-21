
public class Edge <T>
{
	private VertexInterface<T> source;
	private VertexInterface<T> destination;
	
	public Edge(VertexInterface<T> source_v, VertexInterface<T> destination_v)
	{
		this.source = source_v;
		this.destination = destination_v;
	}

	public VertexInterface<T> getSource() 
	{
		return source;
	}

	public void setSource(VertexInterface<T> source) 
	{
		this.source = source;
	}

	public VertexInterface<T> getDestination() 
	{
		return destination;
	}

	public void setDestination(VertexInterface<T> destination) 
	{
		this.destination = destination;
	}
}
