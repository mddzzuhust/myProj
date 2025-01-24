package byteDance;

public class Solution48 {
    public void rotate(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return;
        }

        int row=matrix.length;
        int col=matrix[0].length;
        int[][] result=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                result[i][j]=matrix[row-1-j][i];
            }
        }
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++){
                matrix[i][j]=result[i][j];
            }
        }
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args){
        Solution48 s=new Solution48();
        int[][] matrix=new int[6][6];
        int count=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                matrix[i][j]=count;
                count++;
            }
        }
        s.rotate(matrix);
    }
}
