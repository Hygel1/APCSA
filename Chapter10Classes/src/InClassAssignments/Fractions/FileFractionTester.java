import java.io.FileReader;
import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author yoderr
 */
public class FileFractionTester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Create access to the necessary files in the project.  (Hard-coded file names.)
		BufferedReader inputFile =
                new BufferedReader(new FileReader("in.txt"), 1024);
		
		PrintWriter outputFile =
                new PrintWriter(new FileWriter("out.txt"));

		//Process the IN file as long as there is a line of data
		//Assumes all entries in the inputFile are properly formed fractions.
		String line;
		while ((line = inputFile.readLine()) != null)
	    {
			int slash = line.indexOf("/");
			int num, denom; 
			if (slash == -1) {
				num = Integer.valueOf(line);
				denom = 1;
			}
			else {
				num= Integer.valueOf(line.substring(0,slash));
				denom = Integer.valueOf(line.substring(slash+1));
			}
			
			Fraction f = new Fraction(num,denom);
			System.out.println(f + " = " + f.getValue());
			outputFile.println(f + " = " + f.getValue());
	    }
		
		//Clean up and close files.
		inputFile.close();
	    outputFile.close();
	    System.out.println("Done.");
	}
}
