public class LifeGrid{
    private int[][] gridOfLife;
    private final int ALIVE=1;
    private final int DEAD=0;
    /**
     * defines a lifeGrid to be used to represent cells in GameOfLife and allows the grid fo evolve according to Conway's game of life
     * 
     * full comments in GameOfLife.java
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
        //evolves the gridOfLife by one generation by checking the number of neighbors and comparing to the game rules
        public void evolve(){
            int[][] rtn=new int[gridOfLife.length][gridOfLife[0].length]; //temporary array for changing during method
            for(int i=0;i<rtn.length;i++){
                for(int n=0;n<rtn[i].length;n++){
                    int cN=checkNeighbors(i,n); //cN==current Neighbors
                    boolean cS=false; if(gridOfLife[i][n]==ALIVE) cS=true; //cS==current state in boolean form
                    if(cS) rtn[i][n]=ALIVE; //Set value in rtn to its setting in gridOfLife
                    if(cS&&!(cN==2||cN==3)) rtn[i][n]=DEAD; //change from alive to dead
                    else if(!cS&&cN==3) rtn[i][n]=ALIVE; //change from dead to alive
                    //if(cS||cN>0) System.out.println("("+i+", "+n+") "+cN); //used to test checkNeighbors
                }
            }
            gridOfLife=rtn; //releases the memeory of the old gridOfLife and replaces it with rtn
        }
        //returns the number of living neighbors around the specified element
        private int checkNeighbors(int i,int j){
            int rtn=0-gridOfLife[i][j]; //if the origin value will add, subtract to counteract
            for(int n=i-1;n<i+2;n++){ 
                if(n>-1&&n<gridOfLife.length){ //x-central
                    for(int q=j-1;q<j+2;q++){
                        if(q>-1&&q<gridOfLife[0].length) rtn+=gridOfLife[n][q]; //y-central, perform normally
                        else if(q==-1) rtn+=gridOfLife[n][gridOfLife[0].length-1];  //top-bound, consider the bottom value rather than the value above
                        else rtn+=gridOfLife[n][0]; //bottom-bound, consider the top value rather than the value below
                    }
                }
                else if(n==gridOfLife.length){ //right-bound, replaces all x values with 0 to prevent out of bounds and round the array

                    for(int q=j-1;q<j+2;q++){
                        if(q>-1&&q<gridOfLife[0].length) rtn+=gridOfLife[0][q];
                        else if(q==-1) rtn+=gridOfLife[0][gridOfLife[0].length-1];
                        else rtn+=gridOfLife[0][0];
                    }
                }
                else{ //left-bound by elimination, replaces all x values with the last value of the array, preventing out of bounds and rounding the array
                    for(int q=j-1;q<j+2;q++){
                        if(q>-1&&q<gridOfLife[0].length) rtn+=gridOfLife[gridOfLife.length-1][q];
                        else if(q==-1) rtn+=gridOfLife[gridOfLife.length-1][gridOfLife[0].length-1];
                        else rtn+=gridOfLife[gridOfLife.length-1][0];
                    }
                }
            }
            return rtn;
        }
        //Alternate way to consider checkNeighbors (not counting the original value), works but doesn't round the array
        public int checkNeighbors2(int i, int j){
            int rtn=0;
            for(int n=i-1;n<i+2&&n<gridOfLife.length-1;n++){
                if(n>-1){
                    for(int q=j-1;q<j+2&&q<gridOfLife[0].length-1;q++){
                        if(q>-1&&!(n==i||q==j)) rtn+=gridOfLife[n][q]; //If not the original value and in bounds, add the found value
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
