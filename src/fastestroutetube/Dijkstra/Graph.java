package fastestroutetube.Dijkstra;

import java.util.Map;

/**
 *
 * @author micael
 */
public class Graph {

    private Map<Edge, Vertex[]> map;

    public Graph(Map<Edge, Vertex[]> map) {
            this.map = map;
    }

    public Vertex[] getVertexes(Edge edge){
        return map.get(edge);
    }
    
    public Edge[] getEdges(){
       Object[] objects = this.map.keySet().toArray();
       Edge[] edges = new Edge[objects.length];
       for(int i=0;i<objects.length;i++){
           Edge edge = (Edge)objects[i];
           edges[i]=edge;
       }
       return edges;
    }
    
    public Map<Edge, Vertex[]> getMap(){
        return this.map;
    }
    // v finds the connection between the current node and its neighbour
    public Vertex getConnection(Edge current, Edge neighbor) {
        Vertex vertex = null;
        for (Vertex t : getVertexes(current)) {
            if (t.getDestination().equals(neighbor)) {
                vertex = t;
            }
        }
        return vertex;
    }

    //v finds distance between current node and neighbour
    public Integer getDistanceBetweenEdges(Edge current, Edge neighbor) {
        Integer time = null;
        for (Vertex vertex : this.getVertexes(current)) {
            if (vertex.getDestination().equals(neighbor)) {
                time = vertex.getWeight();
            }
        }
        return time;
    }

}
