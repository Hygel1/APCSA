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
  
  public static int getPoint(int x, int y){
    return cookies[x][y];
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

  /**
   *  Returns true if (row, col) is within the array and that position is
   *  not a barrel (-1); false otherwise.  Notice short-circuit evaluation
   *  to protect out-of-bounds errors from occuring.
   */
  public static boolean isValid(int row, int col)  
  {  
    return row >= 0 && row<SIZE && col>= 0 && col<SIZE && cookies[row][col]>=0;  
  }
  public boolean aLHas(ArrayList<Point> r, Point q){
    for(int a=0;a<r.size();a++) if(r.get(a).equals(q)) return true;
    return false;
  }
  /**
   *  Returns the largest number of cookies collected by Monster
   *  on a path from (0,0) to (SIZE-1, SIZE-1)
   */
  private static void optimize(Queue<Route> r, Route rte){
    Object[] com=r.toArray();
    for(int i=0;i<com.length;i++){
      if(((Route)com[i]).getCost()<rte.getCost()&&((Route)com[i]).peek().equals(rte.peek())) r.remove((Route)com[i]);
    }
    r.add(rte);
  }
  /**
   * find most effective path through 2d array of cookies
   * @return
   */
  public Route optPath(){
    ArrayList<Point> points=new ArrayList<>();
     //reformats the 2D array into an arrayList
    for(int i=0;i<cookies.length;i++){
      for(int n=0;n<cookies[i].length;n++){
        points.add(new Point(i,n));
      }
    } //should work above this
    PriorityQueue<Route> frontier=new PriorityQueue<>(); //created paths to be explored
    PriorityQueue<Route> possible=new PriorityQueue<>(); //possible solutions (routes that reach the ensd)
    ArrayList<Point> explored=new ArrayList<>(); //cities that have been previously explored by any route
    frontier.add(new Route(points.get(0))); //add start position as route to frontier
    explored.add(points.get(0)); //add start position to list of explored points
    while(frontier.size()>0){ //while there are paths to be explored
      if(frontier.size()==1000){ //testing
        boolean t=true;
      }
      if(explored.size()==1000){ //testing
        boolean t=true;
      }
      Point node=frontier.peek().getNext(); //hold next step (point)
      while(node==null){ //if the next step does not exist, repalce with nearest next step
        frontier.remove();
        if(frontier.size()==0) break;
        node=frontier.peek().getNext();
      }
      if(frontier.peek().notVisited(node)){ //if node hasn't been visited by the route already...
        Route curr=new Route(frontier.peek(),node); //next possbile route being evaluated
        if(node.p1()==SIZE-1&&node.p2()==SIZE-1){ //if node=end, add to possible solutions
          possible.add(curr);
        }
        if(!explHas(explored, node)){ //if node has not been explored in a previous route, add to queue
          explored.add(node);
          frontier.add(curr);
        }
        else optimize(frontier, curr); //if node has been previously explored, remove all less efficient cases and add to route
      }
      if(!frontier.peek().hasNext()) frontier.remove(); //if the end of the head of the queue has no more paths to explore, remove from queue
    }
    return possible.peek(); //return most effective route
  }
  /**
   * returns true if any item in the arraylist has the same points as Point p, meant to be used with explored
   * @param l
   * @param p
   * @return
   */
  private boolean explHas(ArrayList<Point> l,Point p){
    for(Point q:l) if(p.p1()==q.p1()&&p.p2()==q.p2()) return true;
    return false;
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
    String fileName;

    if (args.length >= 1)
    {
      fileName = args[0];
    }
    else
    {
      Scanner kboard = new Scanner(System.in);
      System.out.print("Enter the cookies file name: ");
      fileName = kboard.nextLine();
      kboard.close();
     }

    File file = new File(fileName);
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Cannot open " + fileName);
      System.exit(1);
    }

    CookieMonsterStarter monster = new CookieMonsterStarter();
    monster.loadCookies(input);
    System.out.println("Optimal path has " +monster.optPath() + " cookies.\n");
  }
  public class routeComp implements Comparator<Route>{
    public int compare(Route o1, Route o2) {
      return o2.getCost()-o1.getCost();
    }
  }
  public class rtComp implements Comparator<Route>{
    public int compare(Route o1, Route o2) {
      return o2.getCost()-o1.getCost();
    }
    
  }
}