package fastestroutetube.Dijkstra;

import java.util.Objects;


/**
 *
 * @author micae
 */
public class Edge{
    
    private final String name;
    
    public Edge(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    @Override
    public int hashCode(){
    return Objects.hashCode(this.name.toLowerCase());
    }
    
    @Override
    public boolean equals(Object object) {
    if (this == object)
        return true;
    if (object == null)
        return false;
    if (getClass() != object.getClass())
        return false;
    Edge edge = (Edge) object;
    // field comparison
    return edge.toString().equalsIgnoreCase(this.toString());
    }
    
}