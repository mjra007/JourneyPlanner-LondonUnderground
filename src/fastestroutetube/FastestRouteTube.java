package fastestroutetube;

import fastestroutetube.Dijkstra.Edge;
import fastestroutetube.Dijkstra.Graph;
import fastestroutetube.GUI.JFrame;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author micael
 */
public class FastestRouteTube {

    public static Time time;
    public static Graph graph;
    
    public static void main(String[] args) {
        Reader reader = new Reader("./Data/London_Underground_data.xlsx");
        graph = new Graph(reader.getStations());
        time = new Time();
        openGUI();
        System.out.print(""+new Edge("CaNada Water").hashCode());
        
    }
    
    public static JFrame openGUI(){
        //Setting windows look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FastestRouteTube.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FastestRouteTube.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FastestRouteTube.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FastestRouteTube.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame window = new JFrame();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        return window;
    }

    
    //This method is just a sample of data for testing purposes
    public static void setSmallSampleTesting() {
        HashSet<Connection> ties = new HashSet<Connection>();
        HashSet<String> stations = new HashSet<String>();
        stations.add("A");
        stations.add("B");
        stations.add("C");
        stations.add("D");
        stations.add("E");
        stations.add("F");
        stations.add("G");
        ties.add(new Connection(LineName.Unknown, "B", "A", 4));
        ties.add(new Connection(LineName.Unknown, "D", "A", 7));
        ties.add(new Connection(LineName.Unknown, "C", "A", 3));
        ties.add(new Connection(LineName.Unknown, "A", "B", 4));
        ties.add(new Connection(LineName.Unknown, "D", "B", 1));
        ties.add(new Connection(LineName.Unknown, "F", "B", 4));
        ties.add(new Connection(LineName.Unknown, "A", "C", 3));
        ties.add(new Connection(LineName.Unknown, "D", "C", 3));
        ties.add(new Connection(LineName.Unknown, "E", "C", 5));
        ties.add(new Connection(LineName.Unknown, "A", "D", 7));
        ties.add(new Connection(LineName.Unknown, "B", "D", 1));
        ties.add(new Connection(LineName.Unknown, "C", "D", 3));
        ties.add(new Connection(LineName.Unknown, "E", "D", 2));
        ties.add(new Connection(LineName.Unknown, "G", "D", 7));
        ties.add(new Connection(LineName.Unknown, "F", "D", 2));
        ties.add(new Connection(LineName.Unknown, "B", "F", 4));
        ties.add(new Connection(LineName.Unknown, "G", "F", 4));
        ties.add(new Connection(LineName.Unknown, "D", "F", 2));
        ties.add(new Connection(LineName.Unknown, "E", "G", 2));
        ties.add(new Connection(LineName.Unknown, "D", "G", 7));
        ties.add(new Connection(LineName.Unknown, "F", "G", 4));
        ties.add(new Connection(LineName.Unknown, "D", "E", 2));
        ties.add(new Connection(LineName.Unknown, "C", "E", 5));
        ties.add(new Connection(LineName.Unknown, "G", "E", 4));
    }
    
    
}
