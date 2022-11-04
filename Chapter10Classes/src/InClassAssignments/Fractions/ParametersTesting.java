/**
 * @author yoderr
 *
 */
public class ParametersTesting {
	
	/**
	 * Note these versions of SWAP are INCORRECT and will not function.
	 * This is because all parameters are copies of the primitive data
	 * or address/references and cannot be changed through the parameter itself.
	 * @param num1
	 * @param num2
	 */
	public static void swap(Integer num1, Integer num2)
	{
		int temp = num1;
		num1=num2;
		num2=temp;
	}
	
	public static void swap(Fraction one, Fraction two)
	{
		Fraction holder = one;
		one = two;
		two = holder;
	}

	/**
	 * Ok to use X as a variable or parameter name in main, 
	 * or in multiple methods.  Each one is a variable that exists
	 * locally.  The Java compiler will always refer to the one with
	 * the closes locality or narrowest scope/visibility.
	 * 
	 * Parameters exist and can be used as local variables ONLY within
	 * their methods.
	 * @param x
	 * @return
	 */
	public static double square(double x) {
		x*=x;
		return x;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Parameters sent as primitives are sent as copies.
		double x = 3.0;
		System.out.println("X = "+x);
		//double y = square(x);
		System.out.println("X = "+x);

		int first = 10;
		int second = 20;
		System.out.println("First: " + first + " Second: " + second);
		System.out.println("Swapped?");
		swap(first,second);
		System.out.println("First: " + first + " Second: " + second);
		System.out.println();
		//Explain this behavior?

		
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(5,17);
		Fraction f3 = f1.add(f2);
		System.out.println("f1:" + f1 + " f2:" + f2);
		System.out.println(f1 + " + " + f2 + " = " + f3);
		System.out.println("Swapped f1 & f2?");
		/*
		 * Can an object be mutated/change its state? 
		 * An Object cannot be replaced with a reference to a different address/object. 
		 * However, mutators/modifiers can be applied to an Object type if such exist. 
		 * The OBJECT itself is NEVER copied into the parameter; only the reference/address
		 * to that object is copied. The address cannot be changed, though the object referred
		 * to may be modified.
		 * (add one.triple() call within swap.... to see its effect! [Fraction would
		 * need a triple() method that multiplies a Fraction's numerator by 3.])
		 */		
		System.out.println("f1:" + f1 + " f2:" + f2);
	}

}
