package InClassAssignments;

public class MyArrayList {
    private int numItems;
    private String[] list;
    public MyArrayList(){ //constructor that creates a new version of MyArrayList with a default (10) size
        list=new String[10];
    }
    public MyArrayList(int initCap){ //overloaded constructor that creates a new version of MyArrayList with a given (initCap) size
        list=new String[initCap];
    }
    public static void main(String[] args[]){

    }
    public boolean isEmpty(){
        return numItems==0;
    }
    public int size(){
        return numItems;
    }
    public boolean isFull(){
        return numItems==list.length;
    }
    public boolean add(String obj){
        if(isFull()){
            String[] doubled=new String[list.length*2];
            //transfer all values in list to new doubled array
            for(int i=0;i<list.length;i++){
                doubled[i]=list[i];
            }
            list=doubled; //replace list array with doubled (longer array)
        }
        list[numItems]=obj;
        numItems++;
        return true;
    }



}
