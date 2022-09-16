/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion:  9/16/2022
 * Assignment:  Ch08 Strings Test Take Home Portion
 * 
 * Attribution: 
 * 
 * General Description: Ch08 Strings Test Take Home Portion
 * 
 * Advanced: Full detailed test method containing 5 tests for each method and a printed statement to say 
 * that a set of tests is complete
 * 
 * Errata:
 */
	/**
	 * main runs a test method conatining tests for every method
	 */
public class Ch8StringTest {
    public static void main(String args[]){
        testMethod();
    }
    /**
     * runs 5 tests for each method and prints errors found;
     * also prints when it has finished a set of tests to ensure that each set of tests gets
     */
    public static void testMethod(){
        //sameEnd tests
        if(!sameEnd("this", "terhis")) System.out.println("error: sameEnd test 1");
        if(sameEnd("this", "that")) System.out.println("error: sameEnd test 2");
        if(sameEnd("nothing", "alike")) System.out.println("error: sameEnd test 3");
        if(sameEnd("th", "er")) System.out.println("error: sameEnd test 4");
        if(!sameEnd("same", "same")) System.out.println("error: sameEnd test 5");
        System.out.println("sameEnd tested");
        //q24 tests
        if(!q24("this(that)").equals("that")) System.out.println("error: q24 test 1");
        if(!q24("inside").equals("inside")) System.out.println("error: q24 test 2");
        if(!q24("(inside)").equals("inside")) System.out.println("error: q24 test 3");
        if(!q24("(this").equals("(this")) System.out.println("error: q24 test 4");
        if(!q24("whats(inside)whats").equals("inside")) System.out.println("error: q24 test 5");
        System.out.println("q24 tested");
        //hasMatch tests
        if(!hasMatch("this is the substring to test", "ubstring")) System.out.println("errors: hasMatch test 1");
        if(hasMatch("this is the substring to test", "why would this be in there")) System.out.println("error: hasMatch test 2");
        if(!hasMatch("this is the substring", "sub"))System.out.println("error: hasMatch test 3");
        if(!hasMatch("substring", "String")) System.out.println("error: hasMatch test 4");
        if(!hasMatch("SUBSTRING", "string")) System.out.println("error: hasMatch test 5");
        System.out.println("hasMatch tested");
        //validFileName tests
        if(!(validFileName("theFileName.txt")==null)) System.out.println("error: validFileName test 1");
        if(!(validFileName("1234567.txt").equals("1234567.TXT"))) System.out.println("error: validFileName test 2");
        if(!validFileName("theFile").equals("THEFILE.TXT")) System.out.println("error: validFileName test 3");
        if(!(validFileName("this:fi")==null)) System.out.println("error: validFileName test 4");
        if(!(validFileName("thefil.text")==null)) System.out.println("error: validFileName test 5");
        System.out.println("validFileName tested");
        //listOfStoryNames tests
        if(!listOfStoryNames("this name:John is a name:Mike but there is no name:Michael").equals("John, Mike, Michael")) System.out.println("error: listOfStoryNames test 1");
        if(!listOfStoryNames("name:Mike").equals("Mike")) System.out.println("error: listOfStoryNames test 2");
        if(!listOfStoryNames("what are the names").equals("")) System.out.println("error: listOfStoryNames test 3");
        if(!listOfStoryNames("nothing").equals("")) System.out.println("error: listOfStoryNames test 4");
        if(!listOfStoryNames("name:John really doesn't like name:Mike ").equals("John, Mike")) System.out.println("error: listOfStoryNames test 5");
        System.out.println("listOfStoryNames tested");
    }
    /**
     * return true if both s1 and s2 are not empty,
     * start with the same character and also
     * end with the same 3 characters; otherwise return false
     */
    public static boolean sameEnd(String s1, String s2){
        return s1.length()>2&&
        s2.length()>2&&
        s1.charAt(0)==s2.charAt(0)&&
        s1.substring(s1.length()-3).equals(s2.substring(s2.length()-3));
    }
    /**
     * returns the string inside of the first opening and the last closing parentheses
     * if these do not exist, return the string unchanged
     */
    public static String q24(String str){
        if(str.indexOf("(")!=-1&&str.lastIndexOf(")")!=-1) return str.substring(str.indexOf("(")+1,str.lastIndexOf(")"));
        return str;
    }
    /**
     * returns true if p matches, case blind, and substring of s;
     * otherwise return false
     * Hint: which is the container and which is the part?
     */
    public static boolean hasMatch(String s, String p){
        return s.toLowerCase().indexOf(p.toLowerCase())!=-1;
    }
    /**
     * properly formats the given file name
     */
    private static String validFileName(String fileName){
        if(fileName.indexOf(":")!=-1||fileName.indexOf("\\")!=-1||fileName.indexOf("?")!=-1||fileName.indexOf("*")!=-1||fileName.indexOf(".")==-1&&fileName.length()>8||fileName.indexOf(".")!=-1&&(fileName.substring(0,fileName.indexOf(".")).length()>8||fileName.substring(fileName.indexOf("."),fileName.length()).length()>4)) return null;
        if(fileName.indexOf(".")==fileName.length()-1) return fileName.toUpperCase().substring(0,fileName.length()-1);
        if(fileName.indexOf(".")==-1) return fileName.toUpperCase()+".TXT";
        return fileName.toUpperCase();
    }
    /**
     * returns a list of names in a paragraph
     */
    private static String listOfStoryNames(String paragraph){
        String temp=paragraph; //temporary hold variable to leave paragraph unchanged
        String names="";
        while(temp.indexOf("name:")!=-1){
            if(temp.indexOf(" ", temp.indexOf("name:"))==-1){
                 names=names+temp.substring(temp.indexOf("name:")+5)+", ";
                 temp=temp.substring(temp.indexOf("name:")+5);
                }
            else{
                names=names+temp.substring(temp.indexOf("name:")+5,temp.indexOf(" ", temp.indexOf("name:")))+", ";
                temp=temp.substring(temp.indexOf("name:")+1);
            }
        }
        if(names.indexOf(", ")==-1) return names;
        return names.substring(0,names.lastIndexOf(", "));
    }
}