/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  
 * Assignment: Engineered ArrayList
 * 
 * General Description: Creates an array that can expand itself and insert/remove elements
 * 
 * Advanced: can take any object as opposed to just Strings
 */
package InClassAssignments.ArrayLists;

//import javax.print.attribute.standard.NumberOfInterveningJobs;
//import java.lang.reflect.Array;

public class MyArrayList<T> {
    private int numItems=0;
    private T[] list;
    public MyArrayList(){ //constructor that creates a new version of MyArrayList with a default (10) size
        
        //list=(T[]) Array.newInstance((Class)t.newInstance().getClass(),10);
        list=(T[]) new Object[10];
    }
    public MyArrayList(int initCap){ //overloaded constructor that creates a new version of MyArrayList with a given (initCap) size
        //list=(T[]) Array.newInstance(t.getClass(),initCap); //all created elements are null and capacity it equal to initCap
        list=(T[]) new Object[initCap];
        /**
         * casts the array from Object[] to T[], this is the only way that I could find to do this without refection
         * the commented version used .getClass() to return the type of t, which is of type T, which would give me the type
         *  this would have worked if I was able to make an object of T as t but since I can't guarantee that t will be of type T without leaving it null.
         *  Since the null t doesn't really exist, this left me without anything to reference and gave me a NullPointerException
         */
    }
    public boolean isEmpty(){
        return numItems==0;
    }
    public int size(){ //preety much just a getter, could also be called getSize()
        return numItems; //size will always be one above the index of the last element
    }
    public boolean isFull(){
        return numItems==list.length;
    }
    /**
     * checks if the array will be oversized and doubles its size if so
     */
    public void doubleCheck(){
        if(isFull()){ //if the reserved memory is full, we must add to the capacity
            //T[] doubled=(T[]) Array.newInstance(t.getClass(), list.length*2); //we could grow by only one, but that makes us grow more often (memory is sacrificed in the interest of processing power)
            T[] doubled=(T[]) new Object[list.length*2];
            //transfer all values in list to new doubled array
            for(int i=0;i<list.length;i++){
                doubled[i]=list[i];
            }
            list=doubled; //replace list array with doubled (longer array)
        }
    }
    //appends an object to the end of the list
    public boolean add(T obj){
        doubleCheck();
        list[numItems]=obj; //the number of items is always one more than the index of the last element, therefore we can just use numItems to get the index to add to
        numItems++;
        return true;
    }
    //replaces a value in the list with val, returning the previous value for preservation
    public T set(T val, int ind){
        if(ind<0||ind>=numItems) throw new IndexOutOfBoundsException();
        T rtn=list[ind];
        list[ind]=val;
        return rtn;
    }
    //returns the element of the list at a given index
    public T get(int ind){
        if(ind<0||ind>=numItems) throw new IndexOutOfBoundsException();
        return list[ind];
    }
    //formats the list into a String
    public String toString(){
        String rtn="";
        for(int i=0;i<numItems;i++){
            rtn+=list[i]+", ";
        }
        //eliminate final
        if(rtn.length()>2) rtn=rtn.substring(0,rtn.length()-2);
        return "["+rtn+"]";
    }
    //removes the element at a specified index and reformats the array
    public T remove(int num){
        T rtn=list[num];
        for(int i=num;i<numItems-1;i++){
            list[i]=list[i+1];
        }
        numItems--;
        return rtn;
    }
    //checks to see if the array has an elements
    public boolean contains(T val){
        for(int i=0;i<numItems;i++){
            if(list[i].equals(val)) return true;
        }
        return false;
    }
    //finds the first occurence of a value in an array (-1 is returned if it doesn't exist)
    public int indexOf(T val){
        for(int i=0;i<numItems;i++){
            if(list[i].equals(val)) return i;
        }
        return -1;
    }
    //adds an elements into the array at a specified index and reformats accordingly
    public void add(int num, T val){
        doubleCheck();
        for(int i=numItems+1;i>num;i--){
            list[i]=list[i-1];
        }
        list[num]=val;
        numItems++;
    }
    //used for testing
    public void fillIn(T val){
        for(int i=0;i<list.length;i++){
            list[i]=val;
        }
    }


}
