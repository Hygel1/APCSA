public class LifeGrid{
    private int[][] gridOfLife;
    private final int ALIVE=1;
    private final int DEAD=0;
    /**
     * defines a lifeGrid to be used to represent cells in GameOfLife
     * @param i rows
     * @param j columns
     */
     LifeGrid(int i, int j){
        gridOfLife=new int[i][j];
    }
        public static void main(String[] args){

        }
        // returns the value of a specified element
        public int getCell(int i, int j){
            return gridOfLife[i][j];
        }
        // sets the value of a specified element
        public void setCell(int i, int j, int k){
            gridOfLife[i][j]=k;
        }
        //evolves the gridOfLife by one generation
        public void evolve(){
            int[][] rtn=new int[gridOfLife.length][gridOfLife[0].length]; //temporary array for changing during method
            for(int i=0;i<rtn.length;i++){
                for(int n=0;n<rtn[i].length;n++){
                    int cN=checkNeighbors(i,n); //cN==current Neighbors
                    boolean cS=false; if(gridOfLife[i][n]==ALIVE) cS=true; //cS==current state in boolean form
                    if(cS) rtn[i][n]=ALIVE;
                    if(cS&&!(cN==2||cN==3)) rtn[i][n]=DEAD; //change from alive to dead
                    else if(!cS&&cN==3) rtn[i][n]=ALIVE; //change from dead to alive
                    //if(cS||cN>0) System.out.println("("+i+", "+n+") "+cN); //used to test checkNeighbors
                }
            }
            gridOfLife=rtn; //releases the memeory of the old gridOfLife and replaces it with rtn
        }
        //returns the number of living neighbors around the specified element
        private int checkNeighbors(int i,int j){
            int rtn=0-gridOfLife[i][j];
            for(int n=i-1;n<i+2;n++){
                if(n>-1&&n<gridOfLife.length){
                    for(int q=j-1;q<j+2;q++){
                        if(q>-1&&q<gridOfLife[0].length) rtn+=gridOfLife[n][q];
                        else if(q==-1) rtn+=gridOfLife[n][gridOfLife[0].length-1];
                        else rtn+=gridOfLife[n][0];
                    }
                }
                else if(n==gridOfLife.length-1){
                    for(int q=j-1;q<j+2;q++){
                        if(q>-1&&q<gridOfLife[0].length) rtn+=gridOfLife[0][q];
                        else if(q==-1) rtn+=gridOfLife[0][gridOfLife[0].length];
                        else rtn+=gridOfLife[0][0];
                    }
                }
                else{
                    for(int q=j-1;q<j+2;q++){
                        if(q>-1&&q<gridOfLife[0].length) rtn+=gridOfLife[gridOfLife.length-1][q];
                        else if(q==-1) rtn+=gridOfLife[gridOfLife.length-1][gridOfLife[0].length-1];
                        else rtn+=gridOfLife[gridOfLife.length-1][0];
                    }
                }
            }
            return rtn;
        }
        public int checkNeighbors2(int i, int j){
            int rtn=0;
            for(int n=i-1;n<i+2&&n<gridOfLife.length-1;n++){
                if(n>-1){
                    for(int q=j-1;q<j+2&&q<gridOfLife[0].length-1;q++){
                        if(q>-1&&!(n==i||q==j)) rtn+=gridOfLife[n][q];
                    }
                }
            }
            return rtn;
        }
        //returns the number of columns in the array
        public int getNumCols(){
            return gridOfLife[0].length;
        }
        // returns the number of rows in the array
        public int getNumRows(){ 
            return gridOfLife.length;
        }
    }
