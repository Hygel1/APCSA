import java.util.Stack;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Route extends Stack<Point>{
    private int cost=0;
    private ArrayList<Point> explored;
    private PriorityQueue<Point> next=new PriorityQueue<>(new arrComp());
    public Route(Route r, Point i){
        explored=new ArrayList<>(r.explored);
        explored.add(i);
        Object[] c=r.toArray();
        for(int q=0;q<c.length;q++){
            add((Point)c[q]);
        }
        add(i);
        cost=r.cost+i.valueAt();
    }
    public Route(Point i){
        explored=new ArrayList<>(); explored.add(i);
        add(i);
        cost=i.valueAt();
    }
    public void setNext(){
        if(explored.contains(new Point(peek().p1()-1, peek().p2()))&&CookieMonsterStarter.isValid(peek().p1()-1, peek().p2())) next.add(new Point(peek().p1()-1,peek().p2()));
        if(explored.contains(new Point(peek().p1()+1, peek().p2()))&&CookieMonsterStarter.isValid(peek().p1()+1, peek().p2())) next.add(new Point(peek().p1()+1, peek().p2()));
        if(explored.contains(new Point(peek().p1(), peek().p2()-1))&&CookieMonsterStarter.isValid(peek().p1(), peek().p2()-1)) next.add(new Point(peek().p1(), peek().p2()-1));
        if(explored.contains(new Point(peek().p1(), peek().p2()+1))&&CookieMonsterStarter.isValid(peek().p1(), peek().p2()+1)) next.add(new Point(peek().p1(), peek().p2()+1));
    }
    public Point getNext(){
        return next.remove();
    }
    public boolean hasNext(){
        return next.size()>0;
    }
    public int getCost(){
        return cost;
    }
    public class arrComp implements Comparator<Point>{
        public int compare(Point o1, Point o2) {
            return o1.valueAt()-o2.valueAt();
        }
    }
}