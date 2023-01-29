public class RingBuffer {
    double[] rBuff;
    int size=0;
    public RingBuffer(int capacity){
        rBuff=new double[capacity];
    }
    public int capacity(){
        return rBuff.length;
    }
    public int size(){
        return size;
    }
    public boolean isFull(){
        return size==rBuff.length;
    }
    public void enqueue(double x){
        if(isFull()) throw new StackOverflowError();
        else{
            rBuff[size]=x;
            size++;
        }
    }
    public double dequeue(){
        if(size==0||isFull()) throw new RuntimeException();
        double temp=rBuff[0];
        for(int i=1;i<size;i++){
            rBuff[i-1]=rBuff[i];
        }
        rBuff[size]=0;size--;
        return temp;
    }
    public double peek(){
        if(size==0||isFull()) throw new RuntimeException();
        return rBuff[0];
    }

}
