public class Point {
    private int x,y,value;
    public Point(int x, int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
    public boolean equals(Point p){
        return p.x()==x&&p.y()==y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public int getValue(){
        return value;
    }
}
