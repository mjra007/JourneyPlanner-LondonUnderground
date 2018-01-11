package fastestroutetube.Dijkstra;


/**
 *
 * @author micae
 */
public class Vertex {
    private final Edge destination;
    private final Edge source;
    private int weight;

    public Vertex(Edge destination,Edge source, int weight) {
        this.destination = destination;
        this.source=source;
        this.weight = weight;
    }
    public Edge getSource(){
        return this.source;
    }
    public Edge getDestination(){
       return this.destination;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return "\n " +",Source: "+getSource() +" ,Destination: "
                +getDestination()+" ,Time: "+getWeight();
    }
}
