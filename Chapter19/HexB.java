package Chapter19;

public class HexB {
    char[][] m;
    public static void main(String[] args){
        HexB b=new HexB();
        b.blackWins();
        System.out.println(b.blackWinRecursive());

    }
    public HexB(){
        m=new char[20][20];
    }
    public void blackWins(){
        for(int i=0;i<m.length;i++){
            m[i][5]='b';
        }
    }
    public boolean isValid(int x, int y){
        return x>0&&x<m.length&&y<m[0].length&&y>0;
    }
    public void setBlack(int x, int y){
        m[x][y]='b';
    }
    public boolean isBlack(int x, int y){
        return m[x][y]=='b';
    }
    public boolean blackWin(){
        for(int i=0;i<m[0].length;i++){
            grayScale(0, i);
        }
        for(int i=0;i<m[m.length-1].length;i++){
            if(isBlack(m.length-1, i)){
                for(int n=0;n<m.length;n++){
                    for(int q=0;q<m[n].length;q++){
                        if(m[n][q]=='g')m[n][q]='b';
                    }
                }
                return true;
            }
        }
        return false;
    }
    public void grayScale(int x, int y){
        if(isValid(x, y)&&isBlack(x, y)){
            m[x][y]='g';
            grayScale(x-1, y);
            grayScale(x+1, y);
            grayScale(x, y-1);
            grayScale(x, y+1);
            grayScale(x+1, y+1);
            grayScale(x-1, y-1);
        }
    }
    public boolean blackWinRecursive(){
        for(int i=0;i<m[0].length;i++){
            if(aFR(m.length, i)) return true;
        }
        return false;
    }
    public boolean aFR(int x, int y){
        if(isValid(x,y)&&x==m.length-1) return true;
        if(isValid(x,y)&&isBlack(x, y)){
            return aFR(x-1, y)||aFR(x+1, y)||aFR(x, y-1)||aFR(x, y+1)||aFR(x+1, y+1)||aFR(x-1, y-1);
        }
        return false;
    }

}
