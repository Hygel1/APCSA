
public class Point {
    int[] a=new int[2];
    public Point(int p1,int p2){
        a[0]=p1;
        a[1]=p2;
    }
    public int p1(){
        return a[0];
    }
    public int p2(){
        return a[1];
    }
    public int valueAt(){
        return CookieMonsterStarter.getPoint(a[0], a[1]);
    }
    public boolean equals(Point e){
        return e.p1()==p1()&&e.p2()==p2();
    }
}
