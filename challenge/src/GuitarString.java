public class GuitarString{
    double frequency;
    RingBuffer rB;
    public GuitarString(double frequency){
        this.frequency=frequency;
    }
    public GuitarString(double[] init){
        rB=new RingBuffer(init.length);
        for(int i=0;i<init.length;i++){
            rB.enqueue(init[i]);
        }
    }
    public static void main(String[] args){

    }
    public int length(){
        return rB.size();
    }
    public void pluck(int n){
        
    }
    public void tic(){

    }
    public double sample(){

    }
 }