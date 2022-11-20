package leetcode;

import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    public boolean remove(int val) {
        if(!idx.containsKey(val)){
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if(i<nums.size() - 1){
            idx.get(lastNum).add(i);
        }
        if(idx.get(val).size() == 0 ){
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
