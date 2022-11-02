public class testFunctions{
    public static void main(String[] args){
        String myString = new String("my string");

String yourString = new String();

yourString = "my string";

boolean dotEquals = myString.equals(yourString);

boolean equalsEquals = (myString == yourString);

System.out.print(dotEquals + " " + equalsEquals);
    }
}