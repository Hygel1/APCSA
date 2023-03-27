package Chapter19;

public class LinkedList1<T>{
    private int start=0;
    private int end=0;
    private Object[] arr;
    public LinkedList1(){
        arr=(T[]) new Object[10];
    }
    public LinkedList1(int num){
        arr=(T[]) new Object[num];
    }
    public int size(){
        return end-start;
    }
    public int get(int index){
        
    }
    public class llItem<Q>{
        Q item; int next;
        public llItem(Q item, int next){
            this.item=item;
            this.next=next;
        }
        public Q item(){
            return item;
        }
        public int next(){
            return next;
        }
    }
    
}
