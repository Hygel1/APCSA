/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own.  Signed: Sean McLoughlin
 * Date of Completion: 9/5/2022
 * Assignment:  Ch. 8 Strings HW Pt. 1
 * 
 * Attribution: I worked with Andrew Albright to complete some of the book questions
 * 
 * General Description: Questions #1-11,13,14 in Ch. 8 of book, 7 CodingBat String1 questions
 * 
 * Advanced:  Book questions #8/9
 * 
 * Errata:  Question 5a/5b say to delcare unused and unreachable variables so I wrote them that way but included a way to return the values of the variables as well
 *
 * I have previously completed most of CodingBat in my Marist account and haven't been able to find a way to reset my progress so I made a new account using a personal email, 
 * which means that the progress won't show up in my connected account's progress tab but I have my own progress graphs to show when I did them
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;

public class StringTest extends JFrame
        implements ActionListener
{
  private JTextField input, result;

//Start Book Problems
  /**
   * #1
   * C:\\dictionaries\\words.txt
   */
  /**
   * #2a
   * determines if a string is not empty and the last char is '*'
   */
  public boolean q2A(String str){
    return str.length()>0&&str.charAt(str.length()-1)=='*';
  }
  /** 
   * #2b
   * determines if there are at least 2 characters and the last 2 chars are stars
   */
  public boolean hasTwoStars(String str){
    return str.lastIndexOf("**")==str.length()-2&&str.length()>1; //-2 because we are checking for 2 chars at the end
  }
  /**
   * #3
   * removes the dashes from a social security number
   */
  public String q3(String str){
    return str.substring(0,3)+str.substring(4,6)+str.substring(7,str.length());
  }
  /**
   * #4a
   * converts dates in format mm/dd/yyyy to format dd-mm-yyyy
   */
  public String q4A(String str){
    return str.substring(3,5)+"-"+str.substring(0,2)+"-"+str.substring(6,str.length());
  }
  /**
   * #4b
   * converts dates in format m/d/yyyy to format dd-mm-yyyy
   */
  public String q4B(String str){
    //Test if month is 1 or 2 digits
    if(str.indexOf("/")==1) str="0"+str;
    if(str.charAt(4)=='/') return "0"+str.charAt(3)+"-"+str.substring(0,2)+"-"+str.substring(str.length()-4,str.length());
    else return str.substring(3,5)+"-"+str.substring(0,2)+"-"+str.substring(str.length()-4,str.length());
  }
  /**
   * #5a
   * sets String last4 to the last 4 digits of ccNumber
   */
  public void q5A(String ccNumber){
    String last4=ccNumber.substring(ccNumber.length()-4,ccNumber.length());
    // return ccNumber.substring(ccNumber.length()-5,ccNumber.length())
  }
  /**
   * #5b
   * sets String last5 to the last 5 digits of ccNumber
   */
  public void q5B(String ccNumber){
    String last5=ccNumber.substring(ccNumber.length()-5,ccNumber.length());
    //return ccNumber.substring(ccNumber.length()-5,ccNumber.length())
  }
  /**
   * #6
   * moves the last character of a String to the front
   */
  public String q6(String scroll){
    return scroll.charAt(scroll.length()-1)+scroll.substring(0,scroll.length()-1);
  }
  /**
   * #7
   * reformats name from last, first to first last
   */
  public String q7(String name){
    return name.substring(name.indexOf(",")+1,name.length())+" "+name.substring(0,name.indexOf(","));
  }
  /**
   * #8
   * takes String of 0s and 1s and reverses the value of each place
   */
  public String q8(String str){
    str.replace("0","2");
    str.replace("1","0");
    str.replace("2","1");
    return str;
    }
  /**
   * #9
   * determines if all characters in a String are the same without using loops
   */
  public boolean q9(String str){
    return str.replace(str.charAt(0)+"","aa").length()==str.length()*2;
  }
  /**
   * #10
   * removes any comments marked by multi-line notation
   */
  public String q10(String str){
    if(str.indexOf("/*")!=-1 && str.indexOf("*/", str.indexOf("/*")+2)!=-1) return str.substring(0,str.indexOf("/*"))+str.substring(str.indexOf("*/")+2);
    return str;
  }
  /**
   * #11
   * cuts out the first instance of a given substring
   */
  public String q11(String str,String cutOut){
    /*
    if(str.indexOf(cutOut)!=-1) return str.substring(0,str.indexOf(cutOut))+str.substring(str.indexOf(cutOut)+cutOut.length());
    return str;
    */
    return str.replaceFirst(cutOut, "");
    
  }
  /**
   * #13a
   * decides whether a String starts with a given prefix
   */
  public boolean q13a(String str, String prefix){
    return prefix.equals(str.substring(0,prefix.length()));
  }
  /**
   * #13b
   * decides whether a String ends with a given suffix
   */
  public boolean q13b(String str, String suffix){
    return suffix.equals(str.substring(str.length()-suffix.length(),str.length()));
  }
  /**
   * #14
   * removes HTML tags from a string
   */
  public String q14(String str){
    //checks if there is a '<' at index 0 and if there is a '>' in any other index (implicitly after the '<'), then compares the last values (space for closing tag) to a reformatted version of the original tag. If this all comes back true, it returns what is between the tags
    if(str.charAt(0)=='<'&&str.indexOf(">")!=-1&&str.substring(str.length()-str.indexOf(">")-2).equals("</"+str.substring(1,str.indexOf(">")+1))) return str.substring(str.indexOf(">")+1,str.length()-str.indexOf(">")-2);
    return str;
  }

// End book problems, start CodingBat problems:

//1. returns the name in format "Hello name!""
public String helloName(String name){
  return "Hello "+name+"!";
}
//2. puts two strings together in the order abba
public String makeAbba(String a, String b) {
  return a+b+b+a;
}
//3. surrounds word with tag formatted as html tag
public String makeTags(String tag, String word) {
  return "<"+tag+">"+word+"</"+tag+">";
}
//4. places word in the middle of out
public String makeOutWord(String out, String word) {
  return out.substring(0,out.length()/2)+word+out.substring(out.length()/2);
}
//5. returns 3 copies of the last 2 chars of str
public String extraEnd(String str) {
  return str.substring(str.length()-2)+str.substring(str.length()-2)+str.substring(str.length()-2);
}
//6. returns the first 2 chars of str, returns the whole string if there are not 2 chars
public String firstTwo(String str) {
  if(str.length()>=2) return str.substring(0,2);
  return str;
}
//7. returns the first half of a string
public String firstHalf(String str) {
  return str.substring(0,str.length()/2);
}

  public StringTest()
  {
    super("String test");
    Box box1 = Box.createVerticalBox();
    box1.add(Box.createVerticalStrut(20));
    box1.add(new JLabel("Input:"));
    box1.add(Box.createVerticalStrut(20));
    box1.add(new JLabel("Result:"));

    input = new JTextField(20);
    input.setBackground(Color.YELLOW);
    input.addActionListener(this);
    input.selectAll();

    result = new JTextField(20);
    result.setBackground(Color.WHITE);
    result.setEditable(false);

    Box box2 = Box.createVerticalBox();
    box1.add(Box.createVerticalStrut(20));
    box2.add(input);
    box2.add(Box.createVerticalStrut(20));
    box2.add(result);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(box1);
    c.add(box2);
    input.requestFocus();
  }

  public void actionPerformed(ActionEvent e)
  {
    String str = input.getText();

    str=q14(str); //Changeable test function
    
    result.setText(str);
    input.selectAll();
  }

  public static void main(String[] args)
  {
    StringTest window = new StringTest();
    window.setBounds(100, 100, 360, 160);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

