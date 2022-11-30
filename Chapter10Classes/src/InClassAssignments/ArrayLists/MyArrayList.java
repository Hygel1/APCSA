package InClassAssignments.ArrayLists;

public class MyArrayList {
    private int numItems;
    private String[] list;
    public MyArrayList(){ //constructor that creates a new version of MyArrayList with a default (10) size
        list=new String[10];
    }
    public MyArrayList(int initCap){ //overloaded constructor that creates a new version of MyArrayList with a given (initCap) size
        list=new String[initCap]; //all created elements are null and capacity it equal to initCap
    }
    public static void main(String[] args[]){

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
    public boolean add(String obj){
        if(isFull()){ //if the reserved memory is full, we must add to the capacity
            String[] doubled=new String[list.length*2]; //we could grow by only one, but that makes us grow more often (memory is sacrificed in the interest of processing power)
            //transfer all values in list to new doubled array
            for(int i=0;i<list.length;i++){
                doubled[i]=list[i];
            }
            list=doubled; //replace list array with doubled (longer array)
        }
        list[numItems]=obj; //the number of items is always one more than the index of the last element, therefore we can just use numItems to get the index to add to
        numItems++;
        return true;
    }
    //replaces a value in the list with val, returning the previous value for preservation
    public String set(String val, int ind){
        if(ind<0||ind>=numItems) throw new IndexOutOfBoundsException();
        String rtn=list[ind];
        list[ind]=val;
        return rtn;
    }
    //returns the element of the list at a given index
    public String get(int ind){
        if(ind<0||ind>=numItems) throw new IndexOutOfBoundsException();
        return list[ind];
    }
    public String toString(){
        String rtn="";
        for(int i=0;i<numItems;i++){
            rtn+=list[i]+", ";
        }
        //eliminate final
        rtn=rtn.substring(0,rtn.length()-2);
        return "["+rtn+"]";
    }



}
