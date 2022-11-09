/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 11/8/2022
 * Assignment: Team Class design - SoccerTeam #22
 * 
 * Attribution: I worked with Grace Boerner in class
 * 
 * General Description: Creates a soccer team able to play against other teams in tournaments, tracking wins, losses, and ties for each team
 *                      and the total number of games played/goals scored by all teams together
 * 
 * Advanced: Plays through a round-robin tournament with 4 teams in separate tournament class
 */
package Homework;
public class SoccerTeam{
    private int wins, losses, ties; //non-static because each instance of SoccerTeam has a unique value for these fields
    private static int games=0, goals=0; //static because values will always be common across all instances of SoccerTeam
    public SoccerTeam(int numWins,int numLosses,int numTies){
        wins=numWins;
        losses=numLosses;
        ties=numTies;
    }
    public SoccerTeam(){
        wins=0;losses=0;ties=0;
    }
    /**
     * returns wins as a readable parameter
     * @return
     */
    public int getWins(){
        return wins;
    }
    /**
     * returns losses as a readable variable
     * @return
     */
    public int getLosses(){
        return losses;
    }
    /**
     * returns ties as a readable variable
     * @return
     */
    public int getTies(){
        return ties;
    }
    /**
     * returns games as a readable variable
     * static because games is static and commmon across all instances of SocerTeam
     * @return
     */
    public static int getGames(){
        return games;
    }
    /**
     * returns getGoals as a readable variable
     * static because goals is static and commmon across all instances of SocerTeam
     * @return
     */
    public static int getGoals(){
        return goals;
    }
    /**
     * allows for games to be modified from another class according to numGaes parameter
     * @param numGames
     */
    public void setGames(int numGames){
        games=numGames;
    }
    /**
     * allows for goals to be modified from nother class according to numGoals parameter
     * @param numGoals
     */
    public void setGoals(int numGoals){
        goals=numGoals;
    }
    /**
     * allows for wins to be modified from another class according to numWins parameter
     * @param numWins
     */
    public void setWins(int numWins){
        wins=numWins;
    }
    /**
     * allows for losses to be modified from another class according to numLosses parameter
     * @param numLosses
     */
    public void setLosses(int numLosses){
        losses=numLosses;
    }
    /**
     * allows for ties to be modified from another class according to numTies parameter
     */
    public void setTies(int numTies){
        ties=numTies;
    }
    /**
     * runs an instance of one soccer game given both teams and their scores, adding to each's wins/losses/ties and updating static fields
     * @param otherTeam
     * @param myScore
     * @param otherScore
     */
    public void played(SoccerTeam otherTeam, int myScore, int otherScore){
        goals+=myScore+otherScore;
        games++;
        if(myScore==otherScore){
            otherTeam.setTies(otherTeam.getTies()+1);
            //System.out.println("tie"+myScore+", "+otherScore);
        }
        else if(myScore>otherScore){
            //System.out.println("win"+myScore+", "+otherScore);
            wins++;
            otherTeam.setLosses(otherTeam.getLosses()+1);
        }
        else{
            //System.out.println("loss"+myScore+", "+otherScore);
            losses++;
            otherTeam.setWins(otherTeam.getWins()+1);
            }
        }
        /**
         * resets all nonstatic fields
         */
        public void reset(){
            wins=0;
            losses=0;
            ties=0;
        }
        /**
         * returns the number of points a team has earned
         * @return
         */
        public int getPoints(){
            return wins*3+ties;
        }
        /**
         * resets static values of SoccerTeam to prepare for a new tournament
         */
        public static void startTournament(){
            games=0;
            goals=0;
        }
        /**
         * failed attempt at accidenatlly overcomplicating the problem
         * I was trying to pass multiple values to my tournament class but the nested class caused more problems than it solved,
         * I decided to just modify my played() method rather than making this and creating playGame() but I think that the syntax
         * and concept will be helpful to look back on (even if it wasn't helpful here)
         */
        public class ScoreReport{
            private int goals1, goals2;
            public ScoreReport(int s1,int s2){
                goals1=s1; goals2=s2;
            }
            public int getGoals1(){
                return goals1;
            }
            public int getGoals2(){
                return goals2;
            }
        }
        public SoccerTeam playGame(SoccerTeam otherTeam){
            ScoreReport current= new ScoreReport((int)Math.random()*50,(int)Math.random()*50);
            played(otherTeam, current.getGoals1(), current.getGoals2());
            if(current.getGoals1()>current.getGoals2()) return this;
            if(current.getGoals1()<current.getGoals2()) return otherTeam;
            return null;
        }
        /**
         * Returns the values of SoccerTeam as a more user readable String
         */
    public String toString(){
        return "Wins: "+wins+" Losses: "+losses+" Ties: "+ties;
    }
}