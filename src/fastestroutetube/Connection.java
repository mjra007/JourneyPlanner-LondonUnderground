package fastestroutetube;

import fastestroutetube.Dijkstra.Edge;
import fastestroutetube.Dijkstra.Vertex;

/**
 *
 * @author micael
 */
public class Connection extends Vertex{


    private LineName lineName = LineName.Unknown;

    public Connection(LineName name, String destination,String source, int time) {
        super(new Edge(destination),new Edge(source),time);
        this.lineName = name;
    }
    
    public LineName getLine(){
        return this.lineName;
    }
    
    @Override
    public int getWeight(){
        Time getTime = FastestRouteTube.time;
        if(this.lineName.equals(lineName.Bakerloo)
           && (getTime.getTimeSelected().after(getTime.createTime("09:00")) 
           & getTime.getTimeSelected().before(getTime.createTime("16:00")))){
        return super.getWeight()/2;
        }
        
        return super.getWeight();
    }
    public void setLine(LineName line){
        this.lineName = line;
    }
    @Override
    public String toString(){
        return "\n Line: "+ getLine().toString()+" ,Source: "+getSource() +" ,Destination: "+getDestination()+" ,Time: "+getWeight();
    }
}
