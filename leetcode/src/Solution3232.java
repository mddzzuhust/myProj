public class Solution3232 {
    public boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;
        for(int num : nums){
            if(num < 10){
                singleDigitSum += num;
            }else {
                doubleDigitSum += num;
            }
        }
        return singleDigitSum != doubleDigitSum;
    }
}
