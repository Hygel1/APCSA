import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 4/5/23
 * Assignment: Ch20 Cookie Monster
 * 
 * General Description: Finds the path with the most cookies from the top left to the bottom right of a 2D array
 * 
 * Advanced: 
 * 
 * Errata: There's an infinite loop at some point in the optPath method, which prevents it from removing routes and continuously adds to explored
 *          I'll resubmit for late credit when I find where this is and fix it
 */
/**
 *  In this program Cookie Monster finds the optimal path from 
 *  the upper left corner (0,0) to the lower right corner
 *  (SIZE-1,SIZE-1) in a cookie array.  The elements of
 *  the array contain cookies (a non-negative number) or barrels
 *  (-1).  On each step Cookie Monster can only go down or
 *  to the right.  He is not allowed to step on barrels. 
 *  The optimal path contains the largest number of cookies.
 *   
 *  The program prompts the user for a file name,
 *  reads the cookie array from the file, and reports the
 *  number of cookies on the optimal path. Assumed size of the
 *  grid of values i 12 x 12, stored in row-major order.
 *  
 *  Bonus:  Adapt the program to read 2 ints from the file first
 *  representing numRows and numCols, and then read all values into
 *  a 2-d array.  (Consult FloodFill project for an example.)
 *  
 *  Bonus#2: Write a recursive solution that finds the optimal cookie
 *  total for the problem.   (For mega bonus, write a recursive solution
 *  that reports the Optimal Path formed with that total.)
 *  
 *  The program also reports the actual optimal path, location
 *  by location in effective formatting.
 *  
 *  Finally, the program will output every successful path found,
 *  along with the total cookies along that path.
 */

public class CookieMonsterStarter
{
  private static final int SIZE = 12; //Can be altered for different files. 
  private static int[][] cookies = new int[SIZE][SIZE];
  private static ArrayList<ArrayList<Point>> ckies=new ArrayList<>();
  
  public static int getPointArr(int x, int y){
    return cookies[x][y];
  }
  public static int getPoint(int x, int y){
    return ckies.get(y).get(x).getValue();
  }
  /**
   *  Reads cookies from file
   */
  private void loadCookies(Scanner input)
  {
    for (int row = 0;   row < SIZE;   row++)  
      for (int col = 0;   col < SIZE;   col++)  
        cookies[row][col] = input.nextInt();  
  }  
  private static int[] findVals(String str){
    int[] rtn=new int[SIZE];
    for(int i=0,n=0;n<12&&i>-1;i=str.indexOf(" ",i+1)){
      int q=str.indexOf(" ",i+1);
      if(q==-1){
        System.out.println("pwobwem :(");
        String s=str.substring(i);
        rtn[n]=Integer.valueOf(str.substring(i+1));
        break;
      }
      String s=str.substring(i+1,q);
      if(s.length()>0){ 
        rtn[n]=Integer.valueOf(s);
        n++;
      }
    }
    return rtn;
  }
  private static ArrayList<ArrayList<Point>> parseCookies(String path){
    ArrayList<ArrayList<Point>> rtn=new ArrayList<>();
    try{
      File f=new File(path);
      Scanner s=new Scanner(f);
      for(int i=0;s.hasNextLine();i++){
        rtn.add(new ArrayList<Point>());
        int[] hold=findVals(s.nextLine());
        for(int n=0;n<hold.length;n++){
          rtn.get(i).add(new Point(n,i,hold[n]));
        }
      }
      s.close();
    }catch(Exception e){ e.printStackTrace();}
    return rtn;
  }
  public static void setNeighbors(ArrayList<ArrayList<Point>> lst,Route rte){
    Point node=rte.peek(); //tail of route
    ArrayList<Point> nbr=new ArrayList<Point>(4); //list of possible neighbors, only 4 possible
    //If the neighbor is valid, add to the list
    if(isValidAL(lst,node.y()-1, node.x())) nbr.add(lst.get(node.y()-1).get(node.x()));
    if(isValidAL(lst,node.y()+1, node.x())) nbr.add(lst.get(node.y()+1).get(node.x()));
    if(isValidAL(lst,node.y(), node.x()-1)) nbr.add(lst.get(node.y()).get(node.x()-1));
    if(isValidAL(lst,node.y(), node.x()+1)) nbr.add(lst.get(node.y()).get(node.x()+1));
    rte.setNeighbors(nbr);
  }
  private static boolean isValidAL(ArrayList<ArrayList<Point>> lst, int y, int x){
    return y>-1&&x>-1&&y<lst.size()&&x<lst.get(0).size()&&lst.get(y).get(x).getValue()>-1;
  }
  /**
   *  Returns true if (row, col) is within the array and that position is
   *  not a barrel (-1); false otherwise.  Notice short-circuit evaluation
   *  to protect out-of-bounds errors from occuring.
   */
  public static boolean isValid(int row, int col)  
  {  
    return row >= 0 && row<SIZE && col>= 0 && col<SIZE && cookies[row][col]>=0;
  }

  public static Route optRoute(ArrayList<ArrayList<Point>> points){
    RouteOrg rComp=new RouteOrg(); //comparator to be used for sorting in PriorityQueue
    PriorityQueue<Route> possible=new PriorityQueue<>(rComp); //list of possible solutions
    PriorityQueue<Route> frontier=new PriorityQueue<>(rComp); //list of routes to be examined
    ArrayList<Point> visited=new ArrayList<>(); //list of points that have been visited
    frontier.add(new Route(points.get(0).get(0)));
    visited.add(points.get(0).get(0));
    while(frontier.size()>0){ //while there are routes to be examined
      Route curr=frontier.peek(); //curr=current route to be examined
      setNeighbors(points, curr); //set the possible next steps for curr
      Point node=curr.nextStep(); //init node for first iteration of loop
      if(node==null){
        System.out.println("hello");
      }
      while(node!=null){ //nextStep() will return null if the route has been exhausted, stopping this loop
        if(node.y()==points.size()&&node.x()==points.get(0).size()) possible.add(new Route(curr,node)); //if node is the end, add to possible routes
        else if(visited.contains(node)) optimizeFront(new Route(curr,node),frontier); //if node has been visited, decide on more optimal route to this location
        else{ //if node has never been seen...
          visited.add(node); //log visit
          frontier.add(new Route(curr,node)); //add to route queue
        }
        node=curr.nextStep(); //reset node for next iteration
      }
      frontier.remove();//remove after route has been exhausted of steps
    }
    if(possible.size()==0) return null; //if there is no possible solution, return null
    return possible.peek(); //return the most optimal route in list of possble routes
  }
  public static void optimizeFront(Route rte, PriorityQueue<Route> frontier){
    Object[] c=frontier.toArray();
    for(Object o:c)
      if(((Route)o).peek().equals(rte.peek())){ //if a match has been found
        if(((Route)o).costOf()<rte.costOf()){ //if the route being evaluated is better, replace the found route with the examined
        frontier.remove((Route)o);
        frontier.add(rte);
        }
        return; //there can only be one match, so if one has been found, return no matter what
      }
      frontier.add(rte); //if there was no matching tail, add rte to frontier anyway
  }
  /**  The following is something we coded together in Ch20 work:
  *		E  is an Element Type
  * 	It is a Static method:  to activate it...
  *      in another class:  someotherQ= CoookieMonster.copy(someq);
  *      in this class:   		 newQ = copy(q);
  *      */
  public static<E>  Queue<E> copy(Queue<E> q){
	  Queue<E> q2 = new LinkedList<E>();
	  if (!q.isEmpty()){
       E obj = q.remove();
		   E first = obj;
		   q2.add(obj);
		   q.add(obj);
		   while (q.peek() != first) {
			   obj = q.remove();
			   q.add(obj);
			   q2.add(obj);
		   }  
	  }
	  return q2;
  }
  
  /**BONUS #2
   * Recursive solution for obtaining optimal number of cookies. Additional 
   * parameters might need to be included to track paths, or it may be fruitful
   * to create some private fields that are used within this method as required.
   * For example, we could maintain fields for bestCookieCount and bestPathFound.
   * @param row  - the destination row	  (Start is always (0,0).)
   * @param col  - the destination column
   * @return number of cookies on optimal path to (row,col) from (0,0).
   */
  private int recOptimalPath(int row, int col)
	{
		int count = 0;

		//Code here.	
		
		return count;
	}
  

  public static void main(String args[])
  {  // Adapt this as you see fit.
    String fileName="";
    try{
      Scanner s=new Scanner(System.in);
      System.out.print("Filename: ");
      fileName=s.nextLine();
      s.close();
    }catch(Exception e){e.printStackTrace();}
    ArrayList<ArrayList<Point>> aL=parseCookies(fileName);
    ckies=aL;
    Route opt=optRoute(aL);
    System.out.println(opt);

  }
  public static class RouteOrg implements Comparator<Route>{ //comparator for routes to be used by PriorityQueue
    public int compare(Route o1, Route o2) {
      return o2.costOf()-o1.costOf();
    }
  }
}