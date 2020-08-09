package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<int[]>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < restaurants.length; i++) {
            if(restaurants[i][2]>=veganFriendly&&restaurants[i][3]<=maxPrice&&restaurants[i][4]<=maxDistance){
                list.add(restaurants[i]);
            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o2[0]-o1[0];
                }
                return o2[1]-o1[1];
            }
        });

        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i)[0]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] restaurants= {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};

        Solution1333 s = new Solution1333();
        s.filterRestaurants(restaurants,0,50,10);
        System.out.println("\n");
    }
}
