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
  public String q5A(String ccNumber){
    return ccNumber.substring(ccNumber.length()-4,ccNumber.length());
  }
  /**
   * #5b
   * sets String last5 to the last 5 digits of ccNumber
   */
  public void q5B(String ccNumber){
    String last5=ccNumber.substring(ccNumber.length()-5,ccNumber.length());
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

    // ... insert code to process str or call a method here
    // str = _______________________________ ;
    //str=""+hasTwoStars(str); for question 2b
    //str=""+q2A(str); for question 2a
    ///str=q3(str); for question 3
    //str=q4A(str); for question 4a
    str=""+q9(str);
    
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

