package byteDance;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] a) {
        List list=new ArrayList();
        if(a.length==0||a[0].length==0) return list;

        boolean[][] b=new boolean[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                b[i][j]=false;
            }
        }
        int i=0,j=0;
        int o=0;
        while(i<a.length&&i>=0&&j<a[0].length&&j>=0){
            if(b[i][j]==true) break;
            list.add(a[i][j]);
            switch(o){
                case 0:
                    if(j==a[0].length-1||b[i][j+1]==true){
                        b[i][j]=true;
                        o=1;
                        i++;
                    }else{
                        b[i][j]=true;
                        j++;
                    }
                    break;
                case 1:
                    if(i==a.length-1||b[i+1][j]==true){
                        b[i][j]=true;
                        o=2;
                        j--;
                    }else{
                        b[i][j]=true;
                        i++;
                    }
                    break;
                case 2:
                    if(j==0||b[i][j-1]==true){
                        b[i][j]=true;
                        o=3;
                        i--;
                    }else{
                        b[i][j]=true;
                        j--;
                    }
                    break;
                case 3:
                    if(i==0||b[i-1][j]==true){
                        b[i][j]=true;
                        o=0;
                        j++;
                    }else{
                        b[i][j]=true;
                        i--;
                    }
                    break;
            }
        }
        return list;
    }
}
