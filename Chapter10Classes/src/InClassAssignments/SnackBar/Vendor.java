/**
 * This class implements a vendor that sells one kind
 * of items. A vendor carries out sales transactions.
 */
public class Vendor
{
  // Fields:
private int price; //price of one item
private int stock; //current number of resources
//private int fullStock; //amount of stock required to be considered full
private int dep=0; //amout of money deposited
  /**
   * Constructs a Vendor
   * @param price the price of a single item in cents (int)
   * @param stock number of items to place in stock (int)
   */
  public Vendor(int price, int stock){
    this.price=price;
    //fullStock=stock;
    this.stock=stock;
  }
  //Static variables and methods
  private static double totalSales=0.0; //total sales from all vendors in dollars
  public static double getTotalSale(){ //returns the total sales
    double hold=totalSales;
    totalSales=0;
    return hold;
  }

  /**
   * Sets the quantity of items in stock.
   * @param qty number of items to place in stock (int)
   */
  public void setStock(int num){
    stock+=num;
  }

  /**
   * Returns the number of items currently in stock.
   * @return number of items currently in stock (int)
   */
  public int getStock(){
    return stock;
  }

  /**
   * Adds a specified amount (in cents) to the
   * deposited amount.
   * @param number of cents to add to the deposit (int)
   */
  public void addMoney(double amt){
    dep+=amt;
  }

  /**
   * Returns the currently deposited amount (in cents).
   * @return number of cents in the current deposit (int)
   */
  public int getDeposit(){
    return dep;
  }

  /**
   * Implements a sale.  If there are items in stock and
   * the deposited amount is greater than or equal to
   * the single item price, then adjusts the stock and
   * calculates and sets change, sets deposit to 0 and
   * returns true; otherwise refunds the whole deposit
   * (moves it into change) and returns false.
   * @return true for a successful sale, false otherwise (boolean)
   */
  public boolean makeSale(){
    if(price>dep) return false;
    stock--;
    totalSales+=price/100.0;
    dep-=price;
    return true;
  }

  /**
   * Returns and zeroes out the amount of change (from
   * the last sale or refund).
   * @return number of cents in the current change (int)
   */
  public int getChange(){
    int hold=dep;
    dep=0;
    return hold;
  }
}
