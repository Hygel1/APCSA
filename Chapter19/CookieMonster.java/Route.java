import java.util.Stack;

import java.util.Queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Route extends Stack<Point>{
    private int cost=0;
    private ArrayList<Point> explored;
    private Queue<Point> next=new LinkedList<>();
    /**
     * compound route, takes a previously existing route and a point, copying the route and appending the point
     * @param r
     * @param i
     */
    public Route(Route r, Point i){
        explored=new ArrayList<>(r.explored);
        explored.add(i);
        Object[] c=r.toArray();
        for(int q=0;q<c.length;q++){
            add((Point)c[q]);
        }
        add(i);
        cost=r.cost+i.valueAt();
        setNext();
    }
    /**
     * starter constructor, takes one point and makes a single-stop route
     * @param i
     */
    public Route(Point i){
        explored=new ArrayList<>(); explored.add(i);
        add(i);
        cost=i.valueAt();
        setNext();
    }
    /**
     * sets up the next queue
     */
    public void setNext(){
        if(CookieMonsterStarter.isValid(peek().p1()-1, peek().p2())&&notVisited(new Point(peek().p1()-1, peek().p2()))) next.add(new Point(peek().p1()-1,peek().p2()));
        if(CookieMonsterStarter.isValid(peek().p1()+1, peek().p2())&&notVisited(new Point(peek().p1()+1, peek().p2()))) next.add(new Point(peek().p1()+1, peek().p2()));
        if(CookieMonsterStarter.isValid(peek().p1(), peek().p2()-1)&&notVisited(new Point(peek().p1(), peek().p2()-1))) next.add(new Point(peek().p1(), peek().p2()-1));
        if(CookieMonsterStarter.isValid(peek().p1(), peek().p2()+1)&&notVisited(new Point(peek().p1(), peek().p2()+1))) next.add(new Point(peek().p1(), peek().p2()+1));
    }
    /**
     * pulls the next item from the next queue, returns null if queue is empty
     * @return
     */
    public Point getNext(){
        if(!hasNext()) return null;
        return next.remove();
    }
    /**
     * returns true if the next queue is empty
     * @return
     */
    public boolean hasNext(){
        return next.size()>0;
    }
    /**
     * returns true if the passed point's coordinates are not found in explored
     * @param p
     * @return
     */
    public boolean notVisited(Point p){
        for(Point e:explored) if(p.p1()==e.p1()&&p.p2()==e.p2()) return false;
        return true;
    }
    /**
     * returns the number of cookies collected in the route
     * @return
     */
    public int getCost(){
        return cost;
    }
    /**
     * returns true if the city has been visited by the route
     * @param p
     * @return
     */
    public boolean hasBeen(Point p){
        return explored.contains(p);
    }
    public class arrComp implements Comparator<Point>{
        public int compare(Point o1, Point o2) {
            return o1.valueAt()-o2.valueAt();
        }
    }
}