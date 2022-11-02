package Fractions;
/**
 * Represents a fraction with an int numerator and int denominator
 * and provides methods for adding and multiplying fractions.
 *
 * Author: Alex, Sean
 */

public class Fraction
{

  // ******************  Instance variables  ******************

  private int num;
  private int denom;

  // *********************  Constructors  *********************

  public Fraction()       // no-args constructor
  {
    num = 0;
    denom = 1;
  }

  public Fraction(int n)
  {
    num = n;
    denom = 1;
  }

  public Fraction(int n, int d)
  {
    if (d != 0)
    {
      num = n;
      denom = d;
      reduce();
    }
    else
    {
      throw new IllegalArgumentException(
           "Fraction construction error: denominator is 0");
    }
  }

  public Fraction(Fraction other)  // copy constructor
  {
    num = other.num;
    denom = other.denom;
  }

  // ********************  Public methods  ********************

  // Returns the sum of this fraction and other
  public Fraction add(Fraction other)
  {
    int newNum = num * other.denom + denom * other.num;
    int newDenom = denom * other.denom;
    return new Fraction(newNum, newDenom);
  }

  // Returns the sum of this fraction and m
  public Fraction add(int m)
  {
    return new Fraction(num + m * denom, denom);
  }

  // Returns the product of this fraction and other
  public Fraction multiply(Fraction other)
  {
    int newNum = num * other.num;
    int newDenom = denom * other.denom;
    return new Fraction(newNum, newDenom);
  }

  // Returns the product of this fraction and m
  public Fraction multiply(int m)
  {
    return new Fraction(num * m, denom);
  }
  /**
   * subtracts an int value n from the existing fraction in the class
   * @param n
   * @return
   */
  public Fraction subtract(int n){
    return new Fraction(num-n*denom,denom);
  }
  /**
   * subtracts a fraction frac from the class' existing fraction
   * @param frac
   * @return
   */
  public Fraction subtract(Fraction frac){
    return new Fraction(num*frac.denom-frac.num,denom*frac.denom);
  }
  /**
   * divides the class' existing fraction by an int value n
   * @param n
   * @return
   */
  public Fraction divide(int n){
    return new Fraction(num,denom*n);
  }
  /**
   * divides the class' existing fraction by a fraction frac
   * @param frac
   * @return
   */
  public Fraction divide(Fraction frac){
    return new Fraction(num*frac.denom,denom*frac.num);
  }

  // Returns the value of this fraction as a double
  public double getValue()
  {
    return (double)num / (double)denom;
  }
  
  // Returns a string representation of this fraction
  public String toString()
  {
    return num + "/" + denom;
  }
  // *******************  Private methods  *******************

  // Reduces this fraction by the gcf and makes denom > 0
  private void reduce()
  {
    if (num == 0)
    {
      denom = 1;
      return;
    }

    if (denom < 0)
    {
      num = -num;
      denom = -denom;
    }

    int q = gcf(Math.abs(num), denom);
    num /= q;
    denom /= q;    
  }

  // Returns the greatest common factor of two positive integers
  private int gcf(int n, int d)
  {
    if (n <= 0 || d <= 0)
    {
      throw new IllegalArgumentException("gcf precondition failed: " + n + ", " + d);
    }

    while (d != 0)
    {
      int temp = d;
      d = n % d;
      n = temp;
    }
    return n;
  }
}
