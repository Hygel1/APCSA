import java.util.Stack;
public class Route extends Stack<int[]>{
    private int cost=0;
    public Route(Route r, int[] i){
        cost=r.cost;
        new Stack(this);
    }
    public int getCost(){
        return cost;
    }
}