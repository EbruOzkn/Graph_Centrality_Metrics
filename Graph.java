import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Graph <T>
{
	private ArrayList<VertexInterface <T>> vertices;
	private HashMap<String, Edge <T>> edges;
	private int[][] adjacency;
	private int s;

	public Graph(int s) 
	{
		vertices = new ArrayList<VertexInterface <T>>();
		this.edges = new HashMap<>();
		adjacency = new int[s][s];
		this.s = s;
	}

	public void addEdge(T source, T destination)
	{

		if (edges.get(source + "-" + destination) == null && edges.get(destination + "-" + source) == null)
		{
			VertexInterface<T> source_v, destination_v;
			source_v = new Vertex <T>(source);
			destination_v = new Vertex <T>(destination);
			int source_index = vertices.indexOf(source_v);
			int destination_index = vertices.indexOf(destination_v);

			if (source_index==-1) 
			{
				vertices.add(source_v);
			} 

			if( destination_index==-1) 
			{
				vertices.add(destination_v);
			} 

			 source_index = vertices.indexOf(source_v);
			 destination_index = vertices.indexOf(destination_v);
			
			adjacency[source_index][destination_index] = 1;
			adjacency[destination_index][source_index] = 1;
			
			source_v=vertices.get(source_index);
			destination_v=vertices.get(destination_index);
			
			Edge <T>edge = new Edge<T>(source_v, destination_v); 
			source_v.addEdge(edge);
			destination_v.addEdge(edge);
			edges.put(source + "-" + destination, edge);
			
		
		} 
		else
		{
			System.out.println("This edge has already added!");
		}
	}


	public ArrayList<VertexInterface<T>> getVertices() 
	{
		return vertices;
	}
	public Iterable<Edge<T>> edges()
	{
		return edges.values();
	}
	public int s() 
	{
		return this.s;
	}

	public int size() 
	{
		return vertices.size();
	}
	public int[][] getAdjacency() 
	{
		return adjacency;
	}
	
	 public void shortestpath( int[][] adjacency)
	    {
	        // base case
	        if (adjacency ==null || adjacency.length == 0) 
	        {
	            return;
	        }
	 
	        // total number of vertices in the adjacency matrix
	        int n =adjacency.length;
	 
	        // cost[] and path[] stores shortest path
	        // shortest route information
	        int[][] length = new int[n][n];
	        int[][] path = new int[n][n];
	 
	        // initialize cost[] and path[]
	        for (int v = 0; v < n; v++)
	        {
	            for (int u = 0; u < n; u++)
	            {
	                length[v][u] = adjacency[v][u];
	 
	                if (v == u) 
	                {
	                    path[v][u] =0;
	                }
	                else if (length[v][u] != Integer.MAX_VALUE) 
	                {
	                    path[v][u] = v;
	                }
	                else
	                {
	                    path[v][u] = -1;
	                }
	            }
	        }
	 
	        for (int k = 0; k < n; k++)
	        {
	            for (int v = 0; v < n; v++)
	            {
	                for (int u = 0; u < n; u++)
	                {
	                    // If vertex `k` is on the shortest path from `v` to `u`,
	                    // then update the value of cost[v][u] and path[v][u]
	 
	                    if (length[v][k] != Integer.MAX_VALUE   && length[k][u] != Integer.MAX_VALUE && (length[v][k] + length[k][u] < length[v][u]))
	                    {
	                        length[v][u] = length[v][k] + length[k][u];
	                        path[v][u] = path[k][u];
	                    }
	                }
	 
	                // if diagonal elements become negative, the
	                // graph contains a negative-weight cycle
	                if (length[v][v] < 0)
	                {
	                    System.out.println("Negative-weight cycle found!!");
	                    return;
	                }
	            }
	        }
	 
	        // Print the shortest path between all pairs of vertices
	        printSolution(path, n,length);
	    }
	  private  void printPath(int[][] path, int v, int u, List<Integer> route,int[][] length)
	    {
	        if (path[v][u] == v)
	        {
	            return;
	        }
	        printPath(path, v, path[v][u], route,length);
	        VertexInterface<T> vertex=vertices.get( path[v][u]);
	        vertex.setBetweenness(vertex.getBetweenness()+1);
	        route.add(Integer.valueOf((String)vertex.getLabel()));
	    }
	 
	    // Function to print the shortest path with path information between
	    // all pairs of vertices
	    private  void printSolution(int[][] path, int n,int[][] length)
	    {
	        for (int v = 0; v < n; v++)
	        {
	            for (int u = v; u < n; u++)         
	            {
	                if (u != v && path[v][u] != -1)
	                {
	                    List<Integer> route = new ArrayList<>();
	                    VertexInterface<T> Vertex=vertices.get(v);     
	                    int vertex=Integer.valueOf((String)Vertex.getLabel());
	                    if(length[v][u]<500000)
		                  {
	                         route.add( vertex);
		                  }
	                    Vertex.setPathLength(Vertex.getPathLength()+length[v][u]);
	                    if(length[v][u]<500000)
		                  {
	                        printPath(path, v,u, route ,length);
		                  }
	                    VertexInterface<T> Vert=vertices.get(u);         
	                    int vert=Integer.valueOf((String)Vert.getLabel());
	                    if(length[v][u]<500000)
		                  {
	                        route.add( vert);
		                  }
	                    Vert.setPathLength(Vert.getPathLength()+length[v][u]);
	            
	                    Vertex.setCloseness((double)1/(Vertex.getPathLength()));
	                    Vert.setCloseness((double)1/(Vert.getPathLength()));
	                    
	                  if(length[v][u]<500000)
	                  {
	                	  Vertex.setBetweenness(Vertex.getBetweenness()+1);
		                   Vert.setBetweenness(Vert.getBetweenness()+1);
	                  }
	                }
	            }
	        }
	    }
	    
	    public void display()
	    {
	    	Iterator <VertexInterface<T>> vertexIterator= vertices.iterator();
			 VertexInterface<T> v=vertexIterator.next();
	    	int num=v.getBetweenness();
			 double num_c=v.getCloseness();
			 String label=(String) v.getLabel();
			 String label_c=(String) v.getLabel();
		       while (vertexIterator.hasNext())
		       {
		           VertexInterface<T> nextVertex = vertexIterator.next();
		           if(nextVertex.getBetweenness()>num)
					{
		        	   num=nextVertex.getBetweenness();
		        	   label=(String) nextVertex.getLabel();
					}
		           if(nextVertex.getCloseness()>num_c)
		           {
		        	   num_c=nextVertex.getCloseness();
		        	   label_c=(String) nextVertex.getLabel();
		           }
		       }
				System.out.println("\nThe Highest Node for Betweennes:   "+label+"  value:   "+num);
				System.out.println("\nThe Highest Node for Closeness:     "+label_c+"  value:   "+num_c );
	    }
}
