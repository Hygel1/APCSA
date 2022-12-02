package InClassAssignments.ArrayLists.Align;

public class TestLineList
{
  public static void main(String[] args)
  {
    LineList list = new LineList();
    list.add("Alice");
    list.add("Bob");
    list.add("Connie");
    list.add("Dave");
    list.add("Erin");
    list.add("Frank");

    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nmove 5 ==> 0");
    list.move(5, 0);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nmove 4 ==> 1");
    list.move(4, 1);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nmove 3 ==> 2");
    list.move(3, 2);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nmove 0 ==> 5");
    list.move(0, 5);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nmove 1 ==> 2");
    list.move(1, 2);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nmove 0 ==> 3");
    list.move(0, 3);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nremove 5");
    list.remove(5);      
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nremove 2");
    list.remove(2);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nremove 0");
    list.remove(0);
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nshuffle");
    list.shuffle();
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nshuffle");
    list.shuffle();
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();

    System.out.println("\nshuffle");
    list.shuffle();
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();
  }  
}
