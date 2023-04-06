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
  
  public static boolean isValid(int x, int y){
    return x>=0&&y>=0&&x<SIZE&&y<SIZE&&cookies[x][y]>-1;
  }
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
  private boolean goodPoint(int row, int col)  
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
  private static void optimize(PriorityQueue<Route> r, Route rte){
    Object[] com=r.toArray();
    for(int i=0;i<com.length;i++){
      if(((Route)com[i]).getCost()>rte.getCost()&&((Route)com[i]).peek().p1()==rte.peek().p1()&&((Route)com[i]).peek().p2()==rte.peek().p2()) r.remove(com[i]);
    }
    r.add(rte);
  }
  public static Route optimaPath(ArrayList<Point> points, Point start, Point end){
    ArrayList<Point> explored=new ArrayList<>();
    PriorityQueue<Route> frontier=new PriorityQueue<>();
    frontier.add(new Route(start));
    explored.add(start);
    PriorityQueue<Route> possible=new PriorityQueue<>();
    while(frontier.size()>0){
      while(!frontier.peek().hasNext()){
        frontier.remove();
        if(frontier.isEmpty()) break;
      }
      if(frontier.isEmpty())break;
      Point node=frontier.peek().getNext();
      if(node.equals(end)) possible.add(frontier.remove());
      else
        optimize(frontier, new Route(frontier.peek(),node));
    }
    return possible.remove();
  }

  
  public Route optPath(){
    ArrayList<Point> points=new ArrayList<>();
    for(int i=0;i<cookies.length;i++){
      for(int n=0;n<cookies[i].length;n++){
        points.add(new Point(i,n));
      }
    }
    PriorityQueue<Route> frontier=new PriorityQueue<>();
    PriorityQueue<Route> possible=new PriorityQueue<>();
    frontier.add(new Route(points.get(0)));
    while(frontier.size()>0){
      while(!frontier.peek().hasNext()){
        frontier.remove();
        if(frontier.size()==0) break;
      }
      if(frontier.size()==0) break;
       Route curr=new Route(frontier.peek(),frontier.remove().getNext()); //next possbile route being evaluated
       if(curr.peek().p1()==SIZE-1&&curr.peek().p2()==SIZE-1){
        possible.add(curr);
      }
      else
        optimize(frontier, curr);
      if(!frontier.peek().hasNext()) frontier.remove();
    }
    return possible.peek();
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
}