package search;

/*
给你一个满足下述两条属性的 m x n 整数矩阵：

每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
[[1,3,5,7],
[10,11,16,20],
[23,30,34,60]]
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] m, int target) {
        //两个二分搜索
        //先搜索第一列，找到确定的行，然后再搜索行
        int i = 0;
        int j = m.length-1;
        int mid = 0;
        //搜寻第一列
        while(i <= j){
            mid = (i + j)/2;
            if(m[mid][0] == target){
                return true;
            }else if(m[mid][0] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        if(m[mid][0] > target){
            if(mid == 0){
                return false;
            }
            mid--;//mid-1
        }
        //搜寻mid行
        i = 0;
        j = m[0].length -1;
        int k = mid;
        //搜寻到了返回true
        while(i <= j){
            mid = (i + j)/2;
            if(m[k][mid] == target){
                return true;
            }else if(m[k][mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        //没有搜寻到，返回false
        return false;
    }
    public static void main(String[] args){
        SearchMatrix s = new SearchMatrix();
    }
}
