import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Route extends Stack<Point>{
    private PriorityQueue<Point> neighbors;
    private ArrayList<Point> visited=new ArrayList<>();
    private int cost=0;
    public Route(Point p){
        add(p);
        cost+=p.getValue();
    }
    public Route(Route r,Point p){
        Object[] mve=r.toArray();
        for(Object o:mve){
            add((Point)o);
            cost+=((Point)o).getValue();
        }
        add(p);
        cost+=p.getValue();
    }
    public void setNeighbors(ArrayList<Point> p){
        neighbors=new PriorityQueue<Point>(new pntComp());
        for(Point q:p){
            neighbors.add(q);
        }
        System.out.println(":)");
    }
    public Point nextStep(){
        if(neighbors==null){
            System.out.println(":(");
        }
        if(neighbors.size()<1) return null;
        return neighbors.remove();
    }
    public boolean beenTo(Point p){
        return visited.contains(p);
    }
    public int costOf(){
        return cost;
    }
    public String toString(){
        return cost+": "+this.toString();
    }
    public static class pntComp implements Comparator<Point>{
        public int compare(Point o1, Point o2) {
            return o1.getValue()-o2.getValue();
        }

    }
}
