public class Ch8StringTest {
    public static void main(String rgs[]){
        
    }
    public static String testMethod(){
        String errors="";
        //set up test cases
        //sameEnd tests
        if(!sameEnd("this", "terhis")) errors+="error: sameEnd test 1 /n";
        if(sameEnd("this", "that")) errors+="error: sameEnd test 2 /n";
        if(sameEnd("nothing", "alike")) errors+="error: sameEnd test 3 /n";
        if(sameEnd("th", "er")) errors+="error: sameEnd test 4 /n";
        if(sameEnd("same", "same")) errors+="error: sameEnd test 5 /n";
        //q24 tests



        return errors;
    }
    /**
     * return true if both s1 and s2 are not empty,
     * start with the same character and also
     * end with the same 3 characters; otherwise return false
     */
    public static boolean sameEnd(String s1, String s2){
        return s1.length()>2&&s2.length()>2&&s1.charAt(0)==s2.charAt(0)&&s1.substring(s1.length()-3).equals(s2.substring(s2.length()-3));
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
        String names="";
        while(paragraph.indexOf("names:")!=-1){
            names=names+paragraph.substring(paragraph.indexOf("names:")+6,paragraph.indexOf(":", paragraph.indexOf("names:")+6))+", ";
            if(paragraph.indexOf("names: ", paragraph.indexOf("names")+1)!=-1) paragraph=paragraph.substring(paragraph.indexOf("names:")+1);
        }
        return names;
    }
}
