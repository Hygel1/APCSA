package InClassAssignments.ArrayLists;

public class TestList{
    public static void main(String[] args){
        MyArrayList<String> names=new MyArrayList<>();
        MyArrayList<String> names1=new MyArrayList<>(10);
        MyArrayList<Integer> list=new MyArrayList<>(4);
    
        names.add("sean");names.add("michael");names.add("mcloughlin");
        //testing isFull
        System.out.println("isFull()...");
        System.out.println(names.isFull()+" should be false");
        //testing add
        System.out.println("add()...");
        System.out.println(names+" should be sean, michael, mcloughlin");
        names.add(1,"john");
        System.out.println(names+" should be sean, john, michael, mcloughlin");
        //testing size
        System.out.println("size()...");
        System.out.println(names.size()+" should be 4");
        System.out.println(names1.size()+" should be 0");
        //testing isEmpty
        System.out.println("isEmpty()...");
        System.out.println(names.isEmpty()+" should be false");
        System.out.println(names1.isEmpty()+" should be true");
        //testing set
        System.out.println("set()...");
        System.out.println(names.set("mike", 2)+" should be michael");
        System.out.println(names+" should be sean, john, mike, mcloughlin");
        //testing get
        System.out.println(names.get(0)+" should be sean");
        //System.out.println(names.get(-1)+" should throw IndexOutOfBoundsException");
        //it does, but it stops the program so I have to comment it out
        //testing remove
        System.out.println(names.remove(2)+" should be mike");
        System.out.println(names+" should be sean, john, mcloughlin");
        //testing contains
        System.out.println(names.contains("mike")+" should be false");
        System.out.println(names.contains("john")+" should be true");
        //testing indexOf
        System.out.println(names.indexOf("sean")+" should be 0");
        System.out.println(names.indexOf("mike")+" should be -1");
        //done testing 
    }
    }