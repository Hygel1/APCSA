package Homework;
import java.awt.Color;

//import Homework.SoccerTeam.ScoreReport;
public class Chapter10HW extends SoccerTeam{
    public static void main(String ars[]){

    }
    //#1
    public String replace(String srt, char character){
        return "";
    }

    /* #2
    a. false
    b. true
    c. true
    d.true
    e. true
    f. true
    */
    
    //#3 C

    /* #4
     * String does have a copy constructor
     * Color does not have a copy constructor
     */

    public class balloon{
        double radius;
        Color color;
        public balloon(){
            radius=10;
            color=new Color(135,206,250);
        }
    }
    public class Fraction{
        private int num, den;
        public Fraction(int myNum, int myDen){
            num=myNum;
            den=myDen;
        }
        public int getNum(){
            return num;
        }
        public int getDen(){
            return den;
        }
        public Fraction divide(Fraction other){
            if(other.getDen()==0){
                
            }
            return new Fraction(num*=other.getDen(),den*=other.getNum());
        }
    }

    // #23 SoccerTeam
    private void startTournament(){
        SoccerTeam team1=new SoccerTeam(0,0,0);
        SoccerTeam team2=new SoccerTeam(0,0,0);
        SoccerTeam team3=new SoccerTeam(0,0,0);
        SoccerTeam team4=new SoccerTeam(0,0,0);
        if(team1.playGame(team2).getGoals1()>team)
    }
}