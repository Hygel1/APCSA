package InClassAssignments.ArrayLists;

public class TestList{
    public static void main(String[] args){
        MyArrayList<String> names=new MyArrayList<String>();
        MyArrayList<String> names1=new MyArrayList<String>(10);
        
        names.add("sean");names.add("michael");names.add("mcloughlin");
        System.out.println(names.isFull()+" should be false");
        System.out.println(names1.isFull()+" should be true");
        System.out.println(names+" should be sean, michael, mcloughlin");
        names.add(1,"john");
        System.out.println(names+" should be sean, john, michael, mcloughlin");
        System.out.println(names.size()+" should be 4");

    }
}