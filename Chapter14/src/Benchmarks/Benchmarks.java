/**
 * This program compares benchmarks for Selection Sort,
 * Insertion Sort, Mergesort and Quicksort (and Arrays.sort for
 * Question 16 in the exercises)
 * 
 * Notes:
 * Insertion Sort
 *  Fine for smaller numbers of elements, but takes a long time as the number of elements increases
 *  Takes a long time rewriting existing values
 *  Not Ideal
 * Merge Sort
 *  Recursive, could take lots of memory
 *  Consistently increases time as the number of elements increases
 *  Ranks third-fastest in every test
 * Quick Sort
 *  Fastest non-built-in method
 *  Time taken consistently increases as the number of values increases
 *  Swapping value could be an inefficiency but doesn't take bulk memory at any particular time
 * Selection Sort
 *  Very inefficient, takes the longest for every array length
 *  Looks at every unswapped element several times, then takes a long time using swap
 *  Doesn't seem ideal for any use case
 * Arrays.sort
 *  Most efficient at every length
 *  Changes the sorting method given the use case, always the more efficient method
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.Random;
import java.util.Arrays;

public class Benchmarks extends JFrame
{
  private static int numberOfRuns = 20;

  private JTextField arraySizeInput, display;
  private String sortMethodNames[] =
     {"Selection Sort", "Insertion Sort", "Mergesort", "Quicksort", "Arrays.sort()"};
  private JComboBox<String> chooseSortMethod;
  // Starting Java 7 JComboBox is type specific.  In earlier versions use
  // private JComboBox chooseSortMethod;

  private final long seed;
  private int arraySize;

  // Constructor
  public Benchmarks()
  {
    super("Benchmarks");

    Container c = getContentPane();
    c.setLayout(new GridLayout(6, 1));

    c.add(new JLabel(" Array size: "));
    arraySizeInput = new JTextField(4);
    arraySizeInput.setText("1000");
    arraySizeInput.selectAll();
    c.add(arraySizeInput);

    chooseSortMethod = new JComboBox<String>(sortMethodNames);
    // Before Java 7: chooseSortMethod = new JComboBox(sortMethodNames);
    
    c.add(chooseSortMethod);

    JButton run = new JButton("Run");
    run.addActionListener(new RunButtonListener());
    c.add(run);

    c.add(new JLabel(" Avg Time (milliseconds): "));

    display = new JTextField("   Ready");
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display);

    // Use the same random number generator seed for all benchmarks
    //   in one run of this program:
    seed = System.currentTimeMillis();
  }

  /**
   * Fills a[] with random numbers and sorts it using the sorting method
   * specified in sortMethod:
   *    1 -- Selection Sort
   *    2 -- Insertion Sort
   *    3 -- Mergesort
   *    4 -- Quicksort
   * This is repeated numberOfRuns times for better accuracy
   * Returns the total time it took in milliseconds.
   */
  private long runSort(double[] a, int sortMethod, int numberOfRuns)
  {
    Random gen=new Random(seed);
    long time=0;
    for(int i=0;i<numberOfRuns;i++){
      for(int n=0;n<a.length;n++){
        a[n]=gen.nextDouble();
      }
      if(sortMethod==1){
        time+=System.currentTimeMillis();
        SelectionSort.sort(a);
        time-=System.currentTimeMillis();
      }
      else if(sortMethod==2){
        time+=System.currentTimeMillis();
        InsertionSort.sort(a);
        time-=System.currentTimeMillis();
      }
      else if(sortMethod==3){
        time+=System.currentTimeMillis();
        Mergesort.sort(a);
        time-=System.currentTimeMillis();
      }
      else if(sortMethod==4){
        time+=System.currentTimeMillis();
        Quicksort.sort(a);
        time-=System.currentTimeMillis();
      }
      else if(sortMethod==5){
        time+=System.currentTimeMillis();
        Arrays.sort(a);
        time-=System.currentTimeMillis();
      }
    }
    return time*-1;
  }
  /**
   * swaps the value at ind1 with the value at ind2
   * @param a
   * @param ind1
   * @param ind2
   */
private void swap(double[] a,int ind1, int ind2){
  double hold=a[ind1];
  a[ind1]=a[ind2];
  a[ind2]=hold;
}

  /**
   * Handles Run button events
   */
  private class RunButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String inputStr = arraySizeInput.getText().trim();
      try
      {
        arraySize = Integer.parseInt(inputStr);
      }
      catch (NumberFormatException ex)
      {
        display.setText(" Invalid array size");
        arraySize = 0;
        return;
      }

      if (arraySize <= 0)
      {
        display.setText(" Invalid array size");
        return;
      }

      if (arraySize <= 0)
        return;

      int sortMethod = chooseSortMethod.getSelectedIndex() + 1;
      double a[] = new double[arraySize];
      double avgTime = (double)runSort(a, sortMethod, numberOfRuns)
                                                          / numberOfRuns;
      display.setText(String.format("  %.2f", avgTime));

      arraySizeInput.selectAll();
      arraySizeInput.requestFocus();
      System.out.println("Array size = " + arraySize +
            " Runs = " + numberOfRuns + " " +
            sortMethodNames[sortMethod - 1] + " avg time: " + avgTime);

    }
  }

  //************************************************************

  public static void main(String[] args)
  {
    numberOfRuns = 20;
    if (args.length > 0)
    {
      int n = -1;
      try
      {
        n = Integer.parseInt(args[0].trim());
      }
      catch (NumberFormatException ex)
      {
        System.out.println("Invalid command-line parameter");
        System.exit(1);
      }
      if (n > 0)
        numberOfRuns = n;
    }

    Benchmarks window = new Benchmarks();
    window.setBounds(300, 300, 180, 200);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
