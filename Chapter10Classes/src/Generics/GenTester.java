package Generics;

public class GenTester {
    private static GenericTypeTrial<Integer> gen = new GenericTypeTrial<>();

    public static void main(String args[]){
        printArray(new Integer[]{1,2,3,4,5,6,7,8});
        System.out.println(gen.get());
        gen.set(3);
        System.out.println(gen.get());
        
    }
    public static <Q, K> void printArray(Q[] arr){
        for(Q elem: arr) System.out.println(elem);
    }
}
