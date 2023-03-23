package Chapter19.Hex;
public class HexBoard {
    private char[][] matrix;
    /**
     * defines a board with defined bounds
     * @param x
     * @param y
     */
    public HexBoard(int x, int y){
        matrix=new char[x][y];
        for(int i=0;i<x;i++){
            for(int n=0;n<y;n++){
                matrix[n][i]='q';
            }
        }
    }
    /**
     * defines a board with default bounds 20x20
     */
    public HexBoard(){
        matrix=new char[20][20];
        for(int i=0;i<20;i++){
            for(int n=0;n<20;n++){
                matrix[i][n]='q';
            }
        }
    }
    public static void main(String[] args){
        HexBoard board=new HexBoard();
        for(int i=0;i<board.xLength();i++){
            board.setBlack(5,i);
        }
        board.printBoard();
        System.out.println(board.blackHasWon());
    }
    public int xLength(){
        return matrix.length;
    }
    public int yLength(){
        return matrix[0].length;
    }
    public void printBoard(){
        System.out.println(matrix.length+"x"+matrix[0].length);
        for(int i=0;i<matrix.length;i++){
            for(int n=0;n<matrix[i].length;n++){
                System.out.print(matrix[i][n]+" ");
            }
            System.out.println();
        }

    }
    /**
     * sets the defined position to black
     * @param x
     * @param y
     */
    public void setBlack(int x, int y){
        if(isValid(x,y)) matrix[x][y]='b';
        else System.out.println("SET BLACK FAILED");
    }
    /**
     * set the defined position to white
     * @param x
     * @param y
     */
    public void setWhite(int x, int y){
        if(isValid(x,y)) matrix[x][y]='w';
    }
    /**
     * returns whether the defined position is black
     * @param x
     * @param y
     * @return
     */
    public boolean isBlack(int x, int y){
        return isValid(x,y)&&matrix[x][y]=='b';
    }
    /**
     * returns whether the defined position is white
     * @param x
     * @param y
     * @return
     */
    public boolean isWhite(int x, int y){
        return isValid(x,y)&&matrix[x][y]=='w';
    }
    /**
     * checks whether a point is in bounds and unclaimed
     * @param x
     * @param 
     * @return
     */
    public boolean isValid(int x, int y){
        return x<matrix.length&&y<matrix[0].length&&matrix[x][y]=='q';
    }
    /**
     * decides whether black has won using areaFill()
     * @return whether black has won or not
     */
    public boolean blackHasWon(){
        boolean rtn=false;
        //paint lines of black gray
        for(int i=0;i<matrix[0].length;i++){
            char b=matrix[0][i];
            areaFill(0, i);
        }
        //if a gray square exists in the final row, set returned value to true
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[matrix.length-1][i]=='g'){
                char b=matrix[matrix.length-1][i];
                rtn=true;
                for(int q=0;q<matrix.length;q++){ //go back and repaint gray to black
                    for(int n=0;n<matrix[q].length;n++){
                        if(matrix[q][n]=='g'){ matrix[q][n]='b';System.out.println("x");}
                    }
                }
                break;
            } 
        }
       
        
        return rtn;
    }
    /**
     * turn all connected black squares gray
     * @param x
     * @param y
     */
    public void areaFill(int x, int y){
        if(isValid(x,y)&&matrix[x][y]=='b'){
            matrix[x][y]='g';
            areaFill(x-1,y-1);
            areaFill(x-1,y);
            areaFill(x,y-1);
            areaFill(x,y+1);
            areaFill(x+1,y);
            areaFill(x+1,y+1);
        }
    }
    /**
     * returns true if there exists a black line connecting the left and right side of the board using areaFillRecursive
     * @return
     */
    public boolean blackHasWonRecursive(){
        for(int i=0;i<matrix[0].length;i++){
            if(areaFillRecursive(0, i)) return true;
        }
        return false;
    }
    /**
     * returns true if the line connects to the other end of the board
     * @param x
     * @param y
     * @return
     */
    public boolean areaFillRecursive(int x, int y){
        if(x==matrix.length-1) return true;
        if(isValid(x,y)&&matrix[x][y]=='b'){
            return areaFillRecursive(x-1,y-1)||areaFillRecursive(x-1,y)||areaFillRecursive(x,y-1)||areaFillRecursive(x,y+1)||areaFillRecursive(x+1,y)||areaFillRecursive(x+1,y+1);
        }
        return false;
    }
}
