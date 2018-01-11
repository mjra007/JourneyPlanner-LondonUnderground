package fastestroutetube.Dijkstra;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author micael
 */
public class DijkstraAlgorithm {

    private final Edge start;
    private final Edge end;
    private final Graph graph;
    private LinkedList<Edge> unexploredStations = new LinkedList<>();
    private LinkedList<Vertex> past = new LinkedList<>();
    Map<Edge, Integer> distances = new HashMap<>();

    public DijkstraAlgorithm(Edge start, Edge end, Graph newgraph) {
        this.start = start;
        this.end = end;
        this.graph = newgraph;
    }

    public Edge run() {
         //Setting the distances to every node to the max
        for (Edge station : graph.getEdges()) {
            distances.put(station, Integer.MAX_VALUE);
            unexploredStations.add(station);
        }
        distances.put(start, 0);
        this.unexploredStations.add(start);

        while (this.unexploredStations.size() > 0) {
            Edge current = getBestEdgeSoFar();
            if (current.equals(end)) {
                return end;
            }
            System.out.println("Current: " + current);
            unexploredStations.remove(current);
            findBestVertex(current);
        }
        return start;
    }
    
    public Edge getBestEdgeSoFar() {
        Edge edge = this.unexploredStations.iterator().next();
        for (Edge station : this.unexploredStations) {
            if (distances.get(station) < distances.get(edge)) {
                edge = station;
            }
        }
        return edge;
    }
//v this hash calculation finds the neighbours of the current node and then, 
//compares the distances between neighbours to find the best neighbour    

    public void findBestVertex(Edge current) {
        LinkedList<Edge> vertexes = getUnexploredVertexes(current);
        System.out.println("Vertexes: " + vertexes);
        vertexes.forEach((edge) -> {
            int dist = graph.getDistanceBetweenEdges(current, edge) + distances.get(current);
            int edgeDist = distances.get(edge);
            if (dist < edgeDist) {
                distances.put(edge, dist);
                past.add(graph.getConnection(current, edge));
                System.out.println("NextStation: " + edge);
            }
        });
    }

        public LinkedList<Edge> getUnexploredVertexes(Edge current) {
        LinkedList<Edge> connections = new LinkedList<>();
        for (Vertex vertex : graph.getVertexes(current)) {
            if (this.unexploredStations.contains(vertex.getDestination())) {
                connections.add(vertex.getDestination());
                System.out.println("Edge> " + vertex.getDestination());
            }
        }
        return connections;
    }

    public LinkedList<Vertex> getResult() {
        LinkedList<Vertex> past2 = new LinkedList<>();
            Edge destination = end;
//while the destination is not equal to the start, get the desination's connections 
            while (!destination.equals(start)) {
                Vertex dest = getConnectionDestination(destination);
                past2.add(dest);
                destination = dest.getSource();
            }
        
        System.out.println(past.toString());
        Collections.reverse(past2);
        return past2;
    }

    public Vertex getConnectionDestination(Edge destination) {
        Vertex connection = null;
        for (Vertex vertex : past) {
            if (vertex.getDestination().equals(destination)) {
                connection = vertex;
            }
        }
        return connection;
    }

}
