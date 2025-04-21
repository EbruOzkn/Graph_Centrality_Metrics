import java.util.ArrayList;

public interface VertexInterface <T>
{
   public void addEdge(Edge<T> edge);
   public T getLabel();
   public double getPathLength();
   public void setPathLength(double pathLength);
   public ArrayList<Edge<T>> getEdges();
   public int getBetweenness();
   public void setBetweenness(int betweenness);
   public double getCloseness() ;
   public void setCloseness(double closeness);
}
