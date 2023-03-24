package Chapter19;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 3/29/2023
 * Assignment: Ch19 Hex Game Lab
 * 
 * Attribution: Grace Boerner was my partner
 */
public class HexBoard {
    char[][] m;
    public static void main(String[] args){
        HexBoard b=new HexBoard();
        b.blackWins();
        System.out.println(b.blackWinRecursive());
        System.out.println(b.blackWin());
        System.out.println("Both should be true (unclaimed indices are not marked, black-claimed are labeled with 'b')");
        for(int i=0;i<b.xSize();i++){
            for(int n=0;n<b.ySize();n++){
                System.out.print(b.get(n,i));
            }
            System.out.println();
        }
    }
    /**
     * default constructor, sets 20x20 size
     */
    public HexBoard(){
        m=new char[20][20];
    }
    /**
     *  returns size of overlaying array
     * */
    public int xSize(){
        return m.length;
    }
    /**
     * returns size of internal arrays
     * @return
     */
    public int ySize(){
        return m[0].length;
    }
    /**
     * returns value at specified index
     * @param x
     * @param y
     * @return
     */
    public char get(int x, int y){
        if(isValid(x, y)) return m[x][y];
        System.out.println(x+","+y);
        return 'x';
    }
    /**
     * forces black win for testing
     */
    public void blackWins(){
        for(int i=0;i<m.length;i++){
            m[i][5]='b';
        }
    }
    /**
     * checks if specified index is in bounds
     * @param x
     * @param y
     * @return
     */
    public boolean isValid(int x, int y){
        return x>=0&&x<m.length&&y<m[0].length&&y>=0;
    }
    /**
     * sets specified index to black
     * @param x
     * @param y
     */
    public void setBlack(int x, int y){
        m[x][y]='b';
    }
    /**
     * returns true if the specified index is black
     * @param x
     * @param y
     * @return
     */
    public boolean isBlack(int x, int y){
        return m[x][y]=='b';
    }
    /**
     * draws line between adjacent black indices using areaFill() and checks whether the line reaches the end
     * @return true if balck has won, false if not
     */
    public boolean blackWin(){
        for(int i=0;i<m[0].length;i++){
            areaFill(0, i);
        }
        for(int i=0;i<m[m.length-1].length;i++){
            if(m[m.length-1][i]=='g'){
                sanitation();
                return true; 
            }
        }
        sanitation();
        return false;
    }
    /**
     * returns all gray indices back to black
     */
    public void sanitation(){
        for(int n=0;n<m.length;n++){
            for(int q=0;q<m[n].length;q++){
                if(m[n][q]=='g')m[n][q]='b';
            }
        }
    }
    /**
     * draws gray line between adjacent black indices (if black, set gray and check surrounding indices)
     * @param x
     * @param y
     */
    public void areaFill(int x, int y){
        if(isValid(x, y)&&isBlack(x, y)){
            m[x][y]='g';
            areaFill(x, y);
            areaFill(x+1, y);
            areaFill(x, y-1);
            areaFill(x, y+1);
            areaFill(x+1, y+1);
            areaFill(x-1, y-1);
        }
    }
    /**
     * checks whether black has won using recursion in areaFillRecursive()
     * @return true if black has won, false if not
     */
    public boolean blackWinRecursive(){
        boolean rtn=false;
        for(int i=0;i<m[0].length;i++){
            if(fillRecursive(0, i)) rtn=true;
        }
        sanitation();
        return rtn;
    }
    /**
     * draws gray line between connected black indices using recursion (if black, check surrounding indices)(if on edge, return true for win)
     * @param x
     * @param y
     * @return
     */
    public boolean fillRecursive(int x, int y){
        if(isValid(x,y)&&x==m.length-1) return true;
        if(isValid(x,y)&&isBlack(x, y)){
            m[x][y]='g';
            return fillRecursive(x-1, y)||fillRecursive(x+1, y)||fillRecursive(x, y-1)||fillRecursive(x, y+1)||fillRecursive(x+1, y+1)||fillRecursive(x-1, y-1);
        }
        return false;
    }
}