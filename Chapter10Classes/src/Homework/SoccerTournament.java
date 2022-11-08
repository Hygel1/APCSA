package Homework;

public class SoccerTournament{
    public static void main(String args[]){
        startTournament();
    }
    /**
     * runs a tournament in which every team plays each other once, resulting in 12 randomly decided games
     * static because every instance of this method will be internal in this class
     */
    private static void startTournament(){
        SoccerTeam.startTournament();//resets static fields in SoccerTournament before starting tournament
        SoccerTeam[] teams={new SoccerTeam(0,0,0),new SoccerTeam(0,0,0),new SoccerTeam(0,0,0),new SoccerTeam(0,0,0)};
        for(int i=0;i<teams.length;i++){
            for(int n=i+1;n<teams.length;n++){
                teams[i].played(teams[n],(int)(Math.random()*10),(int)(Math.random()*10));
            }
        }
        //prints the results for each team
        for(int i=0;i<teams.length;i++){
            System.out.println(teams[i].toString());
        }
    }
}
