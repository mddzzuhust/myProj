package leetcode;

public class Solution397 {
    public int integerReplacement(int n) {
        int[] ret = new int[33];
        int tmp = n;
        int length = 0;
        while (tmp != 0){
            ret[length] = tmp%2;
            length++;
            tmp = tmp/2;
        }

        int count = 0;
        int index = 0;
        while (index < length){
            if(ret[index] == 0){
                index++;
                count++;
            }else {
                break;
            }
        }

        int start = index, end = index;
        while (end < length){
            while (ret[end] == 1 && end < length){
                end++;
            }

            if(end == length){
                if(end - start > 2){
                    count = count + end - start +1;
                }else if(end - start == 2){
                    count = count + 2;
                }
                break;
            }

            if(end - start == 0){
                count++;
                start++;
                end++;
            }else if(end - start == 1){
                count = count + 2;
                start = end;
            }else {
                count = count + end - start +1;
                ret[end] = 1;
                start = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution397 s = new Solution397();
        System.out.println(s.integerReplacement(3));
    }
}
