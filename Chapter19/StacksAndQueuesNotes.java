package Chapter19;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class StacksAndQueuesNotes{
    /**
     * Stacks and queues are both used for organizing storage
     *  Stacks are keeping track of the top of the stack
     * queues are keeping track of the front and back
     * 
     * Stacks:
     *  assume the bottom (first added) if 0, and every added element adds to size, every removed element decreases size
     *  SP (stack pointer) is equal to the number of elements in the stack but really just points to the next available index in the stack
     *  when used efficiently, each of the methods runs O(1) times, only one method call, no recalling
     *  Stacks hold references to objects, which can be placed on the stack multiple times (if one object is referenced 5 times, all 5 will be affected with each change to each reference)
     *  First in, first out data handling
     *  Methods:
     *      push(T) - puts item on the top of the stack
     *      pop() - returns the item on the top of the stack and removes that item from the stack
     *      peek() - returns the item on the top of the stack but doesn't remove it from the stack
     *      isEmpty() - returns true if the stack is empty
     *  Helpful for saving items for future processing, when there is more information
     * Queues:
     *  processes events and items in the order of their arrival
     *      Helps with keeping a buffer when too many things are happening at once
     *  Two variables, front and rear
     *      if there will never be more than x items in the queue, you can make an array of size x
     *      instead of shifting, when rear reaches the end, the rear index can loop around to the front, where there is more space
     *          as you add to the front, rear advances (then resets to 0 when at the end of the array)
     *          as you remove items from the queue, front advances down the array (freeing space in the front)
     *              when front and rear collide, then it's worth it to make another, larger array
     *              this kind of looping around the array is called a ring buffer
     *  Methods:
     *      add(T) - adds an item to the back of the queue and advances rear
     *      remove() - returns the item at teh front of the array, removes the item and advances start
     *      peek() - returns the item at the front of the array but does not advance start or remove the item
     *  Items can be referenced multiple times - because the queue is only storing a reference, there is nothing stopping you from changing an Objetc that it in the middle of a queue
     */
    /**
     * assumes presorted queue parameters, merges two queues alphabetically
     * @param q1
     * @param q2
     * @return
     */
    public Queue wutIzMehName(Queue<String> q1, Queue<String> q2){
        Queue<String> q = new LinkedList<String>();
        while (!q1.isEmpty() && !q2.isEmpty()) //whlie both queues still have items to be processed...
        {
            //add the lexicographically smaller String at the front of both queues to the returned queue and remove that item from the original queue
            if ((q1.peek()).compareTo(q2.peek()) < 0) q.add(q1.remove());
            else q.add(q2.remove());
        }
        //once one queue is exhausted, add the rest of the non-exhausted queue to the returned queue in order
        while (!q1.isEmpty()) q.add(q1.remove());
        while (!q2.isEmpty()) q.add(q2.remove());
        return q;
    }
    /**
     * outputs:
     * 3 1
     * 2 2
     * 1 3
     */
    public void prob2(){
            Stack<Integer> s=new Stack<Integer>();
            Queue<Integer> q=new LinkedList<Integer>();
                for(int i=1;i<=3;i++){
                    s.push(i);
                    q.add(i);
                }
                while(!s.isEmpty()&&!q.isEmpty()) System.out.println(s.pop()+" "+q.remove());
        }
        /**
         * 
         * @param stk
         */
        public void prob3(Stack<String> stk){
            Stack<String> stk2=new Stack<String>();
            Stack<String> temp = new Stack<String>();
            while(!stk.isEmpty()){
                String s=stk.pop();
                temp.push(s);
                stk2.push(s);
            }
            while(!temp.isEmpty()) stk.push(temp.pop());
        }
        
}