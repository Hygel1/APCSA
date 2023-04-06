public class Point {
    
    int[] a=new int[2];

    /**
     * coordinate defining constructor
     * @param p1
     * @param p2
     */
    public Point(int p1,int p2){
        a[0]=p1;
        a[1]=p2;
    }
    /**
     * returns position value 1
     * @return
     */
    public int p1(){
        return a[0];
    }
    /**
     * returns position value 2
     * @return
     */
    public int p2(){
        return a[1];
    }
    /**
     * returns the cookies value at this point
     * @return
     */
    public int valueAt(){
        return CookieMonsterStarter.getPoint(a[0], a[1]);
    }
    /**
     * compares one point to another using coordinates
     * @param e
     * @return
     */
    public boolean equals(Point e){
        return e.p1()==p1()&&e.p2()==p2();
    }
}
