package Chapter19.Hex;
public class HexBoard {
    private char[][] matrix;
    public HexBoard(int x, int y){
        matrix=new char[x][y];
    }
    public HexBoard(){
        matrix=new char[20][20];
    }
    public static void main(String[] args){
        
    }
    public boolean setBlack(int x, int y){
        if(isValid(x,y)){ matrix[x][y]='b'; return true;}
        return false;
    }
    public boolean setWhite(int x,int y){
        if(isValid(x,y)){ matrix[x][y]='w'; return true;}
        return false;
    }
    public boolean isBlack(int x, int y){
        return matrix[x][y]=='b';
    }
    public boolean isWhite(int x,int y){
        return matrix[x][y]=='w';
    }
    public boolean isValid(int x, int y){
        return x<matrix.length&&y<matrix[0].length&&matrix[x][y]=='\u0000';
    }
    public boolean blackHasWon(){
        boolean rtn=false;
        //paint lines of black gray
        for(int i=0;i<matrix[0].length;i++){
            areaFill(0, i);
        }
        //if a gray square exists in the final row, set returned value to true
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[matrix.length-1][i]=='g') rtn=true;
        }
        //go back and repaint gray to black
        for(int i=0;i<matrix.length;i++){
            for(int n=0;n<matrix[i].length;n++){
                if(matrix[i][n]=='g') matrix[i][n]='b';
            }
        }
        return rtn;
    }
    public void areaFill(int x, int y){
        if(isValid(x,y)&&isBlack(x, y)){
            matrix[x][y]='g';
            areaFill(x-1,y-1);
            areaFill(x-1,y);
            areaFill(x,y-1);
            areaFill(x,y+1);
            areaFill(x+1,y);
            areaFill(x+1,y+1);
        }
    }
}
