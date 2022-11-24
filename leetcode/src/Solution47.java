

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> returnList=new ArrayList<List<Integer>>();
        returnList.add(new ArrayList<Integer>());

        for(int i=0;i<num.length;i++){
            Set<List<Integer>> currentSet=new HashSet<List<Integer>>();
            for(List<Integer> l:returnList){
                for(int j=0;j<l.size()+1;j++){
                    l.add(j,num[i]);
                    List<Integer> T=new ArrayList<Integer>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            returnList=new ArrayList<List<Integer>>(currentSet);
        }
        return returnList;
    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = solution47.permuteUnique(nums);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(0,2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}