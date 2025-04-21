import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test
{
	public static void main(String[] args) 
	{
		System.out.println("2018510084   Ebru Özkan");
       System.out.println("\nkarate_club_network.txt");
	 Graph <String> graph = new Graph<String>(34);
	
	Scanner sc;
	try
	{
		sc = new Scanner(new File("karate_club_network.txt"));
		while(sc.hasNextLine())
		{
			String s=sc.nextLine().trim();
			if(!s.equals(""))
			{
				graph.addEdge(s.split("\\s+")[0], s.split("\\s+")[1]);
			}
		}
		int[][] adjacency=graph.getAdjacency();

		for (int i = 0; i < graph.size(); i++) 
		{
			for (int j = 0; j < graph.size(); j++) 
			{
				if (i==j) 
				{
					adjacency[i][j]=0;
				}
				if(i!=j&&adjacency[i][j] ==0)
				{
					adjacency[i][j]=500000;
				}
		
		}
	}
		 graph.shortestpath(adjacency);
	 
	    graph.display();    
	    
	    System.out.println("\n\n\nfacebook_social_network.txt");
	    Graph <String> mygraph = new Graph<String>(1518);
	    Scanner scanner;
	    scanner = new Scanner(new File("facebook_social_network.txt"));
		while(scanner.hasNextLine())
		{
			String ss=scanner.nextLine().trim();
			if(!ss.equals(""))
			{
				mygraph.addEdge(ss.split("\\s+")[0], ss.split("\\s+")[1]);
			}
		}
		int[][] myadjacency=mygraph.getAdjacency();

		for (int i = 0; i <mygraph.size(); i++) 
		{
			for (int j = 0; j < mygraph.size(); j++) 
			{
				if (i==j) 
				{
					myadjacency[i][j]=0;
				}
				if(i!=j && myadjacency[i][j] ==0)
				{
					myadjacency[i][j]=500000;
				}
		
		}
	}
		 mygraph.shortestpath(myadjacency);
	 
	     mygraph.display();    
	    
	} 
	
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
   }
}
