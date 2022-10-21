public class MatrixAlgebra{
    public static void main(String args[]){
        testMethod();
    }
    private static void testMethod(){
        //matrixMultiplication() tests
        printArray(matrixMultiplication(new int[][] {{1,2},{3,4}}, new int[][] {{1,2,3},{4,5,6}}));System.out.println("Should be:");printArray(new int[][] {{9,12,15},{19,26,33}});System.out.println();
        printArray(matrixMultiplication(new int[][] {{1,2},{3,4}}, new int[][] {{1,2,3},{4,5,6},{7,8,9}}));System.out.println("Should be: null");System.out.println();
        printArray(matrixMultiplication(new int[][] {{0,0,0},{0,0,0}}, new int[][] {{3,4,5},{6,7,8},{1,2,3}}));System.out.println("Should be: ");printArray(new int[][] {{0,0,0},{0,0,0}});System.out.println();
        //addMatrices() Tests
        printArray(addMatrices(new int[][] {{1,1},{1,1}}, new int[][] {{1,1},{1,1}}));System.out.println("Should be: ");printArray(new int[][] {{2,2},{2,2}});System.out.println();
        printArray(addMatrices(new int[][] {{1,2,3},{1,2,3}}, new int[][]{{1,2,3},{1,2,3}}));System.out.println("Should be:");printArray(new int[][] {{2,4,6},{2,4,6}});System.out.println();
        printArray(addMatrices(new int[][] {{2,2,2},{2,2,2},{2,2,2}}, new int[][] {{3,3,3},{3,3,3},{3,3,3}}));System.out.println("Should be:");printArray(new int[][] {{5,5,5},{5,5,5},{5,5,5}});System.out.println();
    }
    private static void printArray(int[][] m){
        if(m==null){
            System.out.println("null");
            return;
        }
        for(int[] i:m){
            for(int n:i){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
    private static int[][] addMatrices(int[][] m1, int[][] m2){
        if(m1.length!=m2.length||m1[0].length!=m2[0].length) return null;
        int[][] rtn=new int[m1.length][m1[0].length];
        if(isSquare(m1)&&isSquare(m2)){
            for(int i=0;i<m1.length;i++){
                for(int n=0;n<m1[0].length;n++){
                    rtn[i][n]=m1[i][n]+m2[i][n];
                }
            }
        }
        return rtn;
    }
    //Multiplies two matrices together and returns the product
    private static int[][] matrixMultiplication(int[][] m1, int[][] m2){
        int[][] rtn=new int[m1.length][m2[0].length]; //hold array to be returned
        if(!isSquare(m1)||!isSquare(m2)||!(m1[0].length==m2.length)) return null; //if arrays are able ot be matrices (all rows are the same length)
            for(int i=0;i<rtn.length;i++){ //traverse the array
                for(int n=0;n<rtn[0].length;n++){ //traverse the array
                    int hold=0; //reset the value for the next index of the returned array
                    for(int q=0;q<m1.length;q++){ //go across m1 and down m2 using the same variable
                        hold+=m1[i][q]*m2[q][n]; //Add to the value to be used in the returned array
                    }
                    rtn[i][n]=hold; //set the rtn value to the found value
                }
            }
        return rtn;
    }
    public static boolean isSquare(int[][] m){
        int length=m[0].length;
        for(int i=0;i<m.length;i++){
            if(m[i].length!=length) return false;
        }
        return true;
    }
}