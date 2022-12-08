import java.lang.reflect.*;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
public class reflectionTest {
    int num;
    public reflectionTest(int n){
        num=n;
    }
    public static void main(String args[]) throws NoSuchMethodException{
            Method m=reflectionTest.class.getDeclaredMethod("theMeth", Integer.class);
            printer(m.getTypeParameters());
            System.out.println(m.getDeclaringClass().toString());
            System.out.println(m.getModifiers());
            System.out.println(m.getGenericReturnType());
            System.out.println(m.getParameterCount());
            printer(m.getExceptionTypes());
            System.out.println(m.toString());
    }
    public static <T> int theMeth(Integer num) throws InvalidAlgorithmParameterException{
        throw new ArrayIndexOutOfBoundsException();
    }
    public static void printer(TypeVariable<Method>[] o){
        for(TypeVariable el:o){
            System.out.println(el.getName());
        }
    }
    public static void printer(Object[] arr){ for(Object o:arr) System.out.print(o+", ");System.out.println();}
}
